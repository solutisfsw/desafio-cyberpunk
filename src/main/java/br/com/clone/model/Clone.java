package br.com.clone.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"nome"})})
public class Clone implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClone;
	
	
	@Column(unique=true, nullable=false)
	private String nome;
	private String idade;
	private Date dataCriacao;
	private String adicionaisDescricao;
	public Clone() {
		super();
	}
	public Clone(Long idClone, String nome, String idade, Date dataCriacao, String adicionaisDescricao) {
		super();
		this.idClone = idClone;
		this.nome = nome;
		this.idade = idade;
		this.dataCriacao = dataCriacao;
		this.adicionaisDescricao = adicionaisDescricao;
	}
	public Long getIdClone() {
		return idClone;
	}
	public void setIdClone(Long idClone) {
		this.idClone = idClone;
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getAdicionaisDescricao() {
		return adicionaisDescricao;
	}
	public void setAdicionaisDescricao(String string) {
		this.adicionaisDescricao = string;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idClone ^ (idClone >>> 32));
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
		if (idClone != other.idClone)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Clone [idClone=" + idClone + ", nome=" + nome + ", idade=" + idade + ", dataCriacao=" + dataCriacao
				+ ", adicionaisDescricao=" + adicionaisDescricao + "]";
	}
	
	
	

}
