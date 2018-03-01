package br.com.solutis.desafio.desafiosolutis.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.solutis.desafio.desafiosolutis.models.Clone;
import br.com.solutis.desafio.desafiosolutis.repository.CloneRepository;

@Controller
public class CloneController {
	
	@Autowired
	private CloneRepository cr;

	@RequestMapping(value="/criarClone", method=RequestMethod.GET)
	public String form() {
		return "clone/formClone";
	}
	
	@RequestMapping(value="/criarClone", method=RequestMethod.POST)
	public String form(Clone clone) {
		LocalDate dataAtual = LocalDate.now();
		
		clone.setDataCriacao(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataAtual));
		try {
			cr.save(clone);
		} catch (Exception e) {
			System.out.println("Não é possível salvar dois nomes iguais.");
		}
		
		
		return "redirect:/criarClone";
	}
	
	@RequestMapping("/listaClones")
	public ModelAndView listaClones() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Clone> clones = cr.findAll();
		
		mv.addObject("clones", clones);
		return mv;
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView editarClone(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("clone/editar");
		Clone clone = cr.findOne(id);
		mv.addObject("clone", clone);
		
		return mv;
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String editarClones(@PathVariable("id") Integer id, Clone cloneEdit) {
		Clone copyClone = cr.findOne(id);
		
		cloneEdit.setDataCriacao(copyClone.getDataCriacao());
		cr.save(cloneEdit);
		
		return "redirect:listaClones";
	}
	
	
	@RequestMapping("/apagar")
	public String apagarClone(Integer id) {
		Clone clone = cr.findOne(id);
		cr.delete(clone);
		
		return "redirect:listaClones";
	}
}
