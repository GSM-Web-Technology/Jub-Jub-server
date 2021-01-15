package com.gsm.jupjup;

import com.gsm.jupjup.domain.AuthDomain;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class JupjupApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JupjupApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final List<Spec> menu = Arrays.asList(

		)
	}

}
