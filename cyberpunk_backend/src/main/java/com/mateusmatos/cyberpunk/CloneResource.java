package com.mateusmatos.cyberpunk;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateusmatos.cyberpunk.models.Clone;
import com.mateusmatos.cyberpunk.services.CloneService;

@RestController
public class CloneResource {

  private Map<Integer, Clone> clones;
  
  @Autowired
  CloneService cloneService;

  @RequestMapping(value = "/clones", method = RequestMethod.GET)
  public Iterable<Clone> listar() {
	   return cloneService.listarClones();
  }
 
  
  @RequestMapping(value = "/clones", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public boolean criar( Clone data) {
	  return cloneService.adicionarClones(data);
  }
  
  @RequestMapping(value = "/clones/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public boolean atuazlizar(@PathVariable("id") long id, Clone data) {
	  return cloneService.atualizarClones(data, id);
  }
  
  @RequestMapping(value = "/clones/{id}", method = RequestMethod.GET)
  public Clone encontrar(@PathVariable("id") long id) {
	  return cloneService.buscarClones(id);
	} 

  @RequestMapping(value = "/clones/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<?> deletar(@PathVariable("id") long id) {
	  cloneService.removeClones(id);
	 	 
	  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} 
	

}
