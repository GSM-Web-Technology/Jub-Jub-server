package com.gsm.jupjup.dao;

import com.gsm.jupjup.domain.LaptopSpecDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LaptopSpecRepository extends JpaRepository<LaptopSpecDomain, Long> {
    Optional<Object> findBySpec_Idx(String laptopSpec_idx);
}
