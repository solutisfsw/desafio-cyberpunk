package com.ezequias.solutis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "clone")
public class Clone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome é obrigatório")
    @Size(min = 7,max = 7, message = "O nome dever ter 7 caracteres")
    @Column(unique = true)
    @Pattern(regexp = "[A-Z]{3}[0-9]{4}",
            message = "O nome deve conter 7 caracteres sendo que deve ter 3 letras de [A-Z] e 4 numeros de [0-9]. Ex.: ABC1234")
    private String nome;

    @NotNull(message = "A idade é obrigatória")
    @Min(value = 10, message = "A idade deve ser maior ou igual a 10 e menor ou igual a 20 anos")
    @Max(value = 20, message = "A idade deve ser menor ou igual a 20 e maior ou igual a 10 anos")
    private Integer idade;

    @NotNull(message = "A data é obrigatória e deve seguir o formato yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;

    @OneToOne(cascade = CascadeType.ALL)
    private Adicionais adicionais = new Adicionais();

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

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Adicionais getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(Adicionais adicionais) {
        this.adicionais = adicionais;
    }
}
