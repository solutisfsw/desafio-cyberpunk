package br.com.solutis.desafio.desafiosolutis.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="adicionais")
public class Adicionais implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String parteAdicional;
	
	@ManyToMany(mappedBy="adicionais", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Clone> clone;
	
	public Adicionais() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParteAdicional() {
		return parteAdicional;
	}

	public void setParteAdicional(String parteAdicional) {
		this.parteAdicional = parteAdicional;
	}

	public List<Clone> getClone() {
		return clone;
	}

	public void setClone(List<Clone> clone) {
		this.clone = clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Adicionais other = (Adicionais) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	

	
	
}
