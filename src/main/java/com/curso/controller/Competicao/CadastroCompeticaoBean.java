package com.curso.controller.Competicao;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;
import com.curso.util.MessageUtil;
import com.curso.modelo.Atleta;
import com.curso.modelo.Competicao;
import com.curso.util.NegocioException;
import com.curso.service.CompeticaoService;
import java.io.Serializable;

@Named("cadastroCompeticaoBean")
@ViewScoped
public class CadastroCompeticaoBean implements Serializable {
    private static final long serialVersionUID = 1L; // necessário por causa do Serializable

    private Competicao competicao;

    @Inject
    private CompeticaoService competicaoService;

    @PostConstruct
    public void inicializar() {
        this.limpar();
    }

    public void limpar() {
        competicao = new Competicao();
    }

    public void salvar() {
        try {
            competicaoService.salvar(competicao);
            MessageUtil.sucesso("Competição registrada! Sucesso.");
            this.limpar();
        } catch (NegocioException e) {
            MessageUtil.erro(e.getMessage());
        }
    }

    public Competicao getCompeticao() {
        return competicao;
    }

    public void setCompeticao(Competicao competicao) {
        this.competicao = competicao;
    }
}
