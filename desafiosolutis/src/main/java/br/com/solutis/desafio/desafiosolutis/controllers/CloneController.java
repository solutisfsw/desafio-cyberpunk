package br.com.solutis.desafio.desafiosolutis.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.solutis.desafio.desafiosolutis.models.Adicionais;
import br.com.solutis.desafio.desafiosolutis.models.Clone;
import br.com.solutis.desafio.desafiosolutis.repository.AdicionaisRepository;
import br.com.solutis.desafio.desafiosolutis.repository.CloneRepository;

@Controller
public class CloneController {
	
	@Autowired
	private CloneRepository cr;
	@Autowired
	private AdicionaisRepository ar;

	@RequestMapping(value="/criarClone", method=RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("clone/formClone");
		List<Adicionais> allAdicionais = ar.findAll();
		mv.addObject("allAdicionais", allAdicionais);
		
		return mv;
	}
	
	@RequestMapping(value="/criarClone", method=RequestMethod.POST)
	public String form(Clone clone,  Adicionais adicionais) {
		LocalDate dataAtual = LocalDate.now();
		
		clone.setDataCriacao(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataAtual));
		try {
			cr.save(clone);
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
		
		List<Adicionais> allAdicionais = ar.findAll();
		mv.addObject("allAdicionais", allAdicionais);
		
		return mv;
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String editarClonePost(@PathVariable("id") Integer id, Clone cloneEdit) {
		Clone copyClone = cr.findOne(id);
		
		cloneEdit.setDataCriacao(copyClone.getDataCriacao());
		try {
			cr.save(cloneEdit);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return "redirect:listaClones";
	}
	
	
	@RequestMapping("/apagar")
	public String apagarClone(Integer id) {
		Clone clone = cr.findOne(id);
		cr.delete(clone);
		
		return "redirect:listaClones";
	}
}
