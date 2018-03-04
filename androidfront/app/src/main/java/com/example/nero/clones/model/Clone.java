package com.example.nero.clones.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Nero on 25/02/2018.
 */

public class Clone implements Serializable{

    private Long id;
    private String nome;
    private Integer idade;
    private String dataCriacao;
    private List<String> adicionais;

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

    public String getDataCriacao() {
        return dataCriacao;
    }

    public List<String> getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(List<String> adicionais) {
        this.adicionais = adicionais;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
