package com.curso.controller.Competicao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.curso.modelo.Competicao;
import com.curso.service.CompeticaoService;
import com.curso.util.MessageUtil;
import com.curso.util.NegocioException;

@Named
@ViewScoped
public class PesquisaCompeticaoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Competicao> competicoes = new ArrayList<>();
    
    private Competicao competicao;

    @Inject
    private CompeticaoService competicaoService;

    @PostConstruct
    public void inicializar() {
        competicoes = competicaoService.buscarTodas();
    }

    public void excluir() {
        try {
            competicaoService.excluir(competicao.getCodigo());
            competicoes.remove(competicao);
            MessageUtil.sucesso("Competição " + competicao.getNome() + " excluída com sucesso.");
        } catch (NegocioException e) {
            MessageUtil.erro(e.getMessage());
        }
    }

    public List<Competicao> getCompeticoes() {
        return competicoes;
    }

    public Competicao getcompeticao() {
        return competicao;
    }

    public void setcompeticao(Competicao competicao) {
        this.competicao = competicao;
    }
}
