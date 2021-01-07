package com.gsm.jupjup.controller.v1;

import com.google.gson.JsonObject;
import com.gsm.jupjup.domain.AuthDomain;
import com.gsm.jupjup.dto.v1.auth.AuthLoginRequest;
import com.gsm.jupjup.dto.v1.auth.AuthSaveRequestDto;
import com.gsm.jupjup.service.v1.auth.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;

//    @ResponseBody
//    @PostMapping("/auth")
//    public String SignUp(@RequestBody AuthSaveRequestDto authSaveRequestDto){
//        JsonObject obj = new JsonObject();
//        authService.SingUp(authSaveRequestDto);
//        obj.addProperty("email", authSaveRequestDto.getEmail());
//        obj.addProperty("name", authSaveRequestDto.getName());
//        obj.addProperty("classNumber", authSaveRequestDto.getClassNumber());
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
