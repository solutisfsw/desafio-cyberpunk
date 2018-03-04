package com.solutis.clonaria.replicante.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solutis.clonaria.replicante.repository.ExtraEquipRepository;
import com.solutis.clonaria.replicante.model.ExtraEquip;

@Service
public class ExtraEquipService {

	
	@Autowired
    private ExtraEquipRepository extraEquipRepository;

    public List<ExtraEquip> getAllExtraEquip() {
        return ExtraEquipRepository.findAll();
    }

    public Optional<ExtraEquip> getExtraEquipById(Long id) {
    	if(id == null){
            throw new CloneException("Não podemos pesquisar Equipamento sem id.");
        }
        return ExtraEquipRepository.findById(id);
    }

    public void addExtraEquip(ExtraEquip extraEquip) {
    	extraEquipRepository.save(extraEquip);
    }
}
