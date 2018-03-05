package org.juanfsrv.cyberpunk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.juanfsrv.cyberpunk.enums.AdicionaisEnum;

@Entity
public class AdicionalEntity {
	
	@Id
	private int id;	
	@Column(name = "adicional")
	private AdicionaisEnum adicional;
	
	public AdicionalEntity() {		
	}
	
	public AdicionalEntity(AdicionaisEnum adicional) {
		super();
		this.adicional = adicional;
	}
	
	public int getId_clone() {
		return id;
	}
	public void setId_clone(int id) {
		this.id = id;
	}
	public AdicionaisEnum getAdicional() {
		return adicional;
	}
	public void setAdicional(AdicionaisEnum adicional) {
		this.adicional = adicional;
	}
}
