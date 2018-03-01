package br.com.solutis.desafio.desafiosolutis.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.solutis.desafio.desafiosolutis.models.Clone;
import br.com.solutis.desafio.desafiosolutis.services.CloneService;

@RestController
@RequestMapping(value="/clones")
public class CloneResource {

	@Autowired
	private CloneService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findAll(@PathVariable Integer id) {
		Clone clone = service.find(id);
		
		return ResponseEntity.ok().body(clone);
	}
}
