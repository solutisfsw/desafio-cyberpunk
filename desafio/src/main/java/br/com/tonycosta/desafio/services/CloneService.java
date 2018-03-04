package br.com.tonycosta.desafio.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tonycosta.desafio.domain.Clone;
import br.com.tonycosta.desafio.domain.CloneRepository;
import br.com.tonycosta.desafio.exceptions.EntidadeNaoEncontradaException;

@Service
public class CloneService {

	@Autowired
	private CloneRepository repository;
	
	public Page<Clone> lista(Pageable pageable, String q) {
		return repository.findByNomeContainingIgnoreCase(pageable, q);
	}
	
	public void salva(Clone clone) {
		repository.save(clone);
	}
	
	public Clone buscaPorId(Long id) {
		Clone clone = repository.findOne(id);
		if(clone == null)
			throw new EntidadeNaoEncontradaException("Clone com id "+id+" não foi encontrado");
		
		return clone;
	}
	
	public void remove(Long id) {
		repository.delete(id);
	}

	public void edita(Clone clone, Long id) {
		Clone cloneDoBD = buscaPorId(id);
		BeanUtils.copyProperties(clone, cloneDoBD, "id", "dataDeCriacao");
		
		salva(cloneDoBD);
	}

	public Clone buscaPorNome(String nome) {
		Clone clone = repository.findByNomeIgnoreCase(nome);
		if(clone == null)
			throw new EntidadeNaoEncontradaException("Clone com nome "+nome+" não foi encontrado");
		
		return clone;
	}
	
}
