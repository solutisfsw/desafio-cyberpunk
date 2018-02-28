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
        List<ExtraEquip> list = new ArrayList<>();
        extraEquipRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public ExtraEquip getExtraEquipById(Long id) {
    	ExtraEquip obj = extraEquipRepository.findById(id).get();
        return obj;
    }

    public void addExtraEquip(ExtraEquip extraEquip) {
    	extraEquipRepository.save(extraEquip);
    }
}
