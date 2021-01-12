package com.gsm.jupjup.interceptor.auth;

import com.gsm.jupjup.dao.AuthRepository;
import com.gsm.jupjup.domain.AuthDomain;
import com.gsm.jupjup.service.v1.auth.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthRepository authRepository;

    private String HEADER_TOKEN_KEY = "token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AuthDomain authDomain = authRepository.findByEmail(request.getParameter("email"))
                .orElseThrow(() -> new IllegalArgumentException("없는 유저 입니다"));

        String givenToken = request.getHeader(HEADER_TOKEN_KEY);
        verifyToken(givenToken, authDomain.getToken());

        return true;
    }

    public void verifyToken(String givenToken, String membersToken){
        if(!givenToken.equals(membersToken)){
            throw new IllegalArgumentException("사용자의 Token이 일치하지 않습니다");
        }

        jwtUtil.verifyToken(givenToken);
    }
}
