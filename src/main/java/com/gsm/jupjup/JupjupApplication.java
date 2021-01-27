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
@EnableJpaAuditing
@RequiredArgsConstructor
public class JupjupApplication implements CommandLineRunner {
	@Autowired
	private final LaptopSpecRepository laptopSpecRepository;

	public static void main(String[] args) {
		SpringApplication.run(JupjupApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final List<LaptopSpecDomain> laptopSpecDomainList = Arrays.asList(
				LaptopSpecDomain.builder()
						.CPU("intel-i7")
						.GPU("LadeonPro5600")
						.RAM("16gb")
						.SSD("256gb")
						.HDD("1tb")
						.build(),
				LaptopSpecDomain.builder()
						.CPU("intel-i9")
						.GPU("Pro3455")
						.RAM("15gb")
						.SSD("356gb")
						.HDD("1tb")
						.build(),
				LaptopSpecDomain.builder()
						.CPU("intel-i9")
						.GPU("sexy")
						.RAM("256gb")
						.SSD("1pb")
						.HDD("1tb")
						.build());

		List<LaptopSpecDomain> savedLaptopSpecDomainList = laptopSpecRepository.saveAll(laptopSpecDomainList);
		savedLaptopSpecDomainList.forEach(System.out::println);
	}
}
