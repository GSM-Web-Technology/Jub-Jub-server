package com.gsm.jupjup.controller.v1;

import com.google.gson.JsonObject;
import com.gsm.jupjup.common.CookieUtil;
import com.gsm.jupjup.common.RedisUtil;

import com.gsm.jupjup.domain.AuthDomain;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import com.gsm.jupjup.dto.v1.auth.AuthLoginRequest;
import com.gsm.jupjup.dto.v1.auth.AuthSaveRequestDto;
import com.gsm.jupjup.service.v1.auth.AuthServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Optional;

@RequestMapping("/api/v1")
@RestController
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;

//    @Autowired
//    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public String  signUpUser(@RequestBody AuthSaveRequestDto authSaveRequestDto){
        JsonObject obj = new JsonObject();
        try {
            authService.SignUpUser(authSaveRequestDto);
            obj.addProperty("msg", "success");
            obj.addProperty("1", "회원가입을 성공적으로 완료했습니다");
        } catch (Exception e){
            obj.addProperty("msg", "failed");
            obj.addProperty("1", "회원가입을 하는 도중 오류가 발생했습니다");
        }
        return obj.toString();
    }

    @ResponseBody
    @PostMapping("/login")
    public String Login(@RequestBody AuthLoginRequest authLoginRequest) throws Exception {
        JsonObject obj = new JsonObject();
        try {
            AuthDomain authDomain = authService.loginUser(authLoginRequest);
            obj.addProperty("email", authDomain.getEmail());
            obj.addProperty("classNumber", authDomain.getClassNumber());
        } catch (Exception e){
            System.out.println(e);
            obj.addProperty("msg", "로그인 실패");
        }
        return obj.toString();
    }
}
