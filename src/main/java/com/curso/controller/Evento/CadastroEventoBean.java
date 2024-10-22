package com.curso.controller.Evento;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;
import com.curso.util.MessageUtil;
import com.curso.modelo.Evento;
import com.curso.util.NegocioException;
import com.curso.service.EventoService;
import java.io.Serializable;

@Named
@ViewScoped
public class CadastroEventoBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Evento evento;

    @Inject
    private EventoService eventoService;

    @PostConstruct
    public void inicializar() {
        limpar();
    }

    public void limpar() {
        evento = new Evento();
    }

    public void salvar() {
        try {
            eventoService.salvar(evento);
            MessageUtil.sucesso("Evento registrado! Sucesso.");
            limpar();
        } catch (NegocioException e) {
            MessageUtil.erro(e.getMessage());

        }
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
