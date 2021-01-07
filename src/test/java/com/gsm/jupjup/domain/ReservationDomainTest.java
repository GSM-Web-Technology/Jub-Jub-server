package com.gsm.jupjup.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReservationDomainTest {
    //insert Test
    @Test
    public void insert(){
        final ReservationDomain reservationDomain = ReservationDomain.builder()
                .reservation_Order(1)
                .build();

        final int rank = reservationDomain.getReservation_Order();
        assertThat(rank, is(1));
    }

    //Reservation  Auth 연관관계 테스트
    @Test
    public void Reservation_Auth() {
        final AuthDomain authDomain = AuthDomain.builder()
                .email("s19066@gsm.hs.kr")
                .password("123")
                .classNumber("9999")
                .name("김상현")
                .build();

        final EquipmentAllowDomain equipmentAllowDomain = EquipmentAllowDomain.builder()
                .name("Mac Pro")
                .amount(1)
                .reason("공부")
                .equipmentEnum(EquipmentEnum.ROLE_Accept)
                .build();

        AuthDomain.builder().equipmentAllowDomain(equipmentAllowDomain);

        final ReservationDomain reservationDomain = ReservationDomain.builder()
                .reservation_Order(1)
                .authDomain(authDomain)
                .equipmentAllowDomain(equipmentAllowDomain)
                .build();

        String username = authDomain.getName();
        int rank = reservationDomain.getReservation_Order();
        String classNumber = reservationDomain.getAuthDomain().getClassNumber();

        assertThat(username, is("김상현"));
        assertThat(rank, is(1));
        assertThat(classNumber, is("9999"));


    }


}
