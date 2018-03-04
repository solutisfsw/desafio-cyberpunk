package desafioSolutis.services;

import org.springframework.stereotype.Service;

import desafioSolutis.models.Adicional;
import desafioSolutis.models.Clone;
import desafioSolutis.repositories.AdicionalRepository;
import desafioSolutis.repositories.CloneRepository;

@Service
public class AdicionalService {
	
	

	public Adicional save(Adicional adicional, AdicionalRepository adicionalRepository, CloneRepository cloneRepository,  CloneService cloneService){
		adicional.setClone(cloneService.save(adicional.getClone(), cloneRepository) );
		System.out.println("clone nulo? " + adicional.getClone() +  "  id=>>" + adicional.getClone().getId() );
		if(adicional.algumAdicional()) {
			return adicionalRepository.save(adicional);			
		}
				
		return adicional;		
	}
	
	public void delete(Long idClone, AdicionalRepository adicionalRepository) {
		Adicional adicional = adicionalRepository.findByIdClone(idClone);	    	
    	if(adicional != null) {
    		adicionalRepository.delete(adicional);
    	}
	}

	
	public Adicional update(Long id, Adicional adicionalUpdate, CloneRepository cloneRepository, CloneService cloneService, AdicionalRepository adicionalRepository) {
		Clone clone = cloneService.update(id, adicionalUpdate, cloneRepository);
		if(clone != null) {
			Adicional adicional = adicionalRepository.findByIdClone(id);
			adicionalUpdate.setClone(clone);
			if(adicional != null) {
	    		if(adicionalUpdate.algumAdicional()) {
	        		adicionalUpdate.setId(adicional.getId());
	    			adicional = adicionalRepository.save(adicionalUpdate);
	        	}else {
	        		adicionalRepository.delete(adicional);
	        		adicional = null;
	        	}
	    	}else {
	    		if(adicionalUpdate.algumAdicional()) {	    				    		
	    			adicional = adicionalRepository.save(adicionalUpdate);
	    		}
	    	}
	    	return adicional;
		}
		return null;
	}
}
