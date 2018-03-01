package br.com.solutis.desafio.desafiosolutis.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.solutis.desafio.desafiosolutis.models.Clone;
import br.com.solutis.desafio.desafiosolutis.repository.CloneRepository;

@Service
public class CloneService {

	@Autowired
	private CloneRepository cloneRepository;
	
	public Clone find(Integer id) {
		Clone clone = cloneRepository.findOne(id);
		return clone;
	}
	
	public List<Clone> findAll() {
		List<Clone> clone = cloneRepository.findAll();
		return clone;
	}
}
