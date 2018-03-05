package com.mateusmatos.cyberpunk.models;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "clone")
public class Clone {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	@NotNull
	private String nome;
	@NotNull
	@Column
	private int idade;
	@Column
	@NotNull
	private Date data_cadastro;
	@Column
	private boolean braco_mecanico;
	@Column
	private boolean esqueleto_reforcado;
	@Column
	private boolean sentidos_agucados;
	@Column
	private boolean pele_adaptativa;
	@Column
	private boolean raio_laser;
		
	public String getNome() {
		return nome;
	}
	public int getIdade() {
		return idade;
	}
	public Date getData_cadastro() {
		return data_cadastro;
	}
	public boolean isBraco_mecanico() {
		return braco_mecanico;
	}
	public boolean isEsqueleto_reforcado() {
		return esqueleto_reforcado;
	}
	public boolean isSentidos_agucados() {
		return sentidos_agucados;
	}
	public boolean isPele_adaptativa() {
		return pele_adaptativa;
	}
	public boolean isRaio_laser() {
		return raio_laser;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	public void setBraco_mecanico(boolean braco_mecanico) {
		this.braco_mecanico = braco_mecanico;
	}
	public void setEsqueleto_reforcado(boolean esqueleto_reforcado) {
		this.esqueleto_reforcado = esqueleto_reforcado;
	}
	public void setSentidos_agucados(boolean sentidos_agucados) {
		this.sentidos_agucados = sentidos_agucados;
	}
	public void setPele_adaptativa(boolean pele_adaptativa) {
		this.pele_adaptativa = pele_adaptativa;
	}
	public void setRaio_laser(boolean raio_laser) {
		this.raio_laser = raio_laser;
	}
	
	
 
}
