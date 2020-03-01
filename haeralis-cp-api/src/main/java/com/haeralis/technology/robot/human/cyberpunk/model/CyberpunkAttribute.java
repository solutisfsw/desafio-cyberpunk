package com.haeralis.technology.robot.human.cyberpunk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.haeralis.attribute.model.Attribute;

import lombok.Data;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@Data
@Entity
public class CyberpunkAttribute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private Long cyberpunkCode;
	@OneToOne
	@JoinColumn(name="attribute_code")
	private Attribute attribute;	
}
