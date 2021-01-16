package com.gsm.jupjup.controller.v1;

import com.gsm.jupjup.dto.EquipmentAllow.EquipmentAllowRequestDto;
import com.gsm.jupjup.dto.EquipmentAllow.EquipmentAllowResponseDto;
import com.gsm.jupjup.service.EquipmentAllowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EquipmentAllowController {

    @Autowired
    private EquipmentAllowService equipmentAllowService;

    @PostMapping("/equipmentAllow")
    public Long save(@RequestBody EquipmentAllowRequestDto equipmentAllowRequestDto){
        return equipmentAllowService.save(equipmentAllowRequestDto);
    }

    @GetMapping("/equipmentAllow/{eqa_idx}")
    public EquipmentAllowResponseDto equipmentAllowResponseDto(@PathVariable Long eqa_idx){
        return equipmentAllowService.findById(eqa_idx);
    }

//    @PutMapping("/equipmentAllow/{epa_idx}")
//    public Long update(@PathVariable Long epa_idx, @RequestBody EquipmentAllowRequestDto equipmentAllowRequestDto){
//        return equipmentAllowService.update(epa_idx, equipmentAllowRequestDto);
//    }

    @PostMapping("/equipmentAllow/{eqa_idx}")
    public void delete(@PathVariable Long eqa_idx){
        equipmentAllowService.deleteById(eqa_idx);
    }

}
