package com.clones.desafios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clones.desafios.model.Clone;
import com.clones.desafios.repository.CloneRepository;

@Service
public class CloneService {

	@Autowired
	private CloneRepository cloneRepository;

	public Boolean consultaNome(String nome) {
		return cloneRepository.buscaPeloNome(nome);
	}
	public List<Clone> listarTodos(){
		return cloneRepository.findAll();
	}
	
	public Clone salvar(Clone clone) {
		return cloneRepository.save(clone);
	}
	
	public void deletar(Long id) {
		cloneRepository.delete(id);
	}
	
	public Clone atualizar(Clone clone) {
		return cloneRepository.save(clone);
	}
}
