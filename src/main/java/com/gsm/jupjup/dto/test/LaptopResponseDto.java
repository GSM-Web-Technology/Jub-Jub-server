package com.gsm.jupjup.dto.test;

import com.gsm.jupjup.domain.LaptopDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class LaptopResponseDto {
    private String laptopSerialNumber;
    private String laptopName;
    private String laptopbrand; // 카멜표기법에 적절하지 않음.
    private LocalDate create_at_Laptop;

    @Builder
    public LaptopResponseDto(LaptopDomain entity){
        this.laptopSerialNumber = entity.getLaptopSerialNumber();
        this.laptopName = entity.getLaptopName();
        this.laptopbrand = entity.getLaptopbrand();
    }
}
