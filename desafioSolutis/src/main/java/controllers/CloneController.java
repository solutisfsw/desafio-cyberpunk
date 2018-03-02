package controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Clone;
import repositories.CloneRepository;

@RestController
public class CloneController {

	@Autowired
	private CloneRepository cloneRepository;
	
    @RequestMapping("/clones")
    public List<Clone> clones() {
        return this.cloneRepository.findAll();        
    }
    
    @RequestMapping("/teste")
    public String teste() {
        return "teste";        
    }
     
    @RequestMapping("/clones/{id}")
    public Clone clone(@PathVariable @Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="deve ser  um número") long id) {
        return this.cloneRepository.findById(id);        
    }
    
    @RequestMapping(value = "/clones/add", method = RequestMethod.POST)
    public Clone criar( @Valid @RequestBody Clone input) {
        Date date = new Date();
        input.setDataCriacao(date);    	
    	return this.cloneRepository.save(input);        
    }
    
    @RequestMapping(value = "/clones/teste", method = RequestMethod.POST)    
    public Clone teste( @ModelAttribute Clone input) {
        return this.cloneRepository.save(input);        
    }
    
    @RequestMapping(value = "/clones/{id}", method = RequestMethod.DELETE )
    public Clone delete(@PathVariable @Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="deve ser  um número") long id) {
    	Clone clone = this.cloneRepository.findById(id);    	
    	if(clone != null) {
    		this.cloneRepository.delete(id);    		
    	}
    	return null;
    }
    
    @RequestMapping(value = "/clones/{id}", method = RequestMethod.PUT )
    public Clone update(@Valid @RequestBody Clone cloneUpdate) {
    	Clone clone = this.cloneRepository.findById(cloneUpdate.getId());
    	cloneUpdate.setDataCriacao(clone.getDataCriacao());
    	return clone != null ? this.cloneRepository.save(cloneUpdate) : null;    
    }
    
}