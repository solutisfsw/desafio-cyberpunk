package org.juanfsrv.cyberpunk.controller;

import java.util.List;
import java.util.Optional;
import org.juanfsrv.cyberpunk.entity.CloneEntity;
import org.juanfsrv.cyberpunk.service.CloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloneController {
	
	@Autowired
	private CloneService cloneService;
	
	@RequestMapping("/clones")
	public List<CloneEntity> getAllClones() {
		return cloneService.getAllClones();
	}
	
	@RequestMapping("/clones/{id}")
	public Optional<CloneEntity> getClone(@PathVariable int id) {
		return cloneService.getClone(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/clones")
	public void addClone(@RequestBody CloneEntity clone) {
		cloneService.addClone(clone);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/clones/{id}")
	public void updateClone(@RequestBody CloneEntity clone,@PathVariable int id) {
		cloneService.updateClone(id,clone);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/clones/{id}")
	public void deleteClone(@PathVariable int id) {
		cloneService.deleteClone(id);
	}
}
