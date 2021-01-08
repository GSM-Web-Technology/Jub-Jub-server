package com.gsm.jupjup.common;

import com.gsm.jupjup.dto.v1.auth.AuthLoginRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class jwtUtil {

    public final static long TOKEN_VALIDATION_SECOND = 1000L * 10;
    public final static long REFRESH_TOKEN_VALIDATION_SECOND = 1000L * 60 * 24 * 2;

    final static public String ACCESS_TOKEN_NAME = "accessToken";
    final static public String REFRESH_TOKEN_NAME = "refreshToken";

    @Value("${spring.jwt.secret}")
    private String SECRET_KEY;

    private static Key getSigningKey(String secretKey) {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Claims extractAllClaims(String token) throws ExpiredJwtException {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey(SECRET_KEY))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUserEmail(String token){
        return extractAllClaims(token).get("userEmail", String.class);
    }

    public Boolean isTokenExpired(String token) {
        final Date expiration = extractAllClaims(token).getExpiration();
        return expiration.before(new Date());
    }

//    public String generateToken(AuthLoginRequest authLoginRequest) {
//        return jwtToken(authLoginRequest.getEmail(), REFRESH_TOKEN_VALIDATION_SECOND);
//    }

    public String generateRefreshToken(AuthLoginRequest authLoginRequest) {
        return doGenerateToken(authLoginRequest.getEmail(), REFRESH_TOKEN_VALIDATION_SECOND);
    }

    public String doGenerateToken(String userEmail, long expireTime){
        Claims claims = Jwts.claims();
        claims.put("userEmail", userEmail);
            String jwt = Jwts.builder()
                    .setClaims(claims)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + expireTime))
                    .signWith(getSigningKey(SECRET_KEY), SignatureAlgorithm.HS256)
                    .compact();
            return jwt;
    }


    public String jwtToken(String email){
//        String jwtString = Jwts.builder()
//                .setHeaderParam("issueDate", System.currentTimeMillis())
//                .compact();
        String jwtString = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("issueDate", System.currentTimeMillis())
                .setSubject(email)
                .signWith(getSigningKey(SECRET_KEY), SignatureAlgorithm.HS256)
                .compact();
        return jwtString;
    }



    public Boolean validateToken(String token, UserDetails userDetails) {
        final String userEmail = getUserEmail(token);

        return (userEmail.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
