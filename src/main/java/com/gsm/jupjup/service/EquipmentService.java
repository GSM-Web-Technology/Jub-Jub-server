package com.gsm.jupjup.service;

import com.gsm.jupjup.dao.EquipmentRepository;
import com.gsm.jupjup.domain.EquipmentDomain;
import com.gsm.jupjup.dto.Equipment.EquipmentRequestDto;
import com.gsm.jupjup.dto.test.TestResponseDto;
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
    public Long update(Long eq_idx, EquipmentRequestDto equipmentRequestDto){
        EquipmentDomain equipmentDomain = equipmentRepo.findById(eq_idx).orElseThrow(() -> new IllegalArgumentException("해당 장비는 없습니다. eq_idx="+eq_idx));
        equipmentDomain.update(equipmentRequestDto.getName(), equipmentRequestDto.getImg_equipment(), equipmentRequestDto.getContent(), equipmentRequestDto.getCount());
        return eq_idx;
    };

    @Transactional
    public void delete(Long eq_idx){
        EquipmentDomain equipmentDomain = equipmentRepo.findById(eq_idx).orElseThrow(() -> new IllegalArgumentException("해당 장비는 없습니다. id="+eq_idx));
        equipmentRepo.delete(equipmentDomain);
    }

}
