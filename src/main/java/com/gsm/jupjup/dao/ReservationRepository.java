package com.gsm.jupjup.dao;

import com.gsm.jupjup.domain.ReservationDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationDomain, Long> { }
