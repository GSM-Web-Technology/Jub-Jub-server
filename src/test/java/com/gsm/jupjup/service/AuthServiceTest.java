package com.gsm.jupjup.service;

import com.gsm.jupjup.domain.AuthDomain;
import com.gsm.jupjup.dto.v1.auth.AuthLoginRequest;
import com.gsm.jupjup.dto.v1.auth.AuthSaveRequestDto;
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
        AuthSaveRequestDto authSaveRequestDto = AuthSaveRequestDto.builder()
                .email("s19066@gsm.hs.kr")
                .password("1234")
                .name("김상현")
                .classNumber("2101")
                .build();
        authService.SignUpUser(authSaveRequestDto);
    }

    @Test
    public void login(){
        AuthLoginRequest authLoginRequest = AuthLoginRequest.builder()
                .email("s19066@gsm.hs.kr")
                .password("1234")
                .build();

        try {
            authService.loginUser(authLoginRequest);
            System.out.println("============================================================");
            System.out.println("로그인 성공");
            System.out.println("============================================================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
