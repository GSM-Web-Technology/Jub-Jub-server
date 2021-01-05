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
public class AuthDomain {

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

    @CreatedDate
    private LocalDateTime create_at_Auth;

    @OneToOne
    @JoinColumn(name = "laptop_Idx")
    private LaptopDomain laptopDomain;

    @Builder
    public AuthDomain(String email, String classNumber, String password, String name){
        this.email = email;
        this.classNumber = classNumber;
        this.password = password;
        this.name = name;
    }
}
