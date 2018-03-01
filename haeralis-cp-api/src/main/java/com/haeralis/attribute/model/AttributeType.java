package com.haeralis.attribute.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@Entity
public class AttributeType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	private String name;
	/**
	 * @return Retorna o atributo code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code O code a ser setado.
	 */
	public void setCode(int code) {
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
}
