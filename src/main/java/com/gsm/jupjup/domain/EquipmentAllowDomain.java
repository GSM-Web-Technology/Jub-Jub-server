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
public class EquipmentAllowDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eqa_Idx;

    @Column
    private String name;

    @Column
    @Lob
    private byte[] img_allow; //BLOB

    @Column
    private int amount;

    @Column(length = 300)
    private String reason;

    @Enumerated(EnumType.STRING)
    private EquipmentEnum equipmentEnum;

    @CreatedDate
    private LocalDateTime allow_at;

    @ManyToOne
    @JoinColumn(name = "eq_Idx")
    private EquipmentDomain equipmentDomain;

    @Builder
    public EquipmentAllowDomain(String name, int amount, byte[] img_allow, String reason, EquipmentEnum equipmentEnum){
        this.name = name;
        this.amount = amount;
        this.img_allow = img_allow;
        this.reason = reason;
        this.equipmentEnum = equipmentEnum;
    }
}
