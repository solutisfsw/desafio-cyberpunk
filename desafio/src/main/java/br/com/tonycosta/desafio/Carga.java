package br.com.tonycosta.desafio;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.tonycosta.desafio.domain.Adicional;
import br.com.tonycosta.desafio.domain.Clone;
import br.com.tonycosta.desafio.domain.CloneRepository;

@Configuration
public class Carga implements CommandLineRunner {
	
	@Autowired
	private CloneRepository repository;
	
	@Override
	public void run(String... arg0) throws Exception {
		Clone clone = new Clone();
		clone.setNome("ABC1234");
		clone.setIdade(15);
		clone.getAdicionais().add(Adicional.ESQUELETO_REFORCADO);
		clone.getAdicionais().add(Adicional.BRACO_MECANICO);
		
		Clone clone2 = new Clone();
		clone2.setNome("DEF4568");
		clone2.setIdade(11);
		
		Clone clone3 = new Clone();
		clone3.setNome("GHI9863");
		clone3.setIdade(20);
		clone3.getAdicionais().add(Adicional.PELE_ADAPTATIVA);

		Clone clone4 = new Clone();
		clone4.setNome("XZS0011");
		clone4.setIdade(14);
		clone4.getAdicionais().add(Adicional.RAIO_LASER);
		clone4.getAdicionais().add(Adicional.SENTIDOS_AGUCADOS);
		
		Clone clone5 = new Clone();
		clone5.setNome("POW7854");
		clone5.setIdade(12);
		clone5.getAdicionais().add(Adicional.ESQUELETO_REFORCADO);
		clone5.getAdicionais().add(Adicional.BRACO_MECANICO);
		clone5.getAdicionais().add(Adicional.SENTIDOS_AGUCADOS);
		clone5.getAdicionais().add(Adicional.RAIO_LASER);
		
		repository.save(Arrays.asList(clone, clone2, clone3, clone4, clone5));
	}
	
}
