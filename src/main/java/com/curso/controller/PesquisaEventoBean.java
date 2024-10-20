package com.curso.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.curso.modelo.Evento;
import com.curso.service.EventoService;

@Named
@ViewScoped
public class PesquisaEventoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Evento> eventos = new ArrayList<Evento>();
	
	@Inject
	private EventoService eventoService;

		
	@PostConstruct
	public void inicializar() {
		eventos = eventoService.buscarTodos();
		System.out.print("oq temos aqui " + eventos);
	}


	public List<Evento> getEventos() {
		return eventos;
	}

	
}
