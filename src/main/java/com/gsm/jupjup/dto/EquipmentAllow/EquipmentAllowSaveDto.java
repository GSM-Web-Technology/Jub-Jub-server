package com.gsm.jupjup.dto.EquipmentAllow;

import com.gsm.jupjup.domain.EquipmentAllowDomain;
import com.gsm.jupjup.domain.EquipmentDomain;
import lombok.Builder;

public class EquipmentAllowSaveDto {
    private int amount;
    private String reason;
    private EquipmentDomain equipmentDomain;

    @Builder
    public EquipmentAllowSaveDto(EquipmentAllowRequestDto equipmentAllowRequestDto, EquipmentDomain equipmentDomain){
        this.amount = equipmentAllowRequestDto.getAmount();
        this.reason = equipmentAllowRequestDto.getReason();
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
