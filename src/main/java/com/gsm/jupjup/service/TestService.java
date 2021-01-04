package com.gsm.jupjup.service;

import com.gsm.jupjup.dao.TestRepo;
import com.gsm.jupjup.domain.TestDomain;
import com.gsm.jupjup.dto.test.TestResponseDto;
import com.gsm.jupjup.dto.test.TestSaveRequestDto;
import com.gsm.jupjup.dto.test.TestUpdateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {

    @Autowired
    private TestRepo testRepo;

    @Transactional
    public Long save(TestSaveRequestDto testSaveRequestDto){
        return testRepo.save(testSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, TestUpdateRequestDto testUpdateRequestDto){
        TestDomain testDomain = testRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        testDomain.update(testUpdateRequestDto.getTitle(), testUpdateRequestDto.getContent());
        return id;
    }

    @Transactional
    public void delete(Long id){
        TestDomain testDomain = testRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        testRepo.delete(testDomain);
    }

    @Transactional(readOnly = true)
    public TestResponseDto findById(Long id){
        TestDomain testDomain = testRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return new TestResponseDto(testDomain);
    }
}
