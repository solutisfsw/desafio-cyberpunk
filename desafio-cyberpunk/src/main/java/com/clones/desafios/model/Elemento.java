package com.clones.desafios.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Elemento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_elemento;

	private String descricao;
	

	public Long getId_elemento() {
		return id_elemento;
	}

	public void setId_elemento(Long id_elemento) {
		this.id_elemento = id_elemento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_elemento == null) ? 0 : id_elemento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Elemento other = (Elemento) obj;
		if (id_elemento == null) {
			if (other.id_elemento != null)
				return false;
		} else if (!id_elemento.equals(other.id_elemento))
			return false;
		return true;
	}

}