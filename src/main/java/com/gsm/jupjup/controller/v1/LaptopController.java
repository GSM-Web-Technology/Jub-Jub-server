package com.gsm.jupjup.controller.v1;


import com.gsm.jupjup.dto.test.LaptopResponseDto;
import com.gsm.jupjup.dto.test.LaptopSaveRequestDto;
import com.gsm.jupjup.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LaptopController {

    //Dependency Injection
    @Autowired
    private LaptopService laptopService;

    @PostMapping("/laptop")
    public String save(@RequestBody LaptopSaveRequestDto laptopSaveRequestDto){
        return laptopService.save(laptopSaveRequestDto);
    }

    @GetMapping("/laptop/{laptopSerialNumber}")
    public LaptopResponseDto findByLaptopSerialNumber(@PathVariable String laptopSerialNumber){
        return laptopService.findByLaptopSerialNumber(laptopSerialNumber);
    }

    @DeleteMapping("/laptop/{laptopSerialNumber}")
    public String delete(@PathVariable String laptopSerialNumber){
        laptopService.delete(laptopSerialNumber);
        return laptopSerialNumber;
    }

    @PutMapping("/laptop/{laptopSerialNumber}")
    public String update(@PathVariable String laptopSerialNumber, @RequestBody LaptopSaveRequestDto laptopSaveRequestDto){
        return laptopService.update(laptopSerialNumber, laptopSaveRequestDto);
    }
}