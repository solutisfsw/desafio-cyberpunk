package com.solutis.clonaria.replicante.service;

import java.util.Optional;

import com.solutis.clonaria.replicante.exception.CloneExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solutis.clonaria.replicante.repository.ExtraEquipRepository;
import com.solutis.clonaria.replicante.model.ExtraEquip;

@Service
public class ExtraEquipService {

 
 @Autowired
    private ExtraEquipRepository extraEquipRepository;

    public Iterable<ExtraEquip> getAllExtraEquip() {
        return extraEquipRepository.findAll();
    }

    public Optional<ExtraEquip> getExtraEquipById(Long id) {
     if(id == null){
            throw new CloneExceptions("Não podemos pesquisar Equipamento sem id.");
        }
        return extraEquipRepository.findById(id);
    }

    public void addExtraEquip(ExtraEquip extraEquip) {
     extraEquipRepository.save(extraEquip);
    }
}