package com.gsm.jupjup.controller.v1;

import com.google.gson.JsonObject;

import com.gsm.jupjup.common.CookieUtil;
import com.gsm.jupjup.common.JwtUtil;
import com.gsm.jupjup.common.RedisUtil;
import com.gsm.jupjup.domain.AuthDomain;
import com.gsm.jupjup.dto.v1.auth.AuthLoginRequest;
import com.gsm.jupjup.dto.v1.auth.AuthSaveRequestDto;
import com.gsm.jupjup.service.v1.auth.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RequestMapping("/api/v1")
@RestController
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CookieUtil cookieUtil;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/signup")
    public String signUpUser(@RequestBody AuthSaveRequestDto authSaveRequestDto){
        JsonObject obj = new JsonObject();
        try {
            authService.SignUpUser(authSaveRequestDto);
            obj.addProperty("success", "회원가입 성공");
        } catch (Exception e){
            System.out.println(e);
            obj.addProperty("msg", String.valueOf(e));
        }
        return obj.toString();
    }

    @ResponseBody
    @PostMapping("/login")
    public String Login(@RequestBody AuthLoginRequest authLoginRequest,
                        HttpServletRequest req, HttpServletResponse res) throws Exception {
        JsonObject obj = new JsonObject();
        try {
            final AuthDomain authDomain = authService.loginUser(authLoginRequest);
            final String token = jwtUtil.generateToken(authDomain);
            final  String refreshJwt = jwtUtil.generateRefreshToken(authDomain);

            Cookie accessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, token);
            Cookie refreshToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, refreshJwt);
            redisUtil.setDataExpire(refreshJwt, authDomain.getEmail(), JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);

            res.addCookie(accessToken);
            res.addCookie(refreshToken);

            obj.addProperty("email", authDomain.getEmail());
            obj.addProperty("classNumber", authDomain.getClassNumber());
            obj.addProperty("token", token);
        } catch (Exception e){
            System.out.println(e);
            obj.addProperty("msg", String.valueOf(e));
        }
        return obj.toString();
    }

    @GetMapping("/coffe")
    public String coffe(){
        JsonObject obj = new JsonObject();

        obj.addProperty("msg", "asdf");
        return obj.toString();
    }
}