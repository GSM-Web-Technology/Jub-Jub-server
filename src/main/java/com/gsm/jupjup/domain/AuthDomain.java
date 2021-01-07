package com.gsm.jupjup.domain;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
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

    @Enumerated(EnumType.STRING)
    private AuthEnum authEnum = AuthEnum.ROLE_Student;

    @OneToOne
    @JoinColumn(name = "laptopSerialNumber")
    private LaptopDomain laptopDomain;

    @ManyToOne
    @JoinColumn(name = "eqa_Idx")
    private EquipmentAllowDomain equipmentAllowDomain;

    @Builder
    public AuthDomain(String email, String classNumber, String password, String name, LaptopDomain laptopDomain, EquipmentAllowDomain equipmentAllowDomain){
        this.email = email;
        this.classNumber = classNumber;
        this.password = password;
        this.name = name;
        this.laptopDomain = laptopDomain;
        this.equipmentAllowDomain = equipmentAllowDomain;
    }
}