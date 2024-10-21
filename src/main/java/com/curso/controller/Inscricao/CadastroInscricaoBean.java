package com.curso.controller.Inscricao;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;
import com.curso.util.MessageUtil;
import com.curso.modelo.Inscricao;
import com.curso.service.InscricaoService;
import com.curso.util.NegocioException;
import java.io.Serializable;

@Named
@ViewScoped
public class CadastroInscricaoBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Inscricao inscricao;

    @Inject
    private InscricaoService inscricaoService;

    public void limpar() {
        inscricao = new Inscricao();
    }

    public void salvar() {
        try {
            inscricaoService.salvar(inscricao);
            MessageUtil.sucesso("Inscrição registrada! Sucesso.");
            limpar();
        } catch (NegocioException e) {
            MessageUtil.erro(e.getMessage());
        }
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }
}
