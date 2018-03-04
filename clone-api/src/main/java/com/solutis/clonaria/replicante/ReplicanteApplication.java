package com.solutis.clonaria.replicante;

import com.solutis.clonaria.replicante.repository.ExtraEquipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.solutis.clonaria.replicante.model.ExtraEquip;

import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaRepositories("com.solutis.clonaria.replicante.repository")

public class ReplicanteApplication {

	@Autowired
	ExtraEquipRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ReplicanteApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
        return args -> {
            System.out.println("Equipamentos Criados!");
			Stream.of("braço mecânico", "esqueleto reforçado", "sentidos aguçados", "pele adaptativa", "raio laser").forEach(nome -> {
				ExtraEquip extraEquip = new ExtraEquip();
				extraEquip.setNome(nome);
				repository.save(extraEquip);
				repository.findAll().forEach(System.out::println);
			});
        };
    }
}
