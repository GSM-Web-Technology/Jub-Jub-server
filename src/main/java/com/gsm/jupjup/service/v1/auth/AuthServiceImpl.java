package com.gsm.jupjup.service.v1.auth;

import com.gsm.jupjup.dao.AuthRepository;
import com.gsm.jupjup.domain.AuthDomain;
import com.gsm.jupjup.domain.Salt;
import com.gsm.jupjup.dto.v1.auth.AuthLoginRequest;
import com.gsm.jupjup.dto.v1.auth.AuthSaveRequestDto;
import com.gsm.jupjup.service.v1.salt.SaltUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private AuthRepository authRepository;

    //회원가입
    @Override
    public void SignUpUser(AuthDomain authDomain) {
        String password = authDomain.getPassword();
        String salt = SaltUtil.genSalt();
        System.out.print(salt);
        authDomain.setSalt(new Salt(salt));
        authDomain.setPassword(SaltUtil.encodePassword(salt, password));
        authRepository.save(authDomain);
    }

    //로그인
    @Override
    public AuthDomain loginUser(String email, String password) throws Exception {
        AuthDomain authDomain = authRepository.findByEmail(email);
        if(authDomain == null) throw new Exception("멤버가 조회되지 않음");
        String salt = authDomain.getSalt().getSalt();
        password = SaltUtil.encodePassword(salt, password);
        if(!authDomain.getPassword().equals(password))
            throw new Exception("비밀번호가 틀립니다");
        return authDomain;
    }

    //회원가입
//    @Transactional
//    public Long SingUp(AuthSaveRequestDto authSaveRequestDto){
//        return authRepository.save(authSaveRequestDto.toEntity()).getAuth_Idx();
//    }
//
//    @Transactional
//    public AuthDomain Login(AuthLoginRequest authLoginRequest){
//        return authRepository.findByEmailAndPassword(authLoginRequest.getEmail(), authLoginRequest.getPassword());
//    }
}
