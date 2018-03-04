package br.com.tonycosta.desafio.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="clones")
@NoArgsConstructor
@EqualsAndHashCode(of="nome")
public class Clone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	private Long id;
	@NotBlank
	@Pattern(regexp="[A-Z]{3}[0-9]{4}")
	@Getter @Setter
	private String nome;
	@NotNull
	@Min(10) @Max(20)
	@Getter @Setter
	private Integer idade;
	@DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd HH:mm")
	@Column(name="data_criacao")
	@Getter @Setter
	private LocalDateTime dataDeCriacao;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "clones_adicionais", joinColumns = @JoinColumn(name = "clone_id"))
	@Enumerated(EnumType.STRING)
	@Column(name = "adicional")
	@Getter @Setter
	private Set<Adicional> adicionais = new HashSet<>();
	
	public Clone(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	@PrePersist
	private void prePersist() {
		this.dataDeCriacao = LocalDateTime.now();
	}

}
