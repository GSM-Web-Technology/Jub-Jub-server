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

    @GetMapping("/equipment/{eq_idx}")
    public EquipmentResponseDto findById(@PathVariable Long eq_idx){
        return equipmentService.findById(eq_idx);
    }

    @PutMapping("/equipmnet/{eq_idx}")
    public Long update(@PathVariable Long eq_idx, @RequestBody EquipmentRequestDto equipmentRequestDto){
        return equipmentService.update(eq_idx, equipmentRequestDto);
    }

    @DeleteMapping("/equipmnet/{eq_idx}")
    public Long deleteById(@PathVariable Long eq_idx){
        equipmentService.deleteById(eq_idx);
        return eq_idx;
    };

}
