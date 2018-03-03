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
	
	public Clone listarPorId(Integer id) {
		Clone clone = this.cloneRepository.findOne(id);
		return clone;
	}
	
	public List<Clone> listarTodos() {
		List<Clone> clone = this.cloneRepository.findAll();
		return clone;
	}
	
	public Clone cadastrar(Clone clone) {
		this.cloneRepository.save(clone);
		return clone;
	}
	
	public Clone atualizar(Integer id, Clone clone) {
		Clone cloneSalvo = this.cloneRepository.findOne(id);
		
		clone.setDataCriacao(cloneSalvo.getDataCriacao());
		this.cloneRepository.save(clone);
		
		return clone;
	}
	
	public void apagar(Integer id) {
		this.cloneRepository.delete(id);
	}
}
