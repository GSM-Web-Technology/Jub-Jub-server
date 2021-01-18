package com.gsm.jupjup;

import com.gsm.jupjup.dao.EquipmentAllowRepository;
import com.gsm.jupjup.dao.EquipmentRepository;
import com.gsm.jupjup.domain.EquipmentDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;
import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class JupjupApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(JupjupApplication.class, args);
	}
}
