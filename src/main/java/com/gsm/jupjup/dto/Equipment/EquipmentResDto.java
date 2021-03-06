package com.gsm.jupjup.dto.Equipment;

import com.gsm.jupjup.domain.EquipmentDomain;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EquipmentResDto {
    private Long eq_Idx;
    private String name;
    private byte[] img_equipment;
    private String content;
    private int count;

    public EquipmentResDto(EquipmentDomain equipmentDomain){
        this.eq_Idx = equipmentDomain.getEq_Idx();
        this.name = equipmentDomain.getName();
        this.img_equipment = equipmentDomain.getImg_equipment();
        this.content = equipmentDomain.getContent();
        this.count = equipmentDomain.getCount();
    }
}