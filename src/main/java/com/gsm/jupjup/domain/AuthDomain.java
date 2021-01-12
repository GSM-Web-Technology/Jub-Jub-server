package com.gsm.jupjup.domain;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class AuthDomain extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long auth_Idx;

    @Column(nullable = false)
    private String email;

    @Column(length = 4, nullable = false)
    private String classNumber;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String token;

    @Enumerated(EnumType.STRING)
    private AuthEnum authEnum = AuthEnum.ROLE_Student;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "laptopSerialNumber")
    private LaptopDomain laptopDomain;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eqa_Idx")
    private EquipmentAllowDomain equipmentAllowDomain;


    @Builder
    public AuthDomain(String email, String classNumber, String password, String name, String token, LaptopDomain laptopDomain, EquipmentAllowDomain equipmentAllowDomain){
        this.email = email;
        this.classNumber = classNumber;
        this.password = password;
        this.name = name;
        this.token = token;
        this.laptopDomain = laptopDomain;
        this.equipmentAllowDomain = equipmentAllowDomain;
    }
}