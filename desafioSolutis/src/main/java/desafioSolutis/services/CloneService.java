package desafioSolutis.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import desafioSolutis.models.Adicional;
import desafioSolutis.models.Clone;
import desafioSolutis.repositories.AdicionalRepository;
import desafioSolutis.repositories.CloneRepository;

@Service
public class CloneService {

	
	public Clone save(Clone clone, CloneRepository cloneRepository) {		
		Date date = new Date();
		clone.setDataCriacao(date);		
		
		return cloneRepository.save(clone);		
	}

	public void delete(Long id, CloneRepository cloneRepository, AdicionalService adicionalService, AdicionalRepository adicionalRepository) {
		Clone clone = cloneRepository.findById(id);
		if(clone != null) {			
			adicionalService.delete(id, adicionalRepository);
	    	cloneRepository.delete(id);	    	    	
	    }
	}

	public Clone update(Long id,Adicional adicionalUpdate, CloneRepository cloneRepository){
		if(cloneRepository.exists(id)) {
			Clone clone = adicionalUpdate.getClone();
			clone.setId(id);			
			return cloneRepository.save(clone);		
		}
		
		return null;
	}
}
