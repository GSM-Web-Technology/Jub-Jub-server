package com.gsm.jupjup.service;

import com.gsm.jupjup.dao.EquipmentAllowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {
    @Autowired
    EquipmentAllowRepository equipmentAllowRepo;

}