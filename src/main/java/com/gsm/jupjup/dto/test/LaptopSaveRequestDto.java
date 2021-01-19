package com.gsm.jupjup.dto.test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class LaptopSaveRequestDto {
    private String laptopSerialNumber;
    private String laptopName;
    private String laptopbrand;
    private LocalDateTime create_at_Laptop;
    private Long spec_Idx;

    @Builder
    public LaptopSaveRequestDto(String laptopSerialNumber, String laptopName, String laptopbrand, Long spec_Idx){
        this.laptopSerialNumber = laptopSerialNumber;
        this.laptopName = laptopName;
        this.laptopbrand = laptopbrand;
        this.spec_Idx = spec_Idx;
    }
}
// 1. client에서 보낼 data를 생각하고.
// 2. data를 갖고 DTO를 생각한다.
// 3. DTO기반 service 객체를 만들고.(+util class 작성)
// 4. service객체로 controller를 만든다.