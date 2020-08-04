package com.haeralis.technology.robot.model;

import javax.persistence.Inheritance;

import com.haeralis.technology.robot.util.RobotConstants;

import lombok.Data;

/**
 * Abstract class for Robot
 * @author Haeralis (GledsonMotta)
 *
 */
@Data
@Inheritance
public abstract class AbstractRobot {

	//Energia total em Watts
	private Long totalEnergy;
	//Representa a capacidade total em receber dano
	private Long totalDamage;
	private Double percentEnergy;
	private Double percentDamage;
	
		
	/**
	 * Método abstrato para definição de recebimento de dano
	 * @param damage o dano absorvido
	 */
	public abstract void takeDamage(Long damage);
	
	/**
	 * Método abstrato para definição de consumo de energia
	 * @param energy a energia consumida
	 */
	public abstract void takeEnergy(Long energy);
		
	/**
	 * @param percentEnergy O percentEnergy a ser setado.
	 */	
	public void setPercentEnergy(Double percentEnergy) {
		if(!(percentEnergy>RobotConstants.MAXIMUM_ENERGY_PERCENT||percentEnergy<RobotConstants.MINIMUM_ENERGY_PERCENT)) {
			this.percentEnergy = percentEnergy;
		}
		else{
			throw new IllegalArgumentException(RobotConstants.INVALID_ENERGY_ARGUMENT);
		}
	}
	
	/**
	 * @param percentDamage O percentDamage a ser setado.
	 */
	public void setPercentDamage(Double percentDamage) {
		if(!(percentDamage>RobotConstants.MAXIMUM_DAMAGE_PERCENT||percentDamage<RobotConstants.MINIMUM_DAMAGE_PERCENT)) {
			this.percentDamage = percentDamage;
		}
		else{
			throw new IllegalArgumentException(RobotConstants.INVALID_DAMAGE_ARGUMENT);
		}
	}	
}
