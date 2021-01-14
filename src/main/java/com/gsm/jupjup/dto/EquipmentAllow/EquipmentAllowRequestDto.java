package com.gsm.jupjup.dto.EquipmentAllow;

import com.gsm.jupjup.domain.EquipmentAllowDomain;

import com.gsm.jupjup.domain.EquipmentEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EquipmentAllowRequestDto {

    private int amount;
    private String reason;
    private EquipmentEnum equipmentEnum;

    @Builder
    public EquipmentAllowRequestDto(int amount, String reason, EquipmentEnum equipmentEnum){
        this.amount = amount;
        this.reason = reason;
        this.equipmentEnum = equipmentEnum;
    }

    public EquipmentAllowDomain toEntity(){
        return EquipmentAllowDomain.builder()
                .amount(this.amount)
                .reason(this.reason)
                .equipmentEnum(this.equipmentEnum)
                .build();
    }

}