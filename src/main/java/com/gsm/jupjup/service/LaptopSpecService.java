package com.gsm.jupjup.service;

import com.gsm.jupjup.dao.LaptopSpecRepository;
import com.gsm.jupjup.domain.LaptopSpecDomain;
import com.gsm.jupjup.domain.TestDomain;
import com.gsm.jupjup.dto.test.LaptopSaveRequestDto;
import com.gsm.jupjup.dto.test.LaptopSpecSaveRequestDto;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Temporal;

@Service
public class LaptopSpecService {

    //@Autowired 의존성 주입을 위해 사용하는 어노테이션.
    @Autowired
    private LaptopSpecRepository laptopSpecRepo;

    // Create.
    @Transactional
    public Long save(LaptopSpecSaveRequestDto laptopSpecSaveRequestDto){
        return laptopSpecRepo.save(laptopSpecSaveRequestDto.toEntity()).getSpec_Idx();
    }

//    //Update.
//    @Transactional
//    public String update(String laptopSpec_Idx, LaptopSpecSaveRequestDto laptopSpecSaveRequestDto){
//        LaptopSpecDomain laptopSpecDomain = (LaptopSpecDomain) laptopSpecRepo.findBySpec_Idx(laptopSpec_Idx).orElseThrow(() -> new IllegalIdentifierException("해당 사양의 노트북이 없습니다.:"+laptopSpec_Idx));
//        laptopSpecDomain.update(laptopSpecSaveRequestDto.getCPU(), laptopSpecSaveRequestDto.getGPU(), laptopSpecSaveRequestDto.getRAM(), laptopSpecSaveRequestDto.getSSD(), laptopSpecSaveRequestDto.getHDD());
//        return laptopSpec_Idx;
//    }

}
