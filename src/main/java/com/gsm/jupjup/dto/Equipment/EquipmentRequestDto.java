package com.gsm.jupjup.dto.Equipment;

import com.gsm.jupjup.domain.EquipmentDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class EquipmentRequestDto {
    private String name;
    private byte[] img_equipment;
    private String content;
    private int count;

    @Builder
    public EquipmentRequestDto(String name, byte[] img_equipment, String content, int count){
        this.name = name;
        this.img_equipment= img_equipment;
        this.content = content;
        this.count = count;
    }

    public EquipmentDomain toEntity(){
        return EquipmentDomain.builder()
                .name(name)
                .img_equipment(img_equipment)
                .content(content)
                .count(count)
                .build();
    }
}
