package com.gsm.jupjup.dao;

import com.gsm.jupjup.domain.AuthDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<AuthDomain, Long> { }
