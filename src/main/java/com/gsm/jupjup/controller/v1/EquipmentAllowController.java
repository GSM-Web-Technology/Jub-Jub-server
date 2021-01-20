package com.gsm.jupjup.controller.v1;

import com.gsm.jupjup.dto.EquipmentAllow.EquipmentAllowReqDto;
import com.gsm.jupjup.dto.EquipmentAllow.EquipmentAllowResDto;
import com.gsm.jupjup.service.v1.quipment.EquipmentAllowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EquipmentAllowController {

    @Autowired
    private EquipmentAllowService equipmentAllowService;

//    @PostMapping("/equipmentAllow")
//    public Long save(@RequestBody EquipmentAllowReqDto equipmentAllowReqDto){
//        return equipmentAllowService.save(equipmentAllowReqDto);
//    }

//    @GetMapping("/equipmentAllow")
//    public List<String> findAllForAdmin(){
//        return equipmentAllowService.findAllForAdmin();
//    }

    @PostMapping("/equipmentAllow/{name}")
    public void saveEquipmentAllowData(@PathVariable() String name, @RequestBody EquipmentAllowReqDto equipmentAllowReqDto) throws Exception {
        equipmentAllowService.saveEquipmentAllowData(name, equipmentAllowReqDto);
    }

    @GetMapping("/equipmentAllow/{eqa_idx}")
    public EquipmentAllowResDto equipmentAllowResponseDto(@PathVariable Long eqa_idx) throws Exception {
        return equipmentAllowService.findById(eqa_idx);
    }


//    @PutMapping("/equipmentAllow/{epa_idx}")
//    public Long update(@PathVariable Long epa_idx, @RequestBody EquipmentAllowRequestDto equipmentAllowRequestDto){
//        return equipmentAllowService.update(epa_idx, equipmentAllowRequestDto);
//    }

    @DeleteMapping("/equipmentAllow/{eqa_idx}")
    public void delete(@PathVariable Long eqa_idx) throws Exception {
        equipmentAllowService.deleteById(eqa_idx);
    }

}
