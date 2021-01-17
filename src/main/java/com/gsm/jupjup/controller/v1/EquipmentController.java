package com.gsm.jupjup.controller.v1;


import com.gsm.jupjup.dto.Equipment.EquipmentRequestDto;
import com.gsm.jupjup.dto.Equipment.EquipmentResponseDto;
import com.gsm.jupjup.dto.Equipment.EquipmentUploadDto;
import com.gsm.jupjup.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/equimpent")
    public void save(@RequestParam("img_equipment") MultipartFile img_equipment, @RequestParam String name, @RequestParam String content, @RequestParam int count) throws IOException{
        EquipmentUploadDto equipmentUploadDto
                = EquipmentUploadDto.builder()
                .img_equipment(img_equipment)
                .name(name)
                .content(content)
                .count(count)
                .build();

        equipmentService.save(equipmentUploadDto);
    }

    @GetMapping("/equipment/{name}")
    public EquipmentResponseDto findByName(@PathVariable String name){
        return equipmentService.findByName(name);
    }

    @PutMapping("/equipmnet/{name}")
    public Long update(@PathVariable String name, @RequestBody EquipmentRequestDto equipmentRequestDto){
        return equipmentService.update(name, equipmentRequestDto);
    }

    @DeleteMapping("/equipmnet/{name}")
    public String deleteByName(@PathVariable String name){
        equipmentService.deleteByName(name);
        return name;
    };

}
