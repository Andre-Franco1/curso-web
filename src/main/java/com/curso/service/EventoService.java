package com.curso.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.curso.dao.CompeticaoDAO;
import com.curso.dao.EventoDAO;
import com.curso.modelo.Competicao;
import com.curso.modelo.Evento;
import com.curso.util.NegocioException;



public class EventoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EventoDAO eventoDAO;
	@Inject
	private CompeticaoDAO competicaoDAO;
	
	public void salvar(Evento evento) throws NegocioException {		
		this.eventoDAO.salvar(evento);		
	}
	public List<Competicao> buscarCompeticoes() {
		return competicaoDAO.buscarTodos();
	}
	
	public List<Evento> buscarTodos() {
		return eventoDAO.buscarTodos();
	}
	
	public void excluir(Evento evento) throws NegocioException {
		eventoDAO.excluir(evento);		
	}
	
}
