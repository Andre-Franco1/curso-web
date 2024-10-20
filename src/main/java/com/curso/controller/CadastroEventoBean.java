package com.curso.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.curso.modelo.Competicao;
import com.curso.modelo.Evento;
import com.curso.modelo.enums.Etapa;
import com.curso.service.EventoService;
import com.curso.util.MessageUtil;
import com.curso.util.NegocioException;

@Named
@ViewScoped
public class CadastroEventoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Evento evento;
	private List<Etapa> etapas;
	private List<Competicao> competicoes;
	
	@Inject
	private EventoService eventoService;
	
	@PostConstruct
	public void inicializar(){
		competicoes = eventoService.buscarCompeticoes();
		etapas = Arrays.asList(Etapa.values());
		limpar();		
	}
	
	public void salvar() {
		try {
	
			this.eventoService.salvar(evento);
			MessageUtil.sucesso("Evento salvo com sucesso!");
		} catch (NegocioException e) {
			MessageUtil.erro(e.getMessage());
		} catch (Exception ex) {
			MessageUtil.erro(ex.getMessage());
		}
		
		this.limpar();
	}
	public void limpar() {
		this.evento = new Evento();		
	}
	public List<Etapa> getEtapas() {
		return etapas;
	}

	public List<Competicao> getCompeticoes() {
		return competicoes;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
}
