package com.haeralis.tecnology.robot.human.cyberpunk.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.haeralis.tecnology.robot.human.cyberpunk.util.CyberpunkConstants;
import com.haeralis.tecnology.robot.human.model.AbstractHumanRobot;
import com.haeralis.tecnology.robot.human.model.HumanRobotCloneable;
import com.haeralis.tecnology.robot.util.RobotConstants;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@Getter
@Setter
@Entity
public class CyberpunkHumanRobot extends AbstractHumanRobot implements HumanRobotCloneable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long parentId;
	private String name;
	private int age;
	private LocalDate creationDate;	
	private String version;
		
	@OneToMany(mappedBy="cyberpunkCode", cascade=CascadeType.ALL)
	private List<CyberpunkAttribute> additional;
	
	{
		this.additional = new ArrayList<>();
	}
			
	/**
	 * Estabelece novo clone Cyberpunk
	 * 
	 * @param name o Novo nome do clone
	 * @param age A idade do clone
	 * @param A versão a ser clonada
	 * @param extraAdditional Adicionais extras a serem atribuidos ao clone
	 * @return um novo clone de CyberpunkHumanRobot
	 * @throws CloneNotSupportedException
	 */
	public CyberpunkHumanRobot getNewClone(String name, int age, String version,  List<CyberpunkAttribute> extraAdditional) throws CloneNotSupportedException {
		
		CyberpunkHumanRobot clone = (CyberpunkHumanRobot) super.clone();
		clone.setId(null);
		//clone.setParentId(this.id);
		clone.setVersion(version);
		clone.setName(name);
		clone.setPercentEnergy(Math.random()*RobotConstants.MAXIMUM_ENERGY_PERCENT);
		clone.setPercentDamage(Math.random()*RobotConstants.MAXIMUM_ENERGY_PERCENT/2);
		if(!(age>CyberpunkConstants.MAXIMUM_CLONE_AGE||age<CyberpunkConstants.MINIMUM_CLONE_AGE)) {	
			clone.setAge(age);
		}
		else{
			throw new IllegalArgumentException(CyberpunkConstants.INVALID_AGE_ARGUMENT);
		}
		clone.setCreationDate(LocalDate.now());
		clone.addAdditional(extraAdditional);
				
		return clone;
	}

	/**
	 * @param additional O atributo extra a ser adicionado.
	 */
	public void addAdditional(List<CyberpunkAttribute> extraAdditional) {
		this.additional.addAll(extraAdditional);
	}
	
	/**
	 * @return Retorna o atributo id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id O id a ser setado.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Retorna o atributo parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId O parentId a ser setado.
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return Retorna o atributo percentEnergy
	 */
	@Override
	public Double getPercentEnergy() {
		//Override and simulate energy consumed
		return Math.random()*RobotConstants.MAXIMUM_ENERGY_PERCENT;
	}


	/**
	 * @return Retorna o atributo percentDamage
	 */
	@Override
	public Double getPercentDamage() {
		//Override and simulate damage taken
		return Math.random()*RobotConstants.MAXIMUM_DAMAGE_PERCENT/2;
	}	
}
