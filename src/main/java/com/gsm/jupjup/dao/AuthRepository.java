package com.gsm.jupjup.dao;

import com.gsm.jupjup.domain.AuthDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AuthRepository extends JpaRepository<AuthDomain, Long> {
    Optional<AuthDomain> findByEmail(String email);
}
