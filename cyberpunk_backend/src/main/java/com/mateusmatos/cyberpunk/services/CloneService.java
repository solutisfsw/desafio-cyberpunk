package com.mateusmatos.cyberpunk.services;

import java.util.Date;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateusmatos.cyberpunk.models.Clone;
import com.mateusmatos.cyberpunk.models.CloneDAO;

@Service
public class CloneService {
	
	private static final String NOME_REGEX = "^[A-Z]{3}[0-9]{4}$";
    private static final String IDADE_REGEX = "^20|1[0-9]$";
    
    private boolean verifica_validade(String nome, String idade) {
    	return (Pattern.matches(NOME_REGEX, nome) && Pattern.matches(IDADE_REGEX, idade));
    }
	
	public boolean adicionarClones(Clone data) {
		if(cloneDAO.findByNome(data.getNome()) != null) return false;
		if(verifica_validade(data.getNome(), String.valueOf(data.getIdade()))) {
			data.setData_cadastro(new Date());
		    cloneDAO.save(data);
		    
		    return true;
		} else {
			return false;
		}
	}
	
	public boolean atualizarClones(Clone data, long id) {
		 Clone clone = cloneDAO.findOne(id);
		if (clone == null) return false;	
		if(!clone.getNome().equals(data.getNome()) && cloneDAO.findByNome(data.getNome()) != null) return false;
		if(verifica_validade(data.getNome(), String.valueOf(data.getIdade()))) {
			 clone.setNome(data.getNome());
			 clone.setIdade(data.getIdade());
			 clone.setBraco_mecanico(data.isBraco_mecanico());
			 clone.setEsqueleto_reforcado(data.isEsqueleto_reforcado());
			 clone.setPele_adaptativa(data.isPele_adaptativa());
			 clone.setSentidos_agucados(data.isSentidos_agucados());
			 clone.setRaio_laser(data.isRaio_laser());
		     cloneDAO.save(clone);
		     return true;
  		} else {
  			return false;
  		}
	}
	
	
	public Iterable<Clone> listarClones() {
		 return cloneDAO.findAll();
	}
	
	public Clone buscarClones(long id) {
	  return cloneDAO.findOne(id);
	}
	
	public void removeClones(long id) {
	  cloneDAO.delete(id);
	}
	

	 @Autowired
	 private CloneDAO cloneDAO;
}
