package com.gsm.jupjup.dto.test;


import com.gsm.jupjup.domain.LaptopDomain;
import com.gsm.jupjup.domain.TestDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class LaptopSaveRequestDto {
    private String laptopSerialNumber;
    private String laptopName;
    private String laptopbrand;
    private LocalDateTime create_at_Laptop;

    @Builder
    public LaptopSaveRequestDto(String laptopSerialNumber, String laptopName, String laptopbrand, LocalDateTime create_at_Laptop){
        this.laptopSerialNumber = laptopSerialNumber;
        this.laptopName = laptopName;
        this.laptopbrand = laptopbrand;
        this.create_at_Laptop = create_at_Laptop;
    }

    public LaptopDomain toEntity(){
        return LaptopDomain.builder()
                .laptopSerialNumber(laptopSerialNumber)
                .laptopName(laptopName)
                .laptopbrand(laptopbrand)
                .build();
    }
}
