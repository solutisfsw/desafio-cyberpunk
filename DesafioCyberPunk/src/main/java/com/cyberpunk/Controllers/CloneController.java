package com.cyberpunk.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyberpunk.Entidade.Clone;
import com.cyberpunk.Repositorio.RepositorioDeClones;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest")
public class CloneController {
	@Autowired
	
	@Qualifier("repositorioDeClones")
	private RepositorioDeClones repositorioDeClones;
	
	@GetMapping("/Clones")
	public List<Clone> getClones(){
		return repositorioDeClones.findAll(); 
	}
		
	@DeleteMapping("/Clone/{Id}")
	public boolean deleteClone(@PathVariable Long Id){
		repositorioDeClones.deleteById(Id); 
		return true;
	}
	
    @Transactional
	@PostMapping("/Clone")
	public Clone criarClone(@RequestBody Clone novoClone){
		return repositorioDeClones.saveAndFlush(novoClone); 
	}
	
	@PutMapping("/Clone")
	public Clone alterarClone(@RequestBody Clone novoClone){
		return repositorioDeClones.save(novoClone); 
	}
	
}
