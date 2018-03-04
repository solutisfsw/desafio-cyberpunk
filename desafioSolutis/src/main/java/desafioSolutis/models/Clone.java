package desafioSolutis.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="clone")
public class Clone {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome",unique=true)
	@Pattern(message="O nome deve iniciar com 3 letras maiusculas e finalizar com 4 números" , regexp="^[A-Z]{3}[0-9]{4}$")	
	private String nome;
	
	
	@Min(value = 10, message="Idade precisa ser maior que 10")
	@Max(value = 20, message="Idade precisa ser menor que 20")
	private int idade;
	
	private Date dataCriacao;
	
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="clone", optional = true)
    private Adicional adicional;
	
	@JsonIgnore
	public Adicional getAdicional() {
		return adicional;
	}
	public void setAdicional(Adicional adicional) {
		this.adicional = adicional;
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
		
}
