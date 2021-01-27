package com.gsm.jupjup.dao;

import com.gsm.jupjup.domain.LaptopDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LaptopRepository extends JpaRepository<LaptopDomain, String> {
    Optional<LaptopDomain> findByLaptopSerialNumber(String laptopSerialNumber);
}
