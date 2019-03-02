package br.com.luisferreira.desafiocyberpunk.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Luis Ferreira on 04/03/2018.
 */

public class Clone {

    private String id;
    private String nome;
    private int idade;
    private String dataCriacao;
    private List<String> adicionais;

    public Clone() {
    }

    public Clone(String id, String nome, int idade, String dataCriacao, List<String> adicionais) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.dataCriacao = dataCriacao;
        this.adicionais = adicionais;
    }

    public Clone(String nome, int idade, String dataCriacao, List<String> adicionais) {
        this.nome = nome;
        this.idade = idade;
        this.dataCriacao = dataCriacao;
        this.adicionais = adicionais;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setAdicionais(List<String> adicionais) {
        this.adicionais = adicionais;
    }

    public List<String> getAdicionais() {
        return adicionais;
    }

    public Map<String, Object> toMap() {

        HashMap<String, Object> result = new HashMap<>();
        result.put("nome", this.nome);
        result.put("idade", this.idade);
        result.put("dataCriacao", this.dataCriacao);
        result.put("adicionais", this.adicionais);

        return result;
    }
}
