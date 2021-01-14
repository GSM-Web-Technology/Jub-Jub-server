package com.gsm.jupjup.service;

import com.gsm.jupjup.dao.LaptopSpecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LaptopSpecService {

    //@Autowired 의존성 주입을 위해 사용하는 어노테이션.
    @Autowired
    private LaptopSpecRepository laptopSpecRepo;

    @Transactional

}
