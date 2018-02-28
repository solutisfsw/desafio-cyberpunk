package com.solutis.clonaria.replicante.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;

@Entity
public class Clone {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private int idade;
	
	@Column(updatable = false)
	private Date data_criacao;
	@ManyToMany
	private Set<ExtraEquip> extraEquipSet;


	public Clone() {
		
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Date getData_criacao() {
		return data_criacao;
	}
	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}
	
	public Set<ExtraEquip> getExtraEquipSet() {
		return extraEquipSet;
	}
	public void setExtraEquipSet(Set<ExtraEquip> extraEquipSet) {
		this.extraEquipSet = extraEquipSet;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_criacao == null) ? 0 : data_criacao.hashCode());
		result = prime * result + ((extraEquipSet == null) ? 0 : extraEquipSet.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (data_criacao == null) {
			if (other.data_criacao != null)
				return false;
		} else if (!data_criacao.equals(other.data_criacao))
			return false;
		if (extraEquipSet == null) {
			if (other.extraEquipSet != null)
				return false;
		} else if (!extraEquipSet.equals(other.extraEquipSet))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idade != other.idade)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@PrePersist
	public void iniciarData() {
		setData_criacao(new Date());
	}
	
	
	
	
}
