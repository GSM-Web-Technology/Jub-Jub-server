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

    public LaptopSaveRequestDto(LaptopDomain laptopDomain) {
    }

    public LaptopDomain toEntity(){
        return LaptopDomain.builder()
                .laptopSerialNumber(laptopSerialNumber)
                .laptopName(laptopName)
                .laptopbrand(laptopbrand)
                .build();
    }
}
// 1. client에서 보낼 data를 생각하고.
// 2. data를 갖고 DTO를 생각한다.
// 3. DTO기반 service 객체를 만들고.(+util class 작성)
// 4. service객체로 controller를 만든다.