package br.com.clone.representation;

import java.sql.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.clone.model.Clone;

public class CloneRepresentation extends ResourceSupport{
	
	@JsonInclude(Include.NON_NULL)
	private long identifier;
	@JsonInclude(Include.NON_NULL)
	private String nome;
	@JsonInclude(Include.NON_NULL)
	private String idade;
	@JsonInclude(Include.NON_NULL)
	private Date dataCriacao;
	@JsonInclude(Include.NON_NULL)
	private String adicionaisDescricao;
	public CloneRepresentation() {
		super();
	}
	public CloneRepresentation(Clone clone) {
		super();
		this.identifier = clone.getIdClone();
		this.nome = clone.getNome();
		this.idade = clone.getIdade();
		this.dataCriacao = clone.getDataCriacao();
		this.adicionaisDescricao =clone.getAdicionaisDescricao();
	}
	
	public static Clone build(CloneRepresentation cloneRepresentation) {
		Clone clone = new Clone();
		
			clone.setIdClone(cloneRepresentation.getIdentifier());
			clone.setNome(cloneRepresentation.getNome());
			clone.setIdade(cloneRepresentation.getIdade());
			clone.setDataCriacao(cloneRepresentation.getDataCriacao());
			clone.setAdicionaisDescricao(cloneRepresentation.getAdicionaisDescricao());
		
		return clone;
	}
	
	public long getIdentifier() {
		return identifier;
	}
	public void setIdentifier(long identifier) {
		this.identifier = identifier;
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
	public void setAdicionaisDescricao(String adicionaisDescricao) {
		this.adicionaisDescricao = adicionaisDescricao;
	}
	
	
	
	

}
