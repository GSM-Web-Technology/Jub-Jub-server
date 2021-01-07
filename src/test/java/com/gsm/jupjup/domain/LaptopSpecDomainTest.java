package com.gsm.jupjup.domain;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LaptopSpecDomainTest {

    @Test
    public void insert(){
        final LaptopSpecDomain laptopSpecDomain = LaptopSpecDomain.builder()
                .CPU("aaa")
                .GPU("aaa")
                .RAM("aaa")
                .SSD("aaa")
                .HDD("aaa")
                .build();

        final String CPU = laptopSpecDomain.getCPU();
        final String GPU = laptopSpecDomain.getGPU();

        assertThat(CPU, is("aaa"));
        assertThat(GPU, is("aaa"));
    }

}
