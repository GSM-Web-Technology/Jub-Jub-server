package com.gsm.jupjup.dao;

import com.gsm.jupjup.domain.EquipmentDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<EquipmentDomain, Long> { }
