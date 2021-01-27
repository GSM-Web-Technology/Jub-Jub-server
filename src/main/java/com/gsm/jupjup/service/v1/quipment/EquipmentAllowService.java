package com.gsm.jupjup.service.v1.quipment;

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
    public void saveEquipmentAllowData(String NameOfEquipment , EquipmentAllowReqDto equipmentAllowReqDto) throws Exception {
        EquipmentDomain equipmentDomain = equipmentService.equipmentFindByName(equipmentRepo, NameOfEquipment);
        EquipmentAllowSaveDto equipmentAllowSaveDto =
                EquipmentAllowSaveDto.builder().
                                    equipmentAllowReqDto(equipmentAllowReqDto).
                                    equipmentDomain(equipmentDomain).
                                    build();
        EquipmentAllowDomain equipmentAllowDomain = equipmentAllowSaveDto.toEntity();

        int equipmentAmount = equipmentDomain.getCount() - equipmentAllowDomain.getAmount();

        equipmentAllowRepo.save(equipmentAllowDomain);
        equipmentService.updateAmount(NameOfEquipment, equipmentAmount);
    }

    @Transactional
    public Long update(Long eqa_idx, EquipmentAllowReqDto equipmentRequestDto){
        EquipmentAllowDomain equipmentAllowDomain = equipmentAllowFindByEqa_idx(equipmentAllowRepo, eqa_idx);
        equipmentAllowDomain.update(equipmentRequestDto.getAmount(), equipmentRequestDto.getReason());
        return equipmentAllowDomain.getEqa_Idx();
    }

    @Transactional
    public void deleteById(Long eqa_idx) throws Exception{
        EquipmentAllowDomain equipmentAllowDomain = equipmentAllowFindByEqa_idx(equipmentAllowRepo, eqa_idx);
        equipmentAllowRepo.delete(equipmentAllowDomain);
    }

    @Transactional(readOnly = true)
    public EquipmentAllowResDto findById(Long eqa_idx){
        EquipmentAllowDomain equipmentAllowDomain = equipmentAllowFindByEqa_idx(equipmentAllowRepo, eqa_idx);
        return new EquipmentAllowResDto(equipmentAllowDomain);
    }

//    @Transactional(readOnly = true)
//    public List<String> findAllForAdmin(){
//        List<String> equipmentAllowDomain = equipmentAllowRepo.findAllBy();
//        return equipmentAllowDomain;
//    }

    //EquipmentALlow를 name으로 찾고 Entity만드는 매서드
    @Transactional
    public EquipmentAllowDomain equipmentAllowFindByEqa_idx(EquipmentAllowRepository equipmentAllowRepo, Long eqa_idx){
        return equipmentAllowRepo.findById(eqa_idx).orElseThrow(() -> new IllegalStateException("해당 신청은 없습니다. eqa_idx="+eqa_idx));
    }

}
