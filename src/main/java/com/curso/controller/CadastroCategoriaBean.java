package com.curso.controller;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;
import com.curso.util.MessageUtil;
import com.curso.modelo.Categoria;
import com.curso.service.CategoriaService;
import com.curso.util.NegocioException;
import java.io.Serializable;

@Named
@ViewScoped
public class CadastroCategoriaBean implements Serializable {
    private static final long serialVersionUID = 1L; // necessário por causa do Serializable

    private Categoria categoria;

    @Inject
    private CategoriaService categoriaService;

    @PostConstruct
    public void inicializar() {
        limpar();
    }

    public void limpar() {
        categoria = new Categoria();
    }

    public void salvar() {
        try {
            categoriaService.salvar(categoria);
            MessageUtil.sucesso("Categoria registrada! Sucesso.");
            limpar();
        } catch (NegocioException e) {
            MessageUtil.erro(e.getMessage());
        }
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
