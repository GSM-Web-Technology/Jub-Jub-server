package com.gsm.jupjup.service;

import com.gsm.jupjup.domain.AuthDomain;
import com.gsm.jupjup.dto.v1.auth.AuthLoginRequest;
import com.gsm.jupjup.service.v1.auth.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Test
    public void signUp(){
        AuthDomain authDomain = AuthDomain.builder()
                .email("s19066@gsm.hs.kr")
                .password("1234")
                .name("김상현")
                .classNumber("2101")
                .build();
        authService.SignUpUser(authDomain);
    }

    @Test
    public void login(){
        AuthLoginRequest loginRequest = new AuthLoginRequest("s19066@gsm.hs.kr", "1234");

        try {
            authService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
            System.out.print("로그인 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
