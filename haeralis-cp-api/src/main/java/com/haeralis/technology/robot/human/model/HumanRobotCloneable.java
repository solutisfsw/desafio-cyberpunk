package com.haeralis.technology.robot.human.model;

/**
 * Interface to be implemented by classes that can be cloned
 * @author Haeralis (GledsonMotta)
 *
 */
public interface HumanRobotCloneable extends Cloneable{
	
	public abstract Long getParentId();
	public abstract String getVersion();	
}
