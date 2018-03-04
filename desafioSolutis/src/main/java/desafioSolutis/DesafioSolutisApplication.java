package desafioSolutis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"desafioSolutis.controllers", "desafioSolutis.services"})
@EntityScan("desafioSolutis.models")
@EnableJpaRepositories("desafioSolutis.repositories")

public class DesafioSolutisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioSolutisApplication.class, args);
	}
}
