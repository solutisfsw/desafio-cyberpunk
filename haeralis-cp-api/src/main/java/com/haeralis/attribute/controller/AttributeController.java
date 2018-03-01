package com.haeralis.attribute.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.cfg.beanvalidation.IntegrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.haeralis.attribute.model.Attribute;
import com.haeralis.attribute.model.AttributeType;
import com.haeralis.attribute.repository.AttributeRepository;
import com.haeralis.attribute.repository.AttributeTypeRepository;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@RestController
@CrossOrigin("${external-origin}")
public class AttributeController {

	private static final String RESOURCE_PATH = "/attribute";
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private AttributeRepository attributeRepository;
	@Autowired
	private AttributeTypeRepository attributeTypeRepository;
	
	/**
	 * Retorna lista de atributos
	 * @return List<Attribute>
	 */
	@GetMapping(RESOURCE_PATH+"/list")
	public List<Attribute> listAll(){			
		return attributeRepository.findAll();
	}
	
	/**
	 * Retorna lista de tipos de atributos
	 * @return List<Attribute>
	 */
	@GetMapping(RESOURCE_PATH+"/listType")
	public List<AttributeType> listAllType(){		
		return attributeTypeRepository.findAll();
	}
	
	/**
	 * Busca um atributo
	 * @param attribute a ser buscado
	 * @return atributo encontrado
	 */
	@PostMapping(RESOURCE_PATH+"/search")
	public Attribute search(@RequestBody Attribute attribute){
		return attributeRepository.findOne(attribute.getCode());
	}
	
	/**
	 * Adiciona novo atributo
	 * @param attribute a ser adicionado
	 */
	@PostMapping(RESOURCE_PATH+"/add")
	public void add(@RequestBody Attribute attribute){
		
		List<Attribute>	search = attributeRepository.findByName(attribute.getName());
		
		if(search!=null && search.size()>0) {
			throw new IllegalArgumentException("This attribute name is already in use");
		}
		attributeRepository.save(attribute);		
	}
	
	/**
	 * Atualiza atributo
	 * @param attribute a ser atualizado
	 */
	@PostMapping(RESOURCE_PATH+"/update")
	public void update(@RequestBody Attribute attribute){
		attributeRepository.save(attribute);	
	}
	
	/**
	 * Deleta um atributo
	 * @param attribute a ser excluído
	 * @throws Exception 
	 */
	@PostMapping(RESOURCE_PATH+"/delete")
	public void delete(@RequestBody Attribute attribute) throws Exception{
		try {
			attributeRepository.delete(attribute.getCode());	
		}
		catch(Exception ce) {
			log.error("Error while deleting attribute: "+ce.getMessage());
			throw new IntegrationException("This attribute cannot be deleted, because it's on use!");			
		}
	}
}
