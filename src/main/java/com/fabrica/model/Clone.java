package com.fabrica.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
public class Clone {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(unique=true)
    private String nome;

    @NotNull
    private int idade;

    @NotNull
    private Date data;

    @ElementCollection(fetch = FetchType.EAGER)  //Essa anotação faz com que seja permitido a persistência de uma colection na coluna
    private List<String> adicionais;

    //Retorna o Id do Clone
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Retorna o nome do Clone
    public String getNome() {
        return nome;
    }

    //Seta o nome do Clone
    public void setNome(String nome) {
        this.nome = nome;
    }

    //Retorna a idade do Clone
    public int getIdade() {
        return idade;
    }

    //Seta a idade do Clone
    public void setIdade(int idade) {
        this.idade = idade;
    }

    //Retorna a data de criação do Clone
    public Date getData() {
        return data;
    }

    //Seta a data de criação do Clone
    public void setData(Date data) {
        this.data = data;
    }

    //Retorna uma lista do tipo String contendo os adicionais do Clone
    public List<String> getAdicionais() {
        return adicionais;
    }

    //Seta uma lista do tipo String contendo os adicionais do Clone
    public void setAdicionais(List<String> adicionais) {
        this.adicionais = adicionais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clone clone = (Clone) o;
        return Objects.equals(id, clone.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
