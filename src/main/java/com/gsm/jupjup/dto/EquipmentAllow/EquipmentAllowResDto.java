package com.gsm.jupjup.dto.EquipmentAllow;

import com.gsm.jupjup.domain.EquipmentAllowDomain;
import com.gsm.jupjup.domain.EquipmentEnum;
import lombok.Getter;

@Getter
public class EquipmentAllowResDto {
    private Long eqa_Idx;
    private int amount;
    private String reason;
    private EquipmentEnum equipmentEnum;

    public EquipmentAllowResDto(EquipmentAllowDomain equipmentAllowDomain){
        this.eqa_Idx = equipmentAllowDomain.getEqa_Idx();
        this.amount = equipmentAllowDomain.getAmount();
        this.reason = equipmentAllowDomain.getReason();
        this.equipmentEnum = equipmentAllowDomain.getEquipmentEnum();
    }
}