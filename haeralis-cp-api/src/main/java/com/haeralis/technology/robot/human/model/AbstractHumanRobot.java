package com.haeralis.technology.robot.human.model;

import javax.persistence.Inheritance;

import com.haeralis.technology.robot.model.AbstractRobot;
import com.haeralis.technology.robot.util.RobotConstants;

/**
 * Abstract class for HumanRobot
 * @author Haeralis (GledsonMotta)
 *
 */
@Inheritance
public abstract class AbstractHumanRobot extends AbstractRobot{

	public static final Long MAXIMUM_HUMAN_ENERGY = 8000L;
	public static final Long MAXIMUM_HUMAN_DAMAGE = 8000L;
	
	public AbstractHumanRobot() {
		this.setTotalEnergy(MAXIMUM_HUMAN_ENERGY);
		this.setTotalDamage(MAXIMUM_HUMAN_DAMAGE);
		//this.setPercentEnergy(RobotConstants.MAXIMUM_ENERGY_PERCENT);
		//this.setPercentDamage(RobotConstants.MINIMUM_DAMAGE_PERCENT);
	}

	
	@Override
	public void takeDamage(Long damage) {
		this.setTotalDamage(this.getTotalDamage()-damage);
		recalculateDamagePercent();
	}

	@Override
	public void takeEnergy(Long energy) {
		this.setTotalEnergy(this.getTotalEnergy()-energy);	
		recalculateEnergyPercent();
	}
	
	/**
	 * Método para recalcular percentual de dano
	 */
	private void recalculateDamagePercent() {
		Double damagePercent = RobotConstants.MAXIMUM_DAMAGE_PERCENT 
				- (double) ((MAXIMUM_HUMAN_DAMAGE-this.getTotalDamage())/MAXIMUM_HUMAN_DAMAGE*100);		
		this.setPercentDamage(damagePercent);
	}
	
	/**
	 * Método para recalcular percentual de dano
	 */
	private void recalculateEnergyPercent() {
		Double energyPercent = RobotConstants.MAXIMUM_ENERGY_PERCENT 
				- (double) ((MAXIMUM_HUMAN_ENERGY-this.getTotalDamage())/MAXIMUM_HUMAN_ENERGY*100);		
		this.setPercentDamage(energyPercent);
	}
}
