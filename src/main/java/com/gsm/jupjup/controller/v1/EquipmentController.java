package com.gsm.jupjup.controller.v1;


import com.gsm.jupjup.dto.Equipment.EquipmentReqDto;
import com.gsm.jupjup.dto.Equipment.EquipmentResDto;
import com.gsm.jupjup.dto.Equipment.EquipmentUploadDto;
import com.gsm.jupjup.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/equimpent")
    public void save(@RequestParam("img_equipment") MultipartFile img_equipment, @RequestParam String name, @RequestParam String content, @RequestParam int count) throws Exception {
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
    public EquipmentResDto findByName(@PathVariable String name) throws Exception {
        return equipmentService.findByName(name);
    }

    @GetMapping(value="/equipment/img/{name}", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] findByNameGetEquipment_img(@PathVariable String name) throws Exception {
        return equipmentService.findByNameGetEquipment_img(name);
    }

    @PutMapping("/equipmnet/{name}")
    public Long update(@PathVariable String name, @RequestBody EquipmentReqDto equipmentReqDto) throws Exception {
        return equipmentService.update(name, equipmentReqDto);
    }

    @DeleteMapping("/equipmnet/{name}")
    public String deleteByName(@PathVariable String name) throws Exception {
        equipmentService.deleteByName(name);
        return name;
    };

}
