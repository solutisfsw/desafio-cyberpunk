package org.juanfsrv.cyberpunk.controller;

import java.util.List;
import org.juanfsrv.cyberpunk.entity.AdicionalEntity;
import org.juanfsrv.cyberpunk.service.AdicionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdicionalController {
	
	@Autowired
	private AdicionalService adicionalService;
	
	@RequestMapping("/clones/{cloneId}/adicionais")
	public List<AdicionalEntity> getAllAdicional(@PathVariable int id) {
		return adicionalService.getAllAdicional(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/clones/{cloneId}/adicionais")
	public void addAdicional(@RequestBody AdicionalEntity adicional, @PathVariable int cloneId) {	
		adicional.setId_clone(cloneId);
		adicionalService.addAdicional(adicional);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/clones/{cloneId}/adicionais/{id}")
	public void updateAdicional(@RequestBody AdicionalEntity adicional,@PathVariable int cloneId) {
		adicional.setId_clone(cloneId);
		adicionalService.updateAdicional(adicional);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/clones/{cloneId}/adicionais/{id}")
	public void deleteAdicional(@PathVariable int id) {
		adicionalService.deleteAdicional(id);
	}

}
