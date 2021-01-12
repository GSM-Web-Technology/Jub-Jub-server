package com.gsm.jupjup.service;

import com.gsm.jupjup.dao.EquipmentRepository;
import com.gsm.jupjup.domain.EquipmentDomain;
import com.gsm.jupjup.dto.Equipment.EquipmentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EquipmentService {
    @Autowired
    EquipmentRepository equipmentRepo;

    @Transactional
    public Long save(EquipmentRequestDto equipmentRequestDto){
        return equipmentRepo.save(equipmentRequestDto.toEntity()).getEq_Idx();
    }

//    @Transactional
//    public Long update(Long eq_idx, EquipmentRequestDto equipmentRequestDto){
//        return
//    };
}
