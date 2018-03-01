package controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Clone;
import repositories.CloneRepository;

@RestController
public class TesteController {

	@Autowired
	private CloneRepository cloneRepository;
	
    @RequestMapping("/clones")
    public List<Clone> clones() {
        return this.cloneRepository.findAll();        
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
    
}