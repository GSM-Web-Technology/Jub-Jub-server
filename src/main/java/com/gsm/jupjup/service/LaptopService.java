package com.gsm.jupjup.service;

import com.gsm.jupjup.dao.LaptopRepository;
import com.gsm.jupjup.domain.LaptopDomain;
import com.gsm.jupjup.dto.test.LaptopSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepo;

    @Transactional
    public String save(LaptopSaveRequestDto laptopSaveRequestDto){
        return laptopRepo.save(laptopSaveRequestDto.toEntity()).getLaptopSerialNumber();
    }

    @Transactional
    public String update(String laptopSerialNumber, LaptopSaveRequestDto laptopSaveRequestDto){
        LaptopDomain laptopDomain = laptopRepo.findByLaptopSerialNumber(laptopSerialNumber).orElseThrow(() -> new IllegalArgumentException("해당 노트북이 없습니다. SerialNumber:"+laptopSerialNumber));
        laptopDomain.update(laptopSaveRequestDto.getLaptopName(), laptopSaveRequestDto.getLaptopbrand());
        return laptopSerialNumber;
    }

    @Transactional
    public void delete(String laptopSerialNumber){
        LaptopDomain LaptopDomain = laptopRepo.findByLaptopSerialNumber(laptopSerialNumber).orElseThrow(()-> new IllegalArgumentException("해당 노트북이 없습니다. SerialNumber:"+laptopSerialNumber));
        laptopRepo.delete(LaptopDomain);
    }

    @Transactional(readOnly = true)
    public LaptopSaveRequestDto findById(String laptopSerialNumber){
        LaptopDomain LaptopDomain = laptopRepo.findByLaptopSerialNumber(laptopSerialNumber).orElseThrow(() -> new IllegalArgumentException("해당 노트북이 없습니다. SerialNumber:"+laptopSerialNumber));
        return new LaptopSaveRequestDto(LaptopDomain);
    }
}
