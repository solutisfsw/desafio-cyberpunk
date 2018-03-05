package org.juanfsrv.cyberpunk.service;

import java.util.ArrayList;
import java.util.List;
import org.juanfsrv.cyberpunk.entity.AdicionalEntity;
import org.juanfsrv.cyberpunk.repository.AdicionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionalService {
	
	@Autowired
	private AdicionalRepository adicionalRepository;
	
	public void addAdicional(AdicionalEntity adicional) {
		adicionalRepository.save(adicional);
	}
	
	public List<AdicionalEntity> getAllAdicional(int id) {
		List<AdicionalEntity> adicional = new ArrayList<>();
		adicionalRepository.findById(id).forEach(adicional::add);
		return adicional;
	}
	
	public void updateAdicional(AdicionalEntity adicional) {
		adicionalRepository.save(adicional);
	}
	
	public void deleteAdicional(int id) {
		adicionalRepository.deleteById(id);;
	}

}
