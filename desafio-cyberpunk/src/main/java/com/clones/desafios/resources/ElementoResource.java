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

import com.clones.desafios.model.Elemento;
import com.clones.desafios.repository.ElementoRepository;

@RestController
@CrossOrigin("${origem-permitida}")
public class ElementoResource {
	
	@Autowired
	private ElementoRepository elementoRepository;
	

	@GetMapping("/elementos")
	public List<Elemento> listar(){
		return elementoRepository.findAll();
	}
	@PostMapping("/elementos")
	public Elemento adicionar(@RequestBody @Valid Elemento membro) {
		return elementoRepository.save(membro);
	}
	
	@DeleteMapping(path= {"/elementos/{id}"})
	public void deletar(@PathVariable("id") Long id) {
		elementoRepository.delete(id);
	}
	
	@PutMapping("/elementos")
	public Elemento atualizar(@RequestBody @Valid Elemento membro) {
		return elementoRepository.save(membro);
	}
	
}
