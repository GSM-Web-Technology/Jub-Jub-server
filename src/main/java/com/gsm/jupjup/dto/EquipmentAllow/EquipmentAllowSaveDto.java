package com.gsm.jupjup.dto.EquipmentAllow;

import com.gsm.jupjup.domain.EquipmentAllowDomain;
import com.gsm.jupjup.domain.EquipmentDomain;
import lombok.Builder;

public class EquipmentAllowSaveDto {
    private int amount;
    private String reason;
    private EquipmentDomain equipmentDomain;

    @Builder
    public EquipmentAllowSaveDto(EquipmentAllowReqDto equipmentAllowReqDto, EquipmentDomain equipmentDomain){
        this.amount = equipmentAllowReqDto.getAmount();
        this.reason = equipmentAllowReqDto.getReason();
        this.equipmentDomain = equipmentDomain;
    }

    public EquipmentAllowDomain toEntity(){
        return EquipmentAllowDomain.builder()
                .amount(this.amount)
                .reason(this.reason)
                .equipmentDomain(this.equipmentDomain)
                .build();
    }

}
