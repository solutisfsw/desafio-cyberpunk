package com.clones.desafios.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Clone implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_clone;
	
	private String nome;
	
	private Integer idade;
	
	private LocalDate data_criacao;
	
	@OneToMany(mappedBy="clone", fetch = FetchType.LAZY)
	private List<ClonesMembros> clonesMembros;

	public Long getId_clone() {
		return id_clone;
	}

	public void setId_clone(Long id_clone) {
		this.id_clone = id_clone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public LocalDate getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(LocalDate data_criacao) {
		this.data_criacao = data_criacao;
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
		result = prime * result + ((id_clone == null) ? 0 : id_clone.hashCode());
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
		Clone other = (Clone) obj;
		if (id_clone == null) {
			if (other.id_clone != null)
				return false;
		} else if (!id_clone.equals(other.id_clone))
			return false;
		return true;
	}
	
	
	
	
}
