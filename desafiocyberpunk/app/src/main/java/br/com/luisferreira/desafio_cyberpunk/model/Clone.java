package br.com.luisferreira.desafio_cyberpunk.model;

/**
 * Created by Luis Ferreira on 24/02/2018.
 */

public class Clone {
    private String nome;
    private long idade;
    private String dataCriacao;

    public Clone() {
    }

    public Clone(String nome, long idade, String dataCriacao) {
        this.nome = nome;
        this.idade = idade;
        this.dataCriacao = dataCriacao;
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

    public void setIdade(long idade) {
        this.idade = idade;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
