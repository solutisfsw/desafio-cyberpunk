package br.com.clone.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import br.com.clone.model.Clone;
import br.com.clone.representation.CloneRepresentation;
import br.com.clone.service.CloneService;


@CrossOrigin
@RestController
@RequestMapping("/clones")
public class CloneResources {
	
	@Autowired
	private CloneService cloneService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<CloneRepresentation>> listAll(){
		
						//Listar
		List<Clone> clones = cloneService.findAll();
		List<CloneRepresentation> cloneRepresentation = new ArrayList<>();
		
		for(Clone c : clones) {
			cloneRepresentation.add(new CloneRepresentation(c));
		}
		
		return ResponseEntity.ok(cloneRepresentation);
	}
	
						//Busca por id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<CloneRepresentation> findById(@PathVariable("id")Long id){
		
		Clone clone = cloneService.findById(id);
		CloneRepresentation cloneRepresentation = new CloneRepresentation(clone);
		
		return ResponseEntity.ok(cloneRepresentation);
	}
	
						//Salvar
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody CloneRepresentation cloneRepresentation){
		
		Clone clone = cloneService.save(CloneRepresentation.build(cloneRepresentation));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clone.getIdClone())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
						//Editar
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody CloneRepresentation cloneRepresentation, @PathVariable("id")Long id){
		cloneRepresentation.setIdentifier(id);
		cloneService.update(CloneRepresentation.build(cloneRepresentation));
		
		return ResponseEntity.noContent().build();
	}
	

						//Remover
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<CloneRepresentation> delete(@PathVariable("id")Long id){
		
		Clone clone = cloneService.findById(id);
		CloneRepresentation cloneRepresentation = new CloneRepresentation(clone);
		cloneService.delete(clone);
		
		return ResponseEntity.ok(cloneRepresentation);
	}
}
