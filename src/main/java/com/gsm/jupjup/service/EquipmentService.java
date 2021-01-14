package com.gsm.jupjup.service;

import com.gsm.jupjup.dao.EquipmentRepository;
import com.gsm.jupjup.domain.EquipmentDomain;
import com.gsm.jupjup.dto.Equipment.EquipmentRequestDto;
import com.gsm.jupjup.dto.Equipment.EquipmentResponseDto;
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

    @Transactional
    public Long update(String name, EquipmentRequestDto equipmentRequestDto){
        EquipmentDomain equipmentDomain = equipmentRepo.findByName(name).orElseThrow(() -> new IllegalArgumentException("해당 기자재는 없습니다. name="+name));
        equipmentDomain.update(equipmentRequestDto.getName(), equipmentRequestDto.getImg_equipment(), equipmentRequestDto.getContent(), equipmentRequestDto.getCount());
        return equipmentDomain.getEq_Idx();
    };

    @Transactional
    public void deleteByName(String name){
        EquipmentDomain equipmentDomain = equipmentRepo.findByName(name).orElseThrow(() -> new IllegalArgumentException("해당 기자재는 없습니다. name="+name));
        equipmentRepo.delete(equipmentDomain);
    }

    @Transactional(readOnly = true)
    public EquipmentResponseDto findByName(String name){
        EquipmentDomain equipmentDomain = equipmentRepo.findByName(name).orElseThrow(() -> new IllegalArgumentException("해당 기자재는 없습니다. name="+name));
        return new EquipmentResponseDto(equipmentDomain);
    }
}
