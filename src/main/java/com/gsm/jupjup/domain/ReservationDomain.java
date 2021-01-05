package com.gsm.jupjup.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReservationDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reservation_Idx;

    @Column
    private int reservation_Order;

    @ManyToOne
    @JoinColumn(name = "auth_Idx")
    private AuthDomain authDomain;

    @ManyToOne
    @JoinColumn(name = "eqa_Idx")
    private EquipmentAllowDomain equipmentAllowDomain;
}
