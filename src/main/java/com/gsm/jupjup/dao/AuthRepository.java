package com.gsm.jupjup.dao;

import com.gsm.jupjup.domain.AuthDomain;
import com.gsm.jupjup.dto.v1.auth.AuthLoginRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;


public interface AuthRepository extends JpaRepository<AuthDomain, Long> {
    AuthDomain findByEmail(String email);
}
