package br.com.clone.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.clone.exception.CloneAlreadyExistException;
import br.com.clone.exception.CloneNotFoundExcption;
import br.com.clone.model.Clone;
import br.com.clone.repository.CloneRepository;

@Service
public class CloneService {
	
	@Autowired
	private CloneRepository cloneRepository;
	
	@Transactional (readOnly=true)
	public List<Clone> findAll(){
		return cloneRepository.findAll();	
	}
	
	@Transactional (readOnly=true)
	public Clone findById(Long id) {
		if(!exist(id)) {
			throw new CloneNotFoundExcption("Clone com esse id não existe:" + id);
		}
		return cloneRepository.findOne(id);
	}
	
	@Transactional (readOnly=true)
	private boolean exist(Long id) {
		
		return cloneRepository.exists(id);
	}
	
	@Transactional (readOnly=false)
	public Clone save(Clone c) {
		if (c.getIdClone() != null && exist(c.getIdClone())) {
			throw new CloneAlreadyExistException("Clone com esse id já existe:" + c.getIdClone());
		}
		
		return cloneRepository.save(c);
	}

	@Transactional (readOnly=false)
	public Clone update(Clone c) {
		if(!exist(c.getIdClone())) {
			throw new CloneNotFoundExcption("Clone com esse id não existe:" + c.getIdClone());
		}
		
		return cloneRepository.save(c);
	}

	@Transactional (readOnly=false)
	public void delete(Clone c) {
		cloneRepository.delete(c);
	}

}
