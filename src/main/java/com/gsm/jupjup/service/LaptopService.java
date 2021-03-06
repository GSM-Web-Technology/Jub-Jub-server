package com.gsm.jupjup.service;

import com.gsm.jupjup.dao.LaptopRepository;
import com.gsm.jupjup.dao.LaptopSpecRepository;
import com.gsm.jupjup.domain.LaptopDomain;
import com.gsm.jupjup.domain.LaptopSpecDomain;
import com.gsm.jupjup.dto.test.LaptopResponseDto;
import com.gsm.jupjup.dto.test.LaptopSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepo;

    @Autowired
    private LaptopSpecRepository laptopSpecRepository;

    @Transactional
    public String save(LaptopSaveRequestDto laptopSaveRequestDto){
        LaptopSpecDomain laptopSpecDomain = laptopSpecRepository.findBySpec_Idx(laptopSaveRequestDto.getSpec_Idx());
        //Laptop 넣기
        LaptopDomain laptopDomain = LaptopDomain.builder()
                .laptopName(laptopSaveRequestDto.getLaptopName())
                .laptopbrand(laptopSaveRequestDto.getLaptopbrand())
                .laptopSerialNumber(laptopSaveRequestDto.getLaptopSerialNumber())
                .laptopSpecDomain(laptopSpecDomain)
                .build();
        return laptopRepo.save(laptopDomain).getLaptopSerialNumber();
    }

    @Transactional
    public String update(String laptopSerialNumber, LaptopSaveRequestDto laptopSaveRequestDto){
        LaptopDomain laptopDomain = laptopRepo.findByLaptopSerialNumber(laptopSerialNumber).orElseThrow(() -> new IllegalArgumentException("해당 노트북이 없습니다. SerialNumber:"+laptopSerialNumber));
        laptopDomain.update(laptopSaveRequestDto.getLaptopName(), laptopSaveRequestDto.getLaptopbrand());
        return laptopSerialNumber;
    }

    @Transactional
    public void delete(String laptopSerialNumber){
        LaptopDomain laptopDomain = laptopRepo.findByLaptopSerialNumber(laptopSerialNumber).orElseThrow(()-> new IllegalArgumentException("해당 노트북이 없습니다. SerialNumber:"+laptopSerialNumber));
        laptopRepo.delete(laptopDomain);
    }

    @Transactional(readOnly = true)
    public LaptopResponseDto findByLaptopSerialNumber(String laptopSerialNumber){
        LaptopDomain laptopDomain = laptopRepo.findByLaptopSerialNumber(laptopSerialNumber).orElseThrow(() -> new IllegalArgumentException("해당 노트북이 없습니다. SerialNumber:"+laptopSerialNumber));
        return new LaptopResponseDto(laptopDomain);
    }
}