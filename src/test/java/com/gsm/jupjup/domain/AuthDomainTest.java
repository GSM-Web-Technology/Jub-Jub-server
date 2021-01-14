package com.gsm.jupjup.domain;

import com.gsm.jupjup.dao.AuthRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class AuthDomainTest {

    @Autowired
    private AuthRepository authRepository;

    //insert Test
    @Test
    public void insert(){
        final AuthDomain authDomain = AuthDomain.builder()
                .email("s19066@gsm.hs.kr")
                .password("123")
                .classNumber("9999")
                .name("김상현")
                .build();

        final String email = authDomain.getEmail();
        final String password = authDomain.getPassword();
        final String classNumber = authDomain.getClassNumber();
        final String name = authDomain.getName();

        assertThat(email, is("s19066@gsm.hs.kr"));
        assertThat(password, is("123"));
        assertThat(classNumber, is("9999"));
        assertThat(name, is("김상현"));
    }

    //Auth LapTop 연관관계 테스트
    @Test
    public void Auth_Laptop(){
        final LaptopDomain laptopDomain = LaptopDomain.builder()
                .laptopName("Mac Pro")
                .laptopbrand("Apple")
                .laptopSerialNumber("1234h12kj34hkl123h4kl123jh4")
                .build();
        final AuthDomain authDomain = AuthDomain.builder()
                .email("s19066@gsm.hs.kr")
                .password("123")
                .classNumber("9999")
                .name("김상현")
                .laptopDomain(laptopDomain)
                .build();

        final String username = authDomain.getName();
        final String laptopName = authDomain.getLaptopDomain().getLaptopName();

        assertThat(username, is("김상현"));
        assertThat(laptopName, is("Mac Pro"));
    }

    //Auth Equipment_Allow 연관관계 테스트
    @Test
    public void Auth_EquipmentAllow(){
        final EquipmentAllowDomain equipmentAllowDomain = EquipmentAllowDomain.builder()
                .amount(9)
                .reason("이유")
                .equipmentEnum(EquipmentEnum.ROLE_Accept)
                .build();
        final AuthDomain authDomain = AuthDomain.builder()
                .email("s19066@gsm.hs.kr")
                .password("123")
                .classNumber("9999")
                .name("김상현")
                .equipmentAllowDomain(equipmentAllowDomain)
                .build();

        final String email = authDomain.getEmail();
        final String why = authDomain.getEquipmentAllowDomain().getReason();

        assertThat(email, is("s19066@gsm.hs.kr"));
        assertThat(why, is("이유"));
    }

    //Laptop LaptopSpec
    @Test
    public void Laptop_LaptopSpec(){

    }
}
