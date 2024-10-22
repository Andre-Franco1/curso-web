package com.curso.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.curso.dao.EventoDAO;
import com.curso.modelo.Evento;
import com.curso.util.NegocioException;

public class EventoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EventoDAO eventoDAO;

    public void salvar(Evento evento) throws NegocioException {
        validarEvento(evento);
        eventoDAO.salvar(evento);
    }

    public List<Evento> buscarTodos() {
        return eventoDAO.buscarTodos();
    }

    public void excluir(Long codigo) throws NegocioException {
        if (codigo == null) {
            throw new NegocioException("Código nulo.");
        }
        Evento evento = eventoDAO.buscarPeloCodigo(codigo);
        if (evento == null) {
            throw new NegocioException("Evento não encontrado.");
        }
        eventoDAO.excluir(evento);
    }

    private void validarEvento(Evento evento) throws NegocioException {
        if (evento == null) {
            throw new NegocioException("Evento nulo.");
        }
        if (evento.getCodigo() == null) {
            throw new NegocioException("Evento nulo.");
        }

    }
}
