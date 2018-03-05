package br.com.solutis.cyberpunk.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.com.solutis.cyberpunk.model.Clone;
import br.com.solutis.cyberpunk.repository.Clones;
import br.com.solutis.cyberpunk.util.jpa.Transactional;

public class CadastroCloneService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Clones clones;

	@Transactional
	public Clone salvar(Clone clone) {
		Clone cloneExistente = clones.porNome(clone.getNome());

		if (clone.isNovo()) {
			clone.setDataCriacao(new Date());
		}
		
		if (cloneExistente != null && !cloneExistente.equals(clone)) {
			throw new NegocioException("Já existe o Clone informado.");
		}
		
		if (clone.getIdade() < 10 || clone.getIdade() > 20) {
			throw new NegocioException("Idade informada inválida, favor preencher a idade com um número entre 10 e 20.");
		}
		
		return clones.guardar(clone);

	}

}
