package br.com.solutis.desafio.desafiosolutis.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.solutis.desafio.desafiosolutis.models.Clone;
import br.com.solutis.desafio.desafiosolutis.services.CloneService;

@RestController
@RequestMapping(value="/apiclones")
public class CloneResource {

	@Autowired
	private CloneService service;
	
	@RequestMapping(value="/listarTodos", method=RequestMethod.GET)
	public ResponseEntity<List<Clone>> listarTodos() {
		return ResponseEntity.ok().body(this.service.listarTodos());
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> listaPorId(@PathVariable Integer id) {
		Clone clone = service.listarPorId(id);
		
		return ResponseEntity.ok().body(clone);
	}
	
	@PostMapping
	public ResponseEntity<Clone> cadastrar(@RequestBody Clone clone){
		
		return ResponseEntity.ok().body(this.service.cadastrar(clone));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Clone> atualizar(@PathVariable(name = "id") Integer id, @RequestBody Clone clone){
		
		return ResponseEntity.ok().body(this.service.atualizar(id, clone));
	}
	
	@DeleteMapping(path ="/{id}")
	public ResponseEntity<Integer> remover(@PathVariable(name = "id") Integer id){
		this.service.apagar(id);
		
		return ResponseEntity.ok(1);
	}
}
