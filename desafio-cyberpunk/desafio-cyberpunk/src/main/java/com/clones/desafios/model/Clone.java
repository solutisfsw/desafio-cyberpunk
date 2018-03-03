package com.clones.desafios.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Clone implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_clone;
	
	@Column(unique=true)
	private String nome;
	
	private Integer idade;
	
	private LocalDate data_criacao;

	@ManyToMany(fetch=FetchType.LAZY)
	 @JoinTable(name = "clone_elementos",
     joinColumns = { @JoinColumn(name = "id_clone") },
     inverseJoinColumns = { @JoinColumn(name = "id_elemento") })
	private List<Elemento> elementos = new ArrayList<>();	
	
	public List<Elemento> getElementos() {
		return elementos;
	}

	public void setElementos(List<Elemento> elementos) {
		this.elementos = elementos;
	}

	
	public void addElemento(Elemento elemento) {
		this.elementos.add(elemento);
	}
	
	
	public void removeElemento(Elemento elemento) {
		System.out.println(elemento.getDescricao());
		this.elementos.remove(elemento);
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

	

	public Long getId_clone() {
		return id_clone;
	}

	public void setId_clone(Long id_clone) {
		this.id_clone = id_clone;
	}

	public LocalDate getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(LocalDate data_criacao) {
		this.data_criacao = data_criacao;
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