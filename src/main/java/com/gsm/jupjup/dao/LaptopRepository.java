package com.gsm.jupjup.dao;

import com.gsm.jupjup.domain.LaptopDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<LaptopDomain, String> { }
