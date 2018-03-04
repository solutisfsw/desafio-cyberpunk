package desafioSolutis.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import desafioSolutis.models.Adicional;
import desafioSolutis.models.Clone;
import desafioSolutis.repositories.AdicionalRepository;
import desafioSolutis.repositories.CloneRepository;
import desafioSolutis.services.AdicionalService;
import desafioSolutis.services.CloneService;

@RestController
public class CloneController {

	
	@Autowired
	private CloneRepository cloneRepository;
	
	@Autowired
	private AdicionalService adicionalService;
	
	@Autowired
	private CloneService cloneService;
	
	@Autowired
	private AdicionalRepository adicionalRepository;
	
    @RequestMapping("/clones")
    public List<Adicional> clones() {
        return this.adicionalRepository.findAllJoin();        
    }
    
    @RequestMapping("/teste")
    public String teste() {
        return "servico disponível";        
    }
     
    @RequestMapping("/clones/{id}")
    public Adicional clone(@PathVariable @Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="deve ser  um número") long id) {
        return this.adicionalRepository.findByIdClone(id);    	       
    }
    
    @RequestMapping(value = "/clones/add", method = RequestMethod.POST)
    public Adicional criar( @Valid  @RequestBody Adicional inputAdicional) {        
        Adicional adicional = this.adicionalService.save( inputAdicional, adicionalRepository, cloneRepository, cloneService);       
    	return adicional;
    }
        
    
    @RequestMapping(value = "/clones/{id}", method = RequestMethod.DELETE )
    public void delete(@PathVariable @Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="deve ser  um número") Long id) {
    	this.cloneService.delete(id, cloneRepository, adicionalService, adicionalRepository);    	
    }
    
    @RequestMapping(value = "/clones/{id}", method = RequestMethod.PUT )
    public Adicional update(@Valid @RequestBody Adicional adicionalUpdate, @PathVariable Long id) {    	 
    	return this.adicionalService.update(id, adicionalUpdate, cloneRepository, cloneService, adicionalRepository);       
    }
    
}