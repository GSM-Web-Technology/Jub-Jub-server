package com.gsm.jupjup.domain;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EquipmentAllowDomainTest {

    //insert Test
    @Test
    public void insert(){
        EquipmentAllowDomain equipmentAllowDomain = EquipmentAllowDomain.builder()
                .amount(1)
                .reason("공부")
                .build();

        final int amount = equipmentAllowDomain.getAmount();

        assertThat(amount, is(1));
    }

    //EquipmentAllow Equipment 연관관계 테스트
    @Test
    public void EquipmentAllow_Equipment(){
        final EquipmentDomain equipmentDomain = EquipmentDomain.builder()
                .name("마우스")
                .content("매직 마우스")
                .count(11)
                .build();
        final EquipmentAllowDomain equipmentAllowDomain = EquipmentAllowDomain.builder()
                .amount(1)
                .reason("맥북에 사용하고 싶음")
                .equipmentDomain(equipmentDomain)
                .build();

        final int amount = equipmentAllowDomain.getAmount();
        final String name = equipmentAllowDomain.getEquipmentDomain().getName();

        assertThat(amount, is(1));
        assertThat(name, is("마우스"));
    }
}
