package com.gsm.jupjup.service;

import com.gsm.jupjup.dao.EquipmentAllowRepository;
import com.gsm.jupjup.dao.EquipmentRepository;
import com.gsm.jupjup.domain.EquipmentAllowDomain;
import com.gsm.jupjup.domain.EquipmentDomain;
import com.gsm.jupjup.dto.EquipmentAllow.EquipmentAllowReqDto;
import com.gsm.jupjup.dto.EquipmentAllow.EquipmentAllowResDto;
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
    public Long save(EquipmentAllowReqDto equipmentAllowReqDto){
        return equipmentAllowRepo.save(equipmentAllowReqDto.toEntity()).getEqa_Idx();
    }

    @Transactional
    public void saveEquipmentAllowData(String equipmentName , EquipmentAllowReqDto equipmentAllowReqDto){
        EquipmentDomain equipmentDomain = equipmentRepo.findByName(equipmentName).orElseThrow(() -> new IllegalArgumentException("해당 기자제는 없습니다."));
        EquipmentAllowSaveDto equipmentAllowSaveDto =
                EquipmentAllowSaveDto.builder().
                                    equipmentAllowReqDto(equipmentAllowReqDto).
                                    equipmentDomain(equipmentDomain).
                                    build();
        EquipmentAllowDomain equipmentAllowDomain = equipmentAllowSaveDto.toEntity();
        int equipmentAmount = equipmentDomain.getCount() - equipmentAllowDomain.getAmount();
        equipmentAllowRepo.save(equipmentAllowDomain);
        equipmentService.updateAmount(equipmentName, equipmentAmount);
    }

    @Transactional
    public Long update(Long eqa_idx, EquipmentAllowReqDto equipmentRequestDto){
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
    public EquipmentAllowResDto findById(Long eqa_idx){
        EquipmentAllowDomain equipmentAllowDomain = equipmentAllowRepo.findById(eqa_idx).orElseThrow(() -> new IllegalStateException("해당 신청은 없습니다. eqa_idx="+eqa_idx));
        return new EquipmentAllowResDto(equipmentAllowDomain);
    }


}
