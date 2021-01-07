package com.gsm.jupjup.service.v1.auth;

import com.gsm.jupjup.dao.AuthRepository;
import com.gsm.jupjup.domain.AuthDomain;
import com.gsm.jupjup.dto.v1.auth.AuthLoginRequest;
import com.gsm.jupjup.dto.v1.auth.AuthSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    //회원가입
    @Transactional
    public Long SingUp(AuthSaveRequestDto authSaveRequestDto){
        return authRepository.save(authSaveRequestDto.toEntity()).getAuth_Idx();
    }

    @Transactional
    public AuthDomain Login(AuthLoginRequest authLoginRequest){
        return authRepository.findByEmailAndPassword(authLoginRequest.getEmail(), authLoginRequest.getPassword());
    }

}
