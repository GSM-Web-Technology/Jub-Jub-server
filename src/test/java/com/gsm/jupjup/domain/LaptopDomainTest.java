package com.gsm.jupjup.domain;


import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LaptopDomainTest {

    @Test
    public void insert(){
        final LaptopDomain laptopDomain = LaptopDomain.builder()
                .laptopName("Mac Pro")
                .laptopbrand("Apple")
                .laptopSerialNumber("123412341234123412")
                .build();

        final String laptopName = laptopDomain.getLaptopName();
        final String laptopbrand = laptopDomain.getLaptopbrand();

        assertThat(laptopName, is("Mac Pro"));
        assertThat(laptopbrand, is("Apple"));
    }

    @Test
    public void Laptop_LaptopSpec(){
        LaptopSpecDomain laptopSpecDomain = LaptopSpecDomain.builder()
                .CPU("aaa")
                .GPU("aaa")
                .RAM("aaa")
                .SSD("aaa")
                .HDD("aaa")
                .build();
        LaptopDomain laptopDomain = LaptopDomain.builder()
                .laptopName("Mac")
                .laptopbrand("Apple")
                .laptopSerialNumber("1231231231231")
                .laptopSpecDomain(laptopSpecDomain)
                .build();

        final String laptopName = laptopDomain.getLaptopName();
        final String CPU = laptopDomain.getLaptopSpecDomain().getCPU();

        assertThat(laptopName, is("Mac"));
        assertThat(CPU, is("aaa"));
    }

}
