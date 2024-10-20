package com.curso.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.curso.modelo.Competicao;
import com.curso.service.CompeticaoService;



@Named
@ViewScoped
public class PesquisaCompeticaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Competicao> competicoes = new ArrayList<Competicao>();
	
	@Inject
	CompeticaoService competicaoService;
	
	@PostConstruct
	public void inicializar() {
		competicoes = competicaoService.buscarTodos();
	}

	public List<Competicao> getCompeticoes() {
		return competicoes;
	}
	
}
