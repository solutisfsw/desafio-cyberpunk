package br.com.solutis.cyberpunk.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.solutis.cyberpunk.model.Adicional;
import br.com.solutis.cyberpunk.model.Clone;
import br.com.solutis.cyberpunk.service.CadastroCloneService;
import br.com.solutis.cyberpunk.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroCloneBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroCloneService cadastroCloneService;

	private Clone clone;
	private Adicional adicional;
	private Adicional adicionalSelecionado;

	private List<Adicional> adicionais;

	public CadastroCloneBean() {
		limpar();
	}

	private void limpar() {
		clone = new Clone();
		adicionais = new ArrayList<>();

	}

	public void inicializar() {
		System.out.println("Inicializando...");

		if (this.clone== null) {
			limpar();
		}
		
		carregarAdicionais();
	}

	public void salvar() {
		this.clone = cadastroCloneService.salvar(this.clone);
		limpar();

		FacesUtil.addInfoMessage("Clone salvo com sucesso!");
	}

	public void adicionarAdicional() {
		if (adicional != null) {
			clone.getAdicionais().add(adicional);
			adicionais.remove(adicional);
			// FacesUtil.addInfoMessage("Adicional incluído!");
			adicional = null;
		}
	}

	public void removerAdicional() {
		if (adicional != null) {
			clone.getAdicionais().remove(adicional);
			adicionais.add(adicional);
			// FacesUtil.addInfoMessage("Adicional excluído!");
			adicional = null;
		}
	}

	public boolean isEditando() {
		return this.clone.getId() != null;
	}

	public void carregarAdicionais() {
		
		for (Adicional adicional : Adicional.values()) {
			adicionais.add(adicional);
		}
		

		for (Adicional a : clone.getAdicionais()) {
			adicionais.remove(a);
		}

	}
	
	public boolean isBotaoAddAdicionalDisabled() {
		return adicionais.isEmpty() || adicional == null;
	}

	public Clone getclone() {
		return clone;
	}

	public void setclone(Clone clone) {
		this.clone = clone;
	}

	
	public List<Adicional> getAdicionais() {
		return adicionais;
	}
	
	public void setAdicionais(List<Adicional> adicionais) {
		this.adicionais = adicionais;
	}

	public Adicional getAdicional() {
		return adicional;
	}

	public void setAdicional(Adicional adicional) {
		this.adicional = adicional;
	}

	public Adicional getAdicionalSelecionado() {
		return adicionalSelecionado;
	}

	public void setAdicionalSelecionado(Adicional adicionalSelecionado) {
		this.adicionalSelecionado = adicionalSelecionado;
	}
}
