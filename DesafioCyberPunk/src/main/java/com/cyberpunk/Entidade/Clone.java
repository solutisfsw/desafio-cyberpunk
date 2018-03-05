package com.cyberpunk.Entidade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Clone {

	@Id
	@GeneratedValue
	private Long ID;
	private String Nome;
	private int Idade;
	private Date DataCadastro;
	private String[] Adcionais;

	@Override
	public String toString() {
		return "Clone [ID=" + ID + ", Nome=" + Nome + ", Idade=" + Idade
				+ ", DataCadastro=" + DataCadastro + ", Adcionais=" + Adcionais
				+ "]";
	}

	public Clone() {
	}

	public Clone(String nome, int idade, Date dataCadastro,
			String[] adcionais) {
		Nome = nome;
		Idade = idade;
		DataCadastro = dataCadastro;
		Adcionais = adcionais;
	}

	public Long getID() {
		return ID;
	}

	public String getNome() {
		return Nome;
	}

	public int getIdade() {
		return Idade;
	}

	public Date getDataCadastro() {
		return DataCadastro;
	}

	public String[] getAdcionais() {
		return Adcionais;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public void setIdade(int idade) {
		Idade = idade;
	}

	public void setDataCadastro(Date dataCadastro) {
		DataCadastro = dataCadastro;
	}

	public void setAdcionais(String[] adcionais) {
		Adcionais = adcionais;
	}

}
