package com.gsm.jupjup.service.v1.auth;

import com.gsm.jupjup.dao.AuthRepository;
import com.gsm.jupjup.domain.AuthDomain;
import com.gsm.jupjup.dto.v1.auth.AuthLoginRequest;
import com.gsm.jupjup.dto.v1.auth.AuthSaveRequestDto;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthRepository authRepository;


    @Override
    public void SignUpUser(AuthSaveRequestDto authSaveRequestDto) throws Exception {
        AuthDomain authDomain = authRepository.findByEmail(authSaveRequestDto.getEmail());
        String email = authSaveRequestDto.getEmail();
        String password = authSaveRequestDto.getPassword();
        String name = authSaveRequestDto.getPassword();
        String classNumnber = authSaveRequestDto.getClassNumber();
        int c_len = authSaveRequestDto.getClassNumber().length();

        if(authDomain.getEmail() != null)
            throw new Exception("이메일 중복");
        if(c_len < 4)
            throw new Exception("ClassNumber는 4자리입니다.");
        if(isValidEmail(authSaveRequestDto.getEmail()) == false)
            throw new Exception("이메일 형식을 지켜주세요");
        if(email.isEmpty() && password.isEmpty() && name.isEmpty() && classNumnber.isEmpty())
            throw new Exception("전부 입력해주세요");

        PasswordEncoder passwordEncoder = new PasswordEncoding();
        String newPassword1 = passwordEncoder.encode(authSaveRequestDto.getPassword());
        System.out.println(newPassword1);
        authSaveRequestDto.setPassword(newPassword1);
        authRepository.save(authSaveRequestDto.toEntity());
    }

    public static boolean isValidEmail(String email) {
        boolean err = false;
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if(m.matches()) {
            err = true;
        }
        return err;
    }

    @Override
    public AuthDomain loginUser(AuthLoginRequest authLoginRequest) throws Exception {
        PasswordEncoder passwordEncoder = new PasswordEncoding();
        AuthDomain authDomain = authRepository.findByEmail(authLoginRequest.getEmail());
        if(authDomain == null) {
            throw new Exception("멤버가 조회되지 않음");
        }
        if(passwordEncoder.matches(authLoginRequest.getPassword(), authDomain.getPassword()) == false) {
            throw new Exception ("비밀번호가 틀립니다.");
        }
        return authDomain;
    }
}