package com.br.cyberpunk.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class EquipAdicionais {
	
	@Id
	private Long   id;
	private String bracoMecanico;
	private	String esqueletoForcado;
	private String sentidosAgucados;
	private	String peleAdaptavia;
	private String raioLaser;
	
	@ManyToMany(mappedBy="equip", fetch=FetchType.LAZY)
	private List<Clone> clone;
	
	public 	String getBracoMecanico() {
		return bracoMecanico;
	}
	public void setBracoMecanico(String bracoMecanico) {
		this.bracoMecanico = bracoMecanico;
	}
	public String getEsqueletoForcado() {
		return esqueletoForcado;
	}
	public void setEsqueletoForcado(String esqueletoForcado) {
		this.esqueletoForcado = esqueletoForcado;
	}
	public String getSentidosAgucados() {
		return sentidosAgucados;
	}
	public void setSentidosAgucados(String sentidosAgucados) {
		this.sentidosAgucados = sentidosAgucados;
	}
	public String getPeleAdaptavia() {
		return peleAdaptavia;
	}
	public void setPeleAdaptavia(String peleAdaptavia) {
		this.peleAdaptavia = peleAdaptavia;
	}
	public String getRaioLaser() {
		return raioLaser;
	}
	public void setRaioLaser(String raioLaser) {
		this.raioLaser = raioLaser;
	}
	public List<Clone> getClone() {
		return clone;
	}
	public void setClone(List<Clone> clone) {
		this.clone = clone;
	}


	
}
