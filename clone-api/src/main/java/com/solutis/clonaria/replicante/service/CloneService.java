package com.solutis.clonaria.replicante.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.clonaria.replicante.exception.CloneExceptions;
import com.solutis.clonaria.replicante.model.Clone;
import com.solutis.clonaria.replicante.repository.CloneRepository;

@Service
public class CloneService extends CloneExceptions {
	@Autowired
	private CloneRepository cloneRepository;
	
	
    public Iterable<Clone> getAllClones() {
        return cloneRepository.findAll();
    }

    
    public void deleteClone(Long id) {
        if(id == null){
            throw new CloneExceptions("Só podemos deletar um clone com uma Id não nula.");
        }
        cloneRepository.deleteById(id);
    }
    
    public Optional<Clone> getCloneById(Long id) {
        if(id == null){
            throw new CloneExceptions("Oops, não podemos pesquisar sem id.");
        }
        return cloneRepository.findById(id);
    }

    public Clone findByNome(String nome) {
        return cloneRepository.findByNome(nome);
    }
    
    
    public Clone addClone(Clone clone) {
        Clone cloneBase = findByNome(clone.getNome());

        if(clone.getId() == null && cloneBase != null){
            throw new CloneExceptions("Nome já existente no sistema. Favor tentar outro.");
        }
        
        if(clone.getId() != null && (!cloneBase.getId().equals(clone.getId()) && clone.getNome().equals(cloneBase.getNome()))){
            throw new CloneExceptions("Nome já existente no sistema. Favor tentar outro.");
        }
        cloneRepository.save(clone);
        return cloneRepository.findById(clone.getId()).get();

    }

    
    

    
    
}
