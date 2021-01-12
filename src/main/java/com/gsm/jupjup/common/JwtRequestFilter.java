//package com.gsm.jupjup.common;
//
//import com.gsm.jupjup.dao.AuthRepository;
//import com.gsm.jupjup.domain.AuthDomain;
//import io.jsonwebtoken.ExpiredJwtException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//@Component
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Autowired
//    private CookieUtil cookieUtil;
//
//    @Autowired
//    private RedisUtil redisUtil;
//
//    @Autowired
//    private AuthRepository authRepository;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//        final Cookie jwtToken = cookieUtil.getCookie(httpServletRequest, JwtUtil.ACCESS_TOKEN_NAME);
//
//        String userEmail = null;
//        String jwt = null;
//        String refreshJwt = null;
//        String refreshUemail = null;
//
//        try {
//            if(jwtToken != null){
//                jwt = jwtToken.getValue();
//                userEmail = jwtUtil.getUserEmail(jwt);
//            }
//            if(userEmail != null){
//                AuthDomain authDomain = authRepository.findByEmail(userEmail);
//
//                if(jwtUtil.validateToken(jwt, authDomain)){
////                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authDomain,null,userDetails.getAuthorities());
////                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
////                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//                }
//            }
//        } catch (ExpiredJwtException e){
//            Cookie refreshToken = cookieUtil.getCookie(httpServletRequest,JwtUtil.REFRESH_TOKEN_NAME);
//            if(refreshToken!=null){
//                refreshJwt = refreshToken.getValue();
//            }
//        } catch (Exception e){
//
//        }
//
//        try {
//            if(refreshJwt != null){
//                refreshUemail = redisUtil.getData(refreshJwt);
//
//                if(refreshUemail.equals(jwtUtil.getUserEmail(refreshJwt))){
////                    AuthDomain authDomain = authRepository.findByEmail(refreshUemail);
////                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authDomain,null,userDetails.getAuthorities());
////                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
////                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//
//                    AuthDomain member = new AuthDomain();
//                    member.setEmail(refreshUemail);
//                    String newToken = jwtUtil.generateToken(member);
//
//                    Cookie newAccessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME,newToken);
//                    httpServletResponse.addCookie(newAccessToken);
//                }
//            }
//        } catch (ExpiredJwtException e){
//
//        }
//
//        filterChain.doFilter(httpServletRequest,httpServletResponse);
//    }
//}