package com.gsm.jupjup.dto.EquipmentAllow;

import com.gsm.jupjup.domain.EquipmentAllowDomain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EquipmentAllowReqDto {

    private int amount;
    private String reason;

    @Builder
    public EquipmentAllowReqDto(int amount, String reason){
        this.amount = amount;
        this.reason = reason;
    }

    public EquipmentAllowDomain toEntity(){
        return EquipmentAllowDomain.builder()
                .amount(this.amount)
                .reason(this.reason)
                .build();
    }

}