package com.gsm.jupjup.common;

import com.gsm.jupjup.dto.v1.auth.AuthLoginRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

//@Component
//public class JwtUtil {
//
//    private static final String headerString = "X-JWT";
//    @Value("${spring.jwt.secret}")
//    private String secretKey;
//    private byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
//    private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//    private final Key KEY = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
//
//
//    public String getUserToken(AuthLoginRequest authLoginRequest) {
//        String jwt = Jwts.builder()
//                .setHeaderParam("typ", "JWT")
//                .setSubject(authLoginRequest.getEmail())
//                .claim("email", authLoginRequest.getEmail())
//                .setExpiration(new Date(System.currentTimeMillis() + 1 * (1000 * 60 * 60 * 24)))
//                .signWith(KEY, signatureAlgorithm)
//                .compact();
//
//        return jwt;
//    }
//}
