package com.curso.controller.Inscricao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.curso.modelo.Inscricao;
import com.curso.service.InscricaoService;
import com.curso.util.MessageUtil;
import com.curso.util.NegocioException;

@Named
@ViewScoped
public class PesquisaInscricaoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Inscricao> inscricoes = new ArrayList<>();
    private Inscricao inscricao;

    @Inject
    private InscricaoService inscricaoService;

    @PostConstruct
    public void inicializar() {
        inscricoes = inscricaoService.buscarTodas();
    }

    public void excluir() {
        try {
            inscricaoService.excluir(inscricao.getCodigo());
            inscricoes.remove(inscricao);
            MessageUtil.sucesso("Inscrição " + inscricao.getCodigo() + " excluída com sucesso.");
        } catch (NegocioException e) {
            MessageUtil.erro(e.getMessage());
        }
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }
}
