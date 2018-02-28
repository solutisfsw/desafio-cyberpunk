package com.solutis.clonaria.replicante.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutis.clonaria.replicante.exception.CloneExceptions;
import com.solutis.clonaria.replicante.model.Clone;
import com.solutis.clonaria.replicante.repository.CloneRepository;

@Service
public class CloneService extends CloneExceptions {
	@Autowired
	private CloneRepository cloneRepository;
	
	
    public List<Clone> getAllClones() {
        List<Clone> list = new ArrayList<>();
        cloneRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    
    public void deleteClone(Long id) {
        if(id == null){
            throw new CloneExceptions("Só podemos deletar um clone com uma Id não nula.");
        }
        cloneRepository.delete(getCloneById(id));
    }
    
    public Clone getCloneById(Long id) {
        if(id == null){
            throw new CloneExceptions("Sem Id não podemos pesquisar pelos clones.");
        }
        Clone obj = cloneRepository.findById(id).get();
        return obj;
    }

    public Clone findByNome(String nome) {
        return cloneRepository.findByNome(nome);
    }
    
    
    public void addClone(Clone clone) {
        Clone cloneBase = findByNome(clone.getNome());

        if(clone.getNome() == null){
            throw new CloneExceptions("Erro. Todo clone deve ter um nome.");
        }

        if(clone.getId() == null && cloneBase != null){
            throw new CloneExceptions("Nome já existente no sistema. Favor tentar outro.");
        }
        
        if(clone.getId() != null && (!cloneBase.getId().equals(clone.getId()) && clone.getNome().equals(cloneBase.getNome()))){
            throw new CloneExceptions("Nome já existente no sistema. Favor tentar outro.");
        }
        
        if(!clone.getNome().matches("[A-Z]{3}[0-9]{4}")){
            throw new CloneExceptions("Clones devem ter seus nomes criados com base no padrao ABC1234");
        }
        if(clone.getIdade() == null){
            throw new CloneExceptions("Erro. Campo Idade Obrigatório.");
        }
        if(clone.getIdade() < 10 || clone.getIdade() > 20){
            throw new CloneExceptions("O clone só pode ser cadastrado se tiver idade maior que 10 e menor que 20.");
        }

        try {
            cloneRepository.save(clone);
        } catch (NullPointerException e){
            throw new CloneExceptions("Checar Informações Fornecidas. campos incompletas");
        } catch (Exception e){
            throw new CloneExceptions("Erro Intero no servidor. Tentar novamente mais tarde", e);
        }

    }

    
    

    
    
}
