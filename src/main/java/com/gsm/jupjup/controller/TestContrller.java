package com.gsm.jupjup.controller;

import com.gsm.jupjup.domain.TestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContrller {

    @GetMapping("/user")
    public TestDTO testDTO(){
        TestDTO testDTO = new TestDTO();

        testDTO.setTitle("테스트1");
        testDTO.setContent("테스트1");

        return testDTO;
    }

}