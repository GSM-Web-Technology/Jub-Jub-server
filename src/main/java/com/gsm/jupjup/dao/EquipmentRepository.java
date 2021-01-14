package com.gsm.jupjup.dao;

import com.gsm.jupjup.domain.EquipmentDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<EquipmentDomain, Long> {
    Optional<EquipmentDomain> findByName(String name);
}
