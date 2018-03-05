package br.com.solutis.cyberpunk.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "clone")
public class Clone implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private int idade;
	private Date dataCriacao;
	private List<Adicional> adicionais = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotBlank
	@Size(max = 80)
	@Column(nullable = false, length = 80)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotNull
	@Column(name = "idade", length = 3)
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao", nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@Transient
	public boolean isNovo() {
		return getId() == null;
	}
	
	@ElementCollection(fetch = FetchType.LAZY, targetClass = Adicional.class)   
	@Enumerated(EnumType.STRING)   
	@Column(name = "nome", length = 30)   
	@JoinTable(name = "clone_adicionais")
	public List<Adicional> getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(List<Adicional> adicionais) {
		this.adicionais = adicionais;
	}
	
	@Transient
	public String getAdicionaisConcatenado() {
		String adicionaisConcatenado = "";
		List<Adicional> adicional = getAdicionais();
		
		if(adicional != null) 
		{
			for(int x = 0; x < adicional.size(); x++) 
			{
				adicionaisConcatenado += adicional.get(x).getNome();
				if(x < adicional.size() - 1)
				{
					adicionaisConcatenado += " | ";
				}
			}
		}
			
		return adicionaisConcatenado;
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
		Clone other = (Clone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}