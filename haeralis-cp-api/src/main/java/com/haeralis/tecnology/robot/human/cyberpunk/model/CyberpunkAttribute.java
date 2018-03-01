package com.haeralis.tecnology.robot.human.cyberpunk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.haeralis.attribute.model.Attribute;

/**
 * 
 * @author Haeralis (GledsonMotta)
 *
 */
@Entity
public class CyberpunkAttribute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private Long cyberpunkCode;
	@OneToOne
	@JoinColumn(name="attribute_code")
	private Attribute attribute;
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
	 * @return Retorna o atributo attribute
	 */
	public Attribute getAttribute() {
		return attribute;
	}
	/**
	 * @param attribute O attribute a ser setado.
	 */
	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
	/**
	 * @return Retorna o atributo cyberpunkCode
	 */
	public Long getCyberpunkCode() {
		return cyberpunkCode;
	}
	/**
	 * @param cyberpunkCode O cyberpunkCode a ser setado.
	 */
	public void setCyberpunkCode(Long cyberpunkCode) {
		this.cyberpunkCode = cyberpunkCode;
	}
}
