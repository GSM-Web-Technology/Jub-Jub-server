package com.gsm.jupjup.controller.v1;

import com.google.gson.JsonObject;
import com.gsm.jupjup.domain.AuthDomain;
import com.gsm.jupjup.dto.v1.auth.AuthSaveRequestDto;
import com.gsm.jupjup.service.v1.auth.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;

//    @PostMapping("/signup")
//    public String signUpUser(@RequestBody AuthSaveRequestDto authSaveRequestDto){
//        JsonObject obj = new JsonObject();
//        try {
//            authService.SignUpUser(authSaveRequestDto);
//            obj.addProperty("msg", "success");
//            obj.addProperty("1", "회원가입을 성공적으로 완료했습니다");
//        } catch (Exception e){
//            obj.addProperty("msg", "failed");
//            obj.addProperty("1", "회원가입을 하는 도중 오류가 발생했습니다");
//        }
//        return obj.toString();
//    }

//
//    @ResponseBody
//    @PostMapping("/login")
//    public String Login(@RequestBody AuthLoginRequest authLoginRequest){
//        JsonObject obj = new JsonObject();
//        AuthDomain authDomain = authService.Login(authLoginRequest);
//        obj.addProperty("email", authDomain.getEmail());
//        obj.addProperty("classNumber", authDomain.getClassNumber());
//        return obj.toString();
//    }
}
