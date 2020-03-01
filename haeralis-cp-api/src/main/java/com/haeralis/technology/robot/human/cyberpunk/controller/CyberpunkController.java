package com.haeralis.tecnology.robot.human.cyberpunk.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.haeralis.tecnology.robot.human.cyberpunk.model.CyberpunkAttribute;
import com.haeralis.tecnology.robot.human.cyberpunk.model.CyberpunkHumanRobot;
import com.haeralis.tecnology.robot.human.cyberpunk.repository.CyberpunkRepository;
import com.haeralis.tecnology.robot.human.cyberpunk.util.CyberpunkConstants;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@RestController
@CrossOrigin("${external-origin}")
public class CyberpunkController {

	private static final String RESOURCE_PATH = "/cyberpunk";
	Logger log = Logger.getLogger(this.getClass()); 
	
	@Autowired
	private CyberpunkRepository cyberpunkRepository;
	
	/**
	 * Retorna lista de cyberpunks
	 * @return List<CyberpunkHumanRobot>
	 */
	@GetMapping(RESOURCE_PATH+"/list")
	public List<CyberpunkHumanRobot> listAll(){
		List<CyberpunkHumanRobot> lista = cyberpunkRepository.findByParentIdNotNullOrderByIdAscParentIdAscVersionAsc();
		return lista;
	}
	
	/**
	 * Retorna lista de modelos default
	 * @return List<CyberpunkHumanRobot>
	 */
	@GetMapping(RESOURCE_PATH+"/listModels")
	public List<CyberpunkHumanRobot> listModels(){
		return cyberpunkRepository.findByParentIdIsNull();
	}
	
	/**
	 * Efetua o clone de um cyberpunk
	 * @param cyberpunkHR a ser clonado
	 * @return clone
	 * @throws CloneNotSupportedException Exception capturada ao tentar efetuar um clone
	 */
	@PostMapping(RESOURCE_PATH+"/clone")
	public CyberpunkHumanRobot clone(@RequestBody CyberpunkHumanRobot cyberpunkHR) throws CloneNotSupportedException{
		CyberpunkHumanRobot clone = null;		 
		if(validModel(cyberpunkHR)) {
			
			try {
				clone = cyberpunkHR.getNewClone(cyberpunkHR.getName(), cyberpunkHR.getAge(), 
						generateCloneVersion(cyberpunkHR.getParentId()) ,cyberpunkHR.getAdditional());
				List<CyberpunkAttribute> additionalsList = clone.getAdditional();
				clone.setAdditional(new ArrayList<>());
				clone = add(clone);				
				//Preenche o id após inserção, e salva os atributos
				for(CyberpunkAttribute attr: additionalsList) {
					attr.setCyberpunkCode(clone.getId());
				}
				clone.getAdditional().addAll(additionalsList);
				//Salva novamente com os adicionais
				clone = add(clone);
			} catch (CloneNotSupportedException e) {
				log.error("Error while trying to make a Cyberpunk clone: "+e.getMessage());
				throw e;
			}
		}
		else {
			throw new IllegalArgumentException("Invalid clone data.");
		}
		return clone;
	}
	
	/**
	 * Efetua busca de cyberpunk
	 * @param cyberpunkHR a ser buscado
	 * @return cyberpunk encontrado
	 */
	@PostMapping(RESOURCE_PATH+"/search")
	public CyberpunkHumanRobot search(@RequestBody CyberpunkHumanRobot cyberpunkHR){
		return cyberpunkRepository.findOne(cyberpunkHR.getId());
	}
	
	/**
	 * Adiciona novo cyberpunk diferenciado
	 * @param cyberpunkHR novo cyberpunk
	 * @return objeto CyberpunkHumanRobot após persistencia
	 */	
	private CyberpunkHumanRobot add(CyberpunkHumanRobot cyberpunkHR){
		CyberpunkHumanRobot saved = cyberpunkRepository.save(cyberpunkHR);
		return saved;
	}
	
	/**
	 * Atualiza informações de um cyberpunk
	 * @param cyberpunkHR a ser atualizado
	 */
	@PostMapping(RESOURCE_PATH+"/update")
	public void update(@RequestBody CyberpunkHumanRobot cyberpunkHR){
		if(validModel(cyberpunkHR)) {
			
			try {
				cyberpunkRepository.save(cyberpunkHR);
			} catch (Exception e) {
				log.error("Error while trying to update a Cyberpunk clone: "+e.getMessage());
				throw e;
			}
		}
		else {
			throw new IllegalArgumentException("Invalid clone data.");
		}
			
	}
	
	/**
	 * Deleta um cyberpunk do sistema
	 * @param cyberpunkHR a ser excluído
	 */
	@PostMapping(RESOURCE_PATH+"/delete")
	public void delete(@RequestBody CyberpunkHumanRobot cyberpunkHR){
		cyberpunkRepository.delete(cyberpunkHR.getId());
	}
	
	/**
	 * Gera uma nova versão de para o clone
	 * @param parentId id do modelo principal
	 * @return versão definida para o novo modelo
	 */
	private String generateCloneVersion(Long parentId){		
		CyberpunkHumanRobot parent = cyberpunkRepository.findOne(parentId);
		CyberpunkHumanRobot lastClone = cyberpunkRepository.findTopByParentIdOrderByVersionDesc(parentId);
		
		StringBuilder newVersion = new StringBuilder(parent.getVersion());
		boolean hasMember = false;
		if(lastClone!=null) {
			hasMember = true;
			newVersion = new StringBuilder(lastClone.getVersion());
		}
		
		if(!hasMember){
			newVersion = newVersion.append(CyberpunkConstants.NEW_VERSION_STR);
		}
		else{
			String digit = newVersion.substring(newVersion.lastIndexOf(CyberpunkConstants.DOT_STR)+1,newVersion.length()).toString();
			newVersion = newVersion.delete(newVersion.lastIndexOf(CyberpunkConstants.DOT_STR)+1,newVersion.length());
			int newDigit = Integer.parseInt(digit) + 1;
			newVersion.append(newDigit);
		}
				
		return newVersion.toString();		
	}
	
	/**
	 * Validate if model is able to clone
	 * @param cyberpunkHR the model to clone
	 * @return validation result
	 */
	private boolean validModel(CyberpunkHumanRobot cyberpunkHR){ //&& cyberpunkHR.getName().matches("[A-Z]{3}[0-9]{4}")
		if((cyberpunkHR.getName()==null ) ||
				(cyberpunkHR.getAge()<CyberpunkConstants.MINIMUM_CLONE_AGE || cyberpunkHR.getAge()>CyberpunkConstants.MAXIMUM_CLONE_AGE)){
			return false;
		}else {
			List<CyberpunkHumanRobot> search = null;
			if(cyberpunkHR.getId()!=null) {
				search = cyberpunkRepository.findByNameAndIdNot(cyberpunkHR.getName(), cyberpunkHR.getId());
			}
			else {
				search = cyberpunkRepository.findByName(cyberpunkHR.getName());
			}
			if(search!=null && search.size()>0) {
				throw new IllegalArgumentException("This clone name is already in use, choose another better");
			}
		}
		return true;
	}	
}
