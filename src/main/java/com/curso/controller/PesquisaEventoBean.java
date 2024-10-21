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
import com.curso.util.MessageUtil;
import com.curso.util.NegocioException;

@Named
@ViewScoped
public class PesquisaEventoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Evento> eventos = new ArrayList<>();
    private Evento evento;

    @Inject
    private EventoService eventoService;

    @PostConstruct
    public void inicializar() {
        eventos = eventoService.buscarTodos();
    }

    public void excluir() {
        try {
            eventoService.excluir(evento.getCodigo());
            eventos.remove(evento);
            MessageUtil.sucesso("Evento " + evento.getCodigo() + " excluído com sucesso.");
        } catch (NegocioException e) {
            MessageUtil.erro(e.getMessage());
        }
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
