package com.br.cyberpunk.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.cyberpunk.model.Clone;
import com.br.cyberpunk.repositories.CloneRepository;


@RestController
@RequestMapping (value="/cloneapp")
public class CloneResource {
	@Autowired
	private CloneRepository cloneRepository;
	
	
	@PostMapping
	public ResponseEntity<Clone> cadastrar(@RequestBody Clone clone){
	
	return ResponseEntity.ok().body(cloneRepository.save(clone));
	
	}
	
	@GetMapping
	public ResponseEntity<List<Clone>> listClones(){
		
	return ResponseEntity.ok().body(cloneRepository.findAll());
	
	}
	@PutMapping(path="/{id}")
	public ResponseEntity<Clone> atualizarClones(@PathVariable("id")Long id, @RequestBody Clone cloneEditado){
		Clone clone= cloneRepository.findById(id);
	
		return ResponseEntity.ok().body(cloneRepository.save (clone));
	
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Integer> destruirClones(@PathVariable("id")Long id){
		Clone clone= cloneRepository.findById(id);
		cloneRepository.delete(clone);
		return ResponseEntity.ok(1);
	
	}

}
