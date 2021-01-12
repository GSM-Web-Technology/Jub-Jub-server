package com.gsm.jupjup.service.v1.auth;

import com.gsm.jupjup.dao.AuthRepository;
import com.gsm.jupjup.domain.AuthDomain;
import com.gsm.jupjup.dto.v1.auth.AuthLoginRequest;
import com.gsm.jupjup.dto.v1.auth.AuthSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthRepository authRepository;


    @Override
    public void SignUpUser(AuthSaveRequestDto authSaveRequestDto) {
        PasswordEncoder passwordEncoder = new PasswordEncoding();
        System.out.println("============================================================");
        System.out.println("유저 저장 성공");
        //암호화
        String newPassword1 = passwordEncoder.encode(authSaveRequestDto.getPassword());
        System.out.println(newPassword1);
        authSaveRequestDto.setPassword(newPassword1);
        authRepository.save(authSaveRequestDto.toEntity());
        System.out.println("============================================================");
    }

    @Override
    public Optional<AuthDomain> loginUser(AuthLoginRequest authLoginRequest) throws Exception {
        PasswordEncoder passwordEncoder = new PasswordEncoding();
        AuthDomain authDomain = authRepository.findByEmail(authLoginRequest.getEmail());
        if(authDomain == null) {
            System.out.println("============================================================");
            throw new Exception("멤버가 조회되지 않음");
        }
        if(passwordEncoder.matches(authLoginRequest.getPassword(), authDomain.getPassword()) == false) {
            System.out.println("============================================================");
            throw new Exception ("비밀번호가 틀립니다.");
        }
        return authDomain;
    }
}
