package com.clones.desafios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clones.desafios.model.Elemento;
import com.clones.desafios.repository.ElementoRepository;

@Service
public class ElementoService {
	@Autowired
	private ElementoRepository elementoRepository;

	public List<Elemento> listarTodos() {
		return elementoRepository.findAll();
	}

	public Elemento salvar(Elemento elemento) {
		return elementoRepository.save(elemento);
	}

	public void deletar(Long id) {
		
		elementoRepository.delete(id);
	}
	

	public Elemento atualizar(Elemento elemento) {
		return elementoRepository.save(elemento);
	}
	
}
