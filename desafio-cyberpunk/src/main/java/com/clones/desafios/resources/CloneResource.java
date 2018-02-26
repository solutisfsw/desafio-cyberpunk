package com.clones.desafios.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clones.desafios.model.Clone;
import com.clones.desafios.repository.CloneRepository;

@RestController
@CrossOrigin("${origem-permitida}")
public class CloneResource {
	
	@Autowired
	private CloneRepository cloneRepository;
	
	@GetMapping("/clones")
	public List<Clone> listar(){
		return cloneRepository.findAll();
	}
	
	@PostMapping("/clones")
	public Clone adicionar(@RequestBody @Valid Clone clone) {
		return cloneRepository.save(clone);
	}
	
	@DeleteMapping(path= {"/clones/{id}"})
	public void deletar(@PathVariable("id") Long id) {
		 cloneRepository.delete(id);
	}
	
	@PutMapping("/clones")
	public Clone atualizar(@RequestBody @Valid Clone clone) {
		return cloneRepository.save(clone);
	}
}
