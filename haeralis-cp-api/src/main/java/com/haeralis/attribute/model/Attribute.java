package com.haeralis.attribute.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@Data
@Entity
public class Attribute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String name;
	
	@OneToOne
	@JoinColumn(name="type_code") 
	private AttributeType attributeType;
	
}
