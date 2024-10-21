package com.curso.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.curso.modelo.Inscricao;
import com.curso.service.InscricaoService;

@Named
@ViewScoped
public class PesquisaInscricaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Inscricao> inscricoes = new ArrayList<Inscricao>();

	
	@Inject
	private InscricaoService inscricaoService;

		
	@PostConstruct
	public void inicializar() {
		inscricoes = inscricaoService.buscarTodos();
	}


	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}


	
}
