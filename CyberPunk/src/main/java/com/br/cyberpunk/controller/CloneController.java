package com.br.cyberpunk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.br.cyberpunk.model.Clone;
import com.br.cyberpunk.model.EquipAdicionais;
import com.br.cyberpunk.repositories.CloneRepository;
import com.br.cyberpunk.repositories.EquipRepository;

@Controller
public class CloneController {
	
	@Autowired
	private CloneRepository cloneRepository;
	
	@Autowired
	private EquipRepository equip;
	
	@RequestMapping (value="/cadastrarClones", method=RequestMethod.GET)
	public String form() {
		
	return "clone/formClone";
	}
	
	@RequestMapping (value="/cadastrarClones", method=RequestMethod.POST)
	public String form(Clone clone, String nome)  {

		  cloneRepository.save(clone);
	      return "redirect:/cadastrarClones";

	}
	
	@RequestMapping ("/listaClones")
	public ModelAndView listaClones() {
		ModelAndView mv= new ModelAndView("index");
		Iterable<Clone> clones= cloneRepository.findAll();
		mv.addObject("clones", clones);
		
		//Lista de Adicionais
		List<EquipAdicionais> equipes= equip.findAll();
		mv.addObject("equipes", equipes);
		
		return mv;
	}

	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView editarClone(@PathVariable ("id") Long id) {
		ModelAndView mv= new ModelAndView("clone/editarClone");
			Clone clone=cloneRepository.findOne(id);
			mv.addObject("clone", clone);
			
			
			//Lista de Adicionais
			List<EquipAdicionais> equipes= equip.findAll();
			mv.addObject("equipes", equipes);
			return mv;
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String editarClonesPost(@PathVariable ("id") Long id, Clone cloneEditado) {
		Clone clone=cloneRepository.findById(id);
			cloneEditado.setData(clone.getData());
			cloneRepository.save(cloneEditado);

			return "redirect:/listaClones";
	}
	
	@RequestMapping ("/deletarClones")
	public String deletarClones(Long id) {
		Clone clone= cloneRepository.findById(id);
		cloneRepository.delete(clone);
		return"redirect:/listaClones";
	}
}
