package com.gsm.jupjup.dao;

import com.gsm.jupjup.domain.LaptopSpecDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LaptopSpecRepository extends JpaRepository<LaptopSpecDomain, Long> {
    //Optional<Object> findBySpec_Idx(String laptopSpec_idx);


    @Query("select l from LaptopSpecDomain l where l.spec_Idx = :idx")
    LaptopSpecDomain findBySpec_Idx(Long idx);

}
