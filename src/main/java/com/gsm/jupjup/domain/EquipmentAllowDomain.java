package com.gsm.jupjup.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EquipmentAllowDomain extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eqa_Idx;

    @Column
    private int amount;

    @Column(length = 300)
    private String reason;

    @Enumerated(EnumType.STRING)
    private EquipmentEnum equipmentEnum = EquipmentEnum.ROLE_Waiting;

    @CreatedDate
    private LocalDateTime allow_at;

    @ManyToOne
    @JoinColumn(name = "eq_Idx")
    private EquipmentDomain equipmentDomain;

    @Builder
    public EquipmentAllowDomain(int amount, String reason, EquipmentDomain equipmentDomain){
        this.amount = amount;
        this.reason = reason;
        this.equipmentDomain = equipmentDomain;
    }

    public void update(int amount, String reason){
        this.amount = amount;
        this.reason = reason;
    }
}

