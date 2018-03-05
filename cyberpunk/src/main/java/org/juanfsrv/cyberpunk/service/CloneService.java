package org.juanfsrv.cyberpunk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.juanfsrv.cyberpunk.entity.CloneEntity;
import org.juanfsrv.cyberpunk.repository.CloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloneService {
	
	@Autowired
	private CloneRepository cloneRepository;
	
	public void addClone(CloneEntity clone) {
		cloneRepository.save(clone);
	}
	
	public List<CloneEntity> getAllClones() {
		List<CloneEntity> clones = new ArrayList<>();
		cloneRepository.findAll().forEach(clones::add);
		return clones;
	}
	
	public Optional<CloneEntity> getClone(int id) {
		return cloneRepository.findById(id);
	}
	
	public void updateClone(int id,CloneEntity clone) {
		cloneRepository.save(clone);
	}
	
	public void deleteClone(int id) {
		cloneRepository.deleteById(id);;
	}

}
