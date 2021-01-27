package com.gsm.jupjup.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LaptopDomain extends BaseTimeEntity{


    @Id
    @Column
    private String laptopSerialNumber;

    @Column
    private String laptopName;

    @Column
    private String laptopbrand;

    @CreatedDate
    private LocalDate create_at_Laptop;

    // fk mapping
    @ManyToOne
    @JoinColumn(name = "spec_Idx")
    private LaptopSpecDomain laptopSpecDomain;

    @Builder
    public LaptopDomain(String laptopName, String laptopbrand, String laptopSerialNumber, LaptopSpecDomain laptopSpecDomain){
        this.laptopName = laptopName;
        this.laptopbrand = laptopbrand;
        this.laptopSerialNumber = laptopSerialNumber;
        this.laptopSpecDomain = laptopSpecDomain;
    }
    //update 문에 사용할 생성자 정의.
    public void update(String laptopName, String laptopbrand){
        this.laptopName = laptopName;
        this.laptopbrand = laptopbrand;
    }
}