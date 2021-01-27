package com.gsm.jupjup.domain;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EquipmentDomainTest {

    //insert test
    @Test
    public void insert() {
        final EquipmentDomain equipmentDomain = EquipmentDomain.builder()
                .name("마우스")
                .content("매직 마우스")
                .count(100)
                .build();

        final String name = equipmentDomain.getName();
        final int count = equipmentDomain.getCount();

        assertThat(name, is("마우스"));
        assertThat(count, is(100));
    }

}
