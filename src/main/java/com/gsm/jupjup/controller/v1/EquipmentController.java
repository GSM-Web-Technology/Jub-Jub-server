package com.gsm.jupjup.controller.v1;


import com.gsm.jupjup.dto.Equipment.EquipmentRequestDto;
import com.gsm.jupjup.dto.Equipment.EquipmentResponseDto;
import com.gsm.jupjup.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/equipment")
    public Long save(@RequestBody EquipmentRequestDto equipmentRequestDto){
        return equipmentService.save(equipmentRequestDto);
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
