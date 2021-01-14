package com.gsm.jupjup.dto.test;


import com.gsm.jupjup.domain.LaptopSpecDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//lombok 기능.
@NoArgsConstructor
public class LaptopSpecSaveRequestDto {
    private String CPU;
    private String GPU;
    private String RAM;
    private String SSD;
    private String HDD;

    @Builder
    public LaptopSpecSaveRequestDto(String CPU, String GPU, String RAM, String SSD, String HDD){
        this.CPU = CPU;
        this.GPU = GPU;
        this.RAM = RAM;
        this.SSD = SSD;
        this.HDD = HDD;
    }

    //LaptopSpecDomain에 값을 넘겨준다.
    public LaptopSpecDomain toEntity(){
        return LaptopSpecDomain.builder()
                .CPU(CPU)
                .GPU(GPU)
                .RAM(RAM)
                .RAM(RAM)
                .SSD(SSD)
                .HDD(HDD)
                .build();
    }
}
