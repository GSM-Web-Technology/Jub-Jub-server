package com.gsm.jupjup.dto.Equipment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@Getter
@NoArgsConstructor
public class EquipmentUploadDto {
    private MultipartFile img_equipment;
    private String name;
    private String content;
    private int count;

    @Builder
    public EquipmentUploadDto(MultipartFile img_equipment, String name, String content,  int count){
        this.img_equipment = img_equipment;
        this.name = name;
        this.content = content;
        this.count = count;
    }
}
