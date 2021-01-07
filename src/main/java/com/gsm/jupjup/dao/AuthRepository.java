package com.gsm.jupjup.dao;

import com.gsm.jupjup.domain.AuthDomain;
import com.gsm.jupjup.dto.v1.auth.AuthLoginRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;


public interface AuthRepository extends JpaRepository<AuthDomain, Long> {
    AuthDomain findByEmailAndPassword(String email, String password);
}
