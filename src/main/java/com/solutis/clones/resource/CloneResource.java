package com.solutis.clones.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.solutis.clones.model.Clone;
import com.solutis.clones.repository.CloneRepository;

@RestController
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
	
	@GetMapping("/clones/{id}")
	public ResponseEntity<Clone> getClonePorId(@PathVariable(value = "id") Long id ){
		Clone clone = cloneRepository.findOne(id);
		
		if(clone == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(clone);
	}
	
	@PutMapping("/clones/{id}")
	public ResponseEntity<Clone> alteraClonePorId(@PathVariable(value = "id") Long id, @RequestBody @Valid Clone cloneAlterado ){
		
		Clone clone = cloneRepository.findOne(id);
		
		if(clone == null) {
			return ResponseEntity.notFound().build();
		}
		
		clone.setNome(cloneAlterado.getNome());
		clone.setIdade(cloneAlterado.getIdade());
		clone.setAdicionais(cloneAlterado.getAdicionais());
		
		Clone updateClone = cloneRepository.save(clone);
		
		return ResponseEntity.ok(updateClone);
	}
	
	@DeleteMapping("/clones/{id}")
	public ResponseEntity<Clone> deleteClonePorId(@PathVariable(value = "id") Long id ){
		Clone clone = cloneRepository.findOne(id);
		
		if(clone == null) {
			return ResponseEntity.notFound().build();
		}
		
		cloneRepository.delete(clone);
		return ResponseEntity.ok().body(clone);
	}
}
