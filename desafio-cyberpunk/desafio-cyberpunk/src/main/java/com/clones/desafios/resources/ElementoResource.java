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
import com.clones.desafios.services.ElementoService;

@RestController
@CrossOrigin("${origem-permitida}")
public class ElementoResource {
	
	@Autowired
	private ElementoService es;
	

	@GetMapping("/elementos")
	public List<Elemento> listar(){
		return es.listarTodos();
	}
	@PostMapping("/elementos")
	public Elemento adicionar(@RequestBody @Valid Elemento elemento) {
		return es.salvar(elemento);
	}
	
	@DeleteMapping(path= {"/elementos/{id}"})
	public void deletar(@PathVariable("id") Long id) {
		es.deletar(id);
	}
	
	@PutMapping("/elementos")
	public Elemento atualizar(@RequestBody @Valid Elemento elemento) {
		return es.atualizar(elemento);
	}
	
}
