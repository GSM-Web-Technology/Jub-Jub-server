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


    @Builder
    public EquipmentRequestDto(String name, byte[] img_equipment, String content, LocalDateTime create_at_equipment){
        this.name = name;
        this.img_equipment= img_equipment;
        this.content = content;
    }

    public EquipmentDomain toEntity(){
        return EquipmentDomain.builder()
                .name(name)
                .img_equipment(img_equipment)
                .content(content)
                .build();
    }
}
