package com.gsm.jupjup.dao;

import com.gsm.jupjup.domain.EquipmentAllowDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipmentAllowRepository extends JpaRepository<EquipmentAllowDomain, Long> {
//    @Query("select e.reason from EquipmentAllowDomain e join fetch e.equipmentDomain")
//    List<String> findAllBy();
}
