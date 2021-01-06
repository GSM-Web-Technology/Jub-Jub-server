package com.gsm.jupjup.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LaptopDomain {

    @Id
    private String laptopSerialNumber;

    @Column
    private String laptopName;

    @Column
    private String laptopbrand;

    @CreatedDate
    private LocalDateTime create_at_Laptop;

    @ManyToOne
    @JoinColumn(name = "spec_Idx")
    private LaptopSpecDomain laptopSpecDomain;

    @Builder
    public LaptopDomain(String laptopName, String laptopbrand, String laptopSerialNumber){
        this.laptopName = laptopName;
        this.laptopbrand = laptopbrand;
        this.laptopSerialNumber = laptopSerialNumber;
    }
}