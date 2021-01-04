package com.gsm.jupjup.dao;

import com.gsm.jupjup.domain.TestDomain;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA를 상속 받는다 => CRUD 자동화
public interface TestRepo extends JpaRepository<TestDomain, Long> { }