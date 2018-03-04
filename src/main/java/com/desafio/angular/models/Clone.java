package com.desafio.angular.models;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clones")
public class Clone {
    @Id
    String id;
    String name;
    String idade;
    LocalDate data_criacao;

    public Clone() {
    }

    public Clone(String name, String idade) {
        this.name = name;
        this.idade = idade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public LocalDate getData_criacao() {
      		return data_criacao;
    }

    public void setData_criacao(LocalDate data_criacao) {
      		this.data_criacao = data_criacao;
    }

}
