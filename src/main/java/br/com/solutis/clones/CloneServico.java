package br.com.solutis.clones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CloneServico {
    
    private List<Clone> clones = new ArrayList<>();
    
    private static CloneServico instance = new CloneServico();
    
    private CloneServico() {}
    
    public static CloneServico getInstance() {
        return CloneServico.instance;
    }
    
    public List<Clone> getClones() {
        return this.clones;
    }
    
    /**
     * Este metodo eh responsavel por criar os clones validando os requisitos: 1- nome unico no sistema 2- se nome segue
     * padrao definido 3- se idade eh entre 10 ne 20
     * 
     * @param nome
     * @param idade
     * @throws IllegalArgumentException - excecao lan�ada se os dados n�o atenderem os padraos
     */
    public void criarClone(String nome, int idade) {
        ValidadorClone.validarDados(nome, idade);
        
        validarNomeUnico(nome);
        
        Clone clone = new Clone(nome, idade, new Date());
        
        this.clones.add(clone);
    }
    
    public void removerClone(String nome) {
        Clone clone = new Clone();
        clone.setNome(nome);
        this.clones.remove(clone);
    }
    
    public void atualizarClone(String nome, int idade) {
        
        // descobrir o index do clone com o id passado por parametro
        Clone clone = new Clone();
        clone.setNome(nome);
        int index = this.clones.indexOf(clone);
        
        if (index == -1) {
            throw new IllegalArgumentException("N�o existe nenhum clone com nome = " + nome);
        }
        
        ValidadorClone.validarIdade(idade);
        
        // recuperar o objeto clone da lista com o indice descoberto
        Clone cloneUpdate = this.clones.get(index);
        
        // atualizar o objeto com os dados passados
        cloneUpdate.setIdade(idade);
        
    }
    
    private void validarNomeUnico(String nome) {
        Clone clone = new Clone();
        clone.setNome(nome);
        int index = this.clones.indexOf(clone);
        
        if (index != -1) {
            throw new IllegalArgumentException("O nome [" + nome + "] j� est[a cadastrado no sistema");
        }
    }
    
    public void limparClones() {
        this.clones = new ArrayList<>();
    }
    
}