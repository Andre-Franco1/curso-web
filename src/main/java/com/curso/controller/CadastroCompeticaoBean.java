package com.curso.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.curso.modelo.Competicao;
import com.curso.service.CompeticaoService;
import com.curso.util.MessageUtil;
import com.curso.util.NegocioException;

@Named
@ViewScoped
public class CadastroCompeticaoBean implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private Competicao competicao;
	

	@Inject
	private CompeticaoService competicaoService;

	@PostConstruct
	public void inicializar(){
		this.limpar();		
	}
	
	public void limpar() {
		this.competicao = new Competicao();
	}
	
	public void salvar() {
		try {
			this.competicaoService.salvar(competicao);
			MessageUtil.sucesso("Competicao salvo com sucesso!");
		} catch (NegocioException e) {
			MessageUtil.erro(e.getMessage());
		}
		
		this.limpar();
	}

	public Competicao getCompeticao() {
		return competicao;
	}

	public void setCompeticao(Competicao competicao) {
		this.competicao = competicao;
	}
	
	
}
