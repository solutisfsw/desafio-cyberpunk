package br.com.solutis.cyberpunk.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import br.com.solutis.cyberpunk.model.Clone;
import br.com.solutis.cyberpunk.repository.Clones;
import br.com.solutis.cyberpunk.repository.filter.CloneFilter;
import br.com.solutis.cyberpunk.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaClonesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Clones clones;

	private CloneFilter filtro;

	private List<Clone> clonesFiltrados;

	private Clone cloneSelecionado;

	public PesquisaClonesBean() {
		filtro = new CloneFilter();
	}

	public void pesquisar() {
		clonesFiltrados = clones.filtrados(filtro);
	}

	public void excluir() {
		if (cloneSelecionado != null) {
			try {
				clones.remover(cloneSelecionado);
				clonesFiltrados.remove(cloneSelecionado);

				FacesUtil.addInfoMessage("Clone "
						+ cloneSelecionado.getNome()
						+ " excluído com sucesso.");
			} catch (PersistenceException e) {
				FacesUtil.addErrorMessage("O Clone "
						+ cloneSelecionado.getNome()
						+ " não pode ser excluído.");
			}
		}
	}

	public List<Clone> getClonesFiltrados() {
		return clonesFiltrados;
	}

	public CloneFilter getFiltro() {
		return filtro;
	}

	public Clone getCloneSelecionado() {
		return cloneSelecionado;
	}

	public void setCloneSelecionado(Clone cloneSelecionado) {
		this.cloneSelecionado = cloneSelecionado;
	}
}