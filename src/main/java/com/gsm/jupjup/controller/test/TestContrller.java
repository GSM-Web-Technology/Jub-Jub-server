package com.gsm.jupjup.controller.test;

import com.gsm.jupjup.domain.TestDomain;
import com.gsm.jupjup.dto.test.TestResponseDto;
import com.gsm.jupjup.dto.test.TestSaveRequestDto;
import com.gsm.jupjup.dto.test.TestUpdateRequestDto;
import com.gsm.jupjup.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/testapi")
public class TestContrller {

    //DI(의존성 주입)
    @Autowired
    private TestService testService;

    //게시물 저장 컨트롤러(엔트포인트)
    @PostMapping("/test")
    //body로 Dto에 있는 값 모두 받기(title, content, author)
    public Long save(@RequestBody TestSaveRequestDto testSaveRequestDto){
        return testService.save(testSaveRequestDto);
    }

    //한개 게시물 찾기 컨틀롤러(엔드포인트)
    @GetMapping("/test/{id}")
    //URL 파라미터로 id값 받기
    public TestResponseDto findById(@PathVariable Long id){
        return testService.findById(id);
    }

    //게시물 삭제 컨트롤러(엔드포인트)
    @DeleteMapping("/test/{id}")
    public Long delete(@PathVariable Long id){
        testService.delete(id);
        return id;
    }

    //게시물 수정 컨트롤러(엔트포인트)
    @PutMapping("/test/{id}")
    public Long update(@PathVariable Long id, @RequestBody TestUpdateRequestDto testUpdateRequestDto){
        return testService.update(id, testUpdateRequestDto);
    }
}