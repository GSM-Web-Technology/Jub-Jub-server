package com.gsm.jupjup.service;

import com.gsm.jupjup.dao.LaptopRepository;
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
}
