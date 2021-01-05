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
    private byte[] img; //BLOB

    @Column
    private int amount;

    @Column(length = 300)
    private String reason;

    @Enumerated(EnumType.STRING)
    private EquipmentEnum equipmentEnum;

    @CreatedDate
    private LocalDateTime allow_at;

    @Builder
    public EquipmentAllowDomain(String name, int amount, byte[] img, String reason, EquipmentEnum equipmentEnum){
        this.name = name;
        this.amount = amount;
        this.img = img;
        this.reason = reason;
        this.equipmentEnum = equipmentEnum;
    }
}
