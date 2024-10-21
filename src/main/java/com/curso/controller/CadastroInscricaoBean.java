package com.curso.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.curso.modelo.enums.Status;
import com.curso.modelo.Atleta;
import com.curso.modelo.Categoria;
import com.curso.modelo.Evento;
import com.curso.modelo.Inscricao;
import com.curso.service.InscricaoService;
import com.curso.util.MessageUtil;
import com.curso.util.NegocioException;

@Named
@ViewScoped
public class CadastroInscricaoBean implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private Inscricao inscricao;
	private List<Status> statusArray;
	
	private List<Atleta> atletas;
	private List<Evento> eventos;
	private List<Categoria> categorias;

	@Inject
	private InscricaoService inscricaoService;

	@PostConstruct
	public void inicializar(){
		atletas = inscricaoService.buscarAtletas();
		eventos = inscricaoService.buscarEventos();
		categorias = inscricaoService.buscarCategorias();
		
		statusArray = Arrays.asList(Status.values());
		this.limpar();		
	}
	
	public void limpar() {
		this.inscricao = new Inscricao();
		this.inscricao.setDataInscricao(new Date());
	}
	
	public void salvar() {
		try {
			this.inscricaoService.salvar(inscricao);
			MessageUtil.sucesso("inscrição salva com sucesso!");
		} catch (NegocioException e) {
			MessageUtil.erro(e.getMessage());
		}
		
		this.limpar();
	}

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setinscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}

	public List<Status> getStatusArray() {
		return statusArray;
	}

	public List<Atleta> getAtletas() {
		return atletas;
	}


	public List<Evento> getEventos() {
		return eventos;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}


	
}
