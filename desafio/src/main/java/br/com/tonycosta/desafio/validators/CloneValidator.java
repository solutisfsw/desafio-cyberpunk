package br.com.tonycosta.desafio.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.tonycosta.desafio.domain.Clone;
import br.com.tonycosta.desafio.domain.CloneRepository;

@Component
public class CloneValidator implements Validator {

	@Autowired
	private CloneRepository repository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Clone.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Clone clone = (Clone) target;
		
		nomeRepetido(errors, clone);
	}

	private void nomeRepetido(Errors errors, Clone clone) {
		if(!StringUtils.isEmpty(clone.getNome())) {
			Clone cloneBuscado = repository.findByNomeIgnoreCase(clone.getNome());
			
			if(cloneBuscado != null && !cloneBuscado.getId().equals(clone.getId()))
				errors.reject("nome", "Já existe um clone com este nome");
		}
	}
}
