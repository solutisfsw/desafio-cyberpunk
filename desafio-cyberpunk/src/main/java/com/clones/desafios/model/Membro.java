package com.clones.desafios.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Membro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_membro;
	
	private String descricao;
	
	@OneToMany(mappedBy="membro", fetch = FetchType.LAZY)
	private List<ClonesMembros> clonesMembros;

	public Long getId_membro() {
		return id_membro;
	}

	public void setId_membro(Long id_membro) {
		this.id_membro = id_membro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ClonesMembros> getClonesMembros() {
		return clonesMembros;
	}

	public void setClonesMembros(List<ClonesMembros> clonesMembros) {
		this.clonesMembros = clonesMembros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_membro == null) ? 0 : id_membro.hashCode());
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
		Membro other = (Membro) obj;
		if (id_membro == null) {
			if (other.id_membro != null)
				return false;
		} else if (!id_membro.equals(other.id_membro))
			return false;
		return true;
	}
	
	 
	
	
}
