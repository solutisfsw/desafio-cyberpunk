package com.haeralis.attribute.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@Entity
public class Attribute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String name;
	
	@OneToOne
	@JoinColumn(name="type_code") 
	private AttributeType attributeType;
	/**
	 * @return Retorna o atributo code
	 */
	public Long getCode() {
		return code;
	}
	/**
	 * @param code O code a ser setado.
	 */
	public void setCode(Long code) {
		this.code = code;
	}
	/**
	 * @return Retorna o atributo name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name O name a ser setado.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Retorna o atributo attributeType
	 */
	public AttributeType getAttributeType() {
		return attributeType;
	}
	/**
	 * @param attributeType O attributeType a ser setado.
	 */
	public void setAttributeType(AttributeType attributeType) {
		this.attributeType = attributeType;
	}	
}
