package org.juanfsrv.cyberpunk.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CloneEntity {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "nome",unique = true)
	private String nome;
	
	@Column(name = "idade")
	private int idade;	
	
	@Column(name = "dataCriacao")
	@Temporal(value = TemporalType.DATE)
	private Date dataCriacao;
	
	@OneToMany
	private List<AdicionalEntity> adicionais;
	
	public CloneEntity() {	
	}
	
	public CloneEntity(String nome,int idade,Date dataCriacao,List<AdicionalEntity> adicionais) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.dataCriacao = dataCriacao;
		this.adicionais = adicionais;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public List<AdicionalEntity> getAdicionais() {
		return adicionais;
	}
	public void setAdicionais(List<AdicionalEntity> adicionais) {
		this.adicionais = adicionais;
	}
}
