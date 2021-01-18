package com.gsm.jupjup.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class LaptopSpecDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spec_Idx;

    @Column
    private String CPU;

    @Column
    private String GPU;

    @Column
    private String RAM;

    @Column
    private String SSD;

    @Column
    private String HDD;

//    @Builder
//    public LaptopSpecDomain(String CPU, String GPU, String RAM, String SSD, String HDD){
//        this.CPU = CPU;
//        this.GPU = GPU;
//        this.RAM = RAM;
//        this.SSD = SSD;
//        this.HDD = HDD;
//    }
}
