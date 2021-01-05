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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long laptop_Idx;

    @Column
    private String laptopName;

    @Column
    private String laptopbrand;

    @Column
    private String laptopSerialNumber;

    @CreatedDate
    private LocalDateTime create_at_Laptop;

    @Builder
    public LaptopDomain(String laptopName, String laptopbrand, String laptopSerialNumber){
        this.laptopName = laptopName;
        this.laptopbrand = laptopbrand;
        this.laptopSerialNumber = laptopSerialNumber;
    }
}
