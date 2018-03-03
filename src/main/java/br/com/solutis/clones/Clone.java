package br.com.solutis.clones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Clone implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -6657819322374450782L;
    
    @SerializedName("nome")
    private String nome;
    
    @SerializedName("idade")
    private int idade;
    
    @SerializedName("data")
    private Date dataDeCriacao;
    
    @SerializedName("adicionais")
    private final List<String> elementosAdicionais = new ArrayList<String>();
    
    public Clone() {}
    
    public Clone(String nome, int idade, Date dataDeCriacao) {
        super();
        this.nome = nome;
        this.idade = idade;
        this.dataDeCriacao = dataDeCriacao;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdade() {
        return this.idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public Date getDataDeCriacao() {
        return this.dataDeCriacao;
    }
    
    public void setDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }
    
    public void adicionarElemento(String elemento) {
        this.elementosAdicionais.add(elemento);
    }
    
    public void removerElementos(String elemento) {
        this.elementosAdicionais.remove(elemento);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.nome == null) ? 0 : this.nome.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Clone other = (Clone) obj;
        if (this.nome == null) {
            if (other.nome != null) {
                return false;
            }
        } else if (!this.nome.equals(other.nome)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Clone [nome=" + this.nome + ", idade=" + this.idade + ", dataDeCriacao=" + this.dataDeCriacao + "]";
    }
    
    public static void main(String[] args) {
        
        Clone clone = new Clone("Bob 2", 15, new Date());
        
        Clone clone2 = new Clone("Bob 3", 15, new Date());
        
        List<Clone> lista = new ArrayList<>();
        
        lista.add(clone);
        lista.add(clone2);
        
        System.out.println(lista);
        
        Clone clone3 = new Clone();
        clone3.setNome("Bob 3");
        
        int indexOf = lista.indexOf(clone3);
        
        System.out.println(indexOf);
        
        Clone clone4 = lista.get(indexOf);
        clone4.setNome("Bob 333");
        
        System.out.println(lista);
    }
}