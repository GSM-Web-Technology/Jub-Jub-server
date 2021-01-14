package com.gsm.jupjup.dto.test;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LaptopUpdateRequestDto {
    private String laptopName;
    private String laptopbrand;

    @Builder
    public LaptopUpdateRequestDto(String laptopName, String laptopbrand){
        this.laptopName = laptopName;
        this.laptopbrand = laptopbrand;
    }
}
