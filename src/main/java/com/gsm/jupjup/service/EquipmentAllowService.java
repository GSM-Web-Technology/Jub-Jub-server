package com.gsm.jupjup.service;

import com.gsm.jupjup.dao.EquipmentAllowRepository;
import com.gsm.jupjup.dao.EquipmentRepository;
import com.gsm.jupjup.domain.EquipmentAllowDomain;
import com.gsm.jupjup.domain.EquipmentDomain;
import com.gsm.jupjup.dto.EquipmentAllow.EquipmentAllowRequestDto;
import com.gsm.jupjup.dto.EquipmentAllow.EquipmentAllowResponseDto;
import com.gsm.jupjup.dto.EquipmentAllow.EquipmentAllowSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquipmentAllowService {
    @Autowired
    EquipmentAllowRepository equipmentAllowRepo;
    @Autowired
    EquipmentRepository equipmentRepo;
    @Autowired
    EquipmentService equipmentService;

    @Transactional
    public Long save(EquipmentAllowRequestDto equipmentAllowRequestDto){
        return equipmentAllowRepo.save(equipmentAllowRequestDto.toEntity()).getEqa_Idx();
    }

    @Transactional
    public void saveEquipmentAllowData(String equipmentName , EquipmentAllowRequestDto equipmentAllowRequestDto){
        EquipmentDomain equipmentDomain = equipmentRepo.findByName(equipmentName).orElseThrow(() -> new IllegalArgumentException("해당 기자제는 없습니다."));
        EquipmentAllowSaveDto equipmentAllowSaveDto =
                EquipmentAllowSaveDto.builder().
                                    equipmentAllowRequestDto(equipmentAllowRequestDto).
                                    equipmentDomain(equipmentDomain).
                                    build();
        EquipmentAllowDomain equipmentAllowDomain = equipmentAllowSaveDto.toEntity();
        int equipmentAmount = equipmentDomain.getCount() - equipmentAllowDomain.getAmount();
        equipmentAllowRepo.save(equipmentAllowDomain);
        equipmentService.updateAmount(equipmentName, equipmentAmount);
    }

    @Transactional
    public Long update(Long eqa_idx, EquipmentAllowRequestDto equipmentRequestDto){
        EquipmentAllowDomain equipmentAllowDomain = equipmentAllowRepo.findById(eqa_idx).orElseThrow(() -> new IllegalArgumentException("해당 신청은 없습니다. eqa_idx"+eqa_idx));
        equipmentAllowDomain.update(equipmentRequestDto.getAmount(), equipmentRequestDto.getReason());
        return equipmentAllowDomain.getEqa_Idx();
    }

    @Transactional
    public void deleteById(Long eqa_idx){
        EquipmentAllowDomain equipmentAllowDomain = equipmentAllowRepo.findById(eqa_idx).orElseThrow(() -> new IllegalArgumentException("해당 신청은 없습니다. eqa_idx"+eqa_idx));
        equipmentAllowRepo.delete(equipmentAllowDomain);
    }

    @Transactional(readOnly = true)
    public EquipmentAllowResponseDto findById(Long eqa_idx){
        EquipmentAllowDomain equipmentAllowDomain = equipmentAllowRepo.findById(eqa_idx).orElseThrow(() -> new IllegalStateException("해당 신청은 없습니다. eqa_idx="+eqa_idx));
        return new EquipmentAllowResponseDto(equipmentAllowDomain);
    }


}
