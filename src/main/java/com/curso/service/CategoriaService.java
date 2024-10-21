package com.curso.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.curso.dao.CategoriaDAO;
import com.curso.modelo.Categoria;
import com.curso.util.NegocioException;

public class CategoriaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CategoriaDAO categoriaDAO;

    public void salvar(Categoria categoria) throws NegocioException {
        validarCategoria(categoria);
        categoriaDAO.salvar(categoria);
    }

    public List<Categoria> buscarTodas() {
        return categoriaDAO.buscarTodos();
    }

    public void excluir(Long codigo) throws NegocioException {
        if (codigo == null) {
            throw new NegocioException("Código nulo.");
        }
        Categoria categoria = categoriaDAO.buscarPeloCodigo(codigo);
        if (categoria == null) {
            throw new NegocioException("Categoria não encontrada.");
        }
        categoriaDAO.excluir(categoria);
    }

    private void validarCategoria(Categoria categoria) throws NegocioException {
        if (categoria == null) {
            throw new NegocioException("Categoria nula.");
        }
        if (categoria.getNome() == null || categoria.getNome().isEmpty()) {
            throw new NegocioException("Nome da categoria nulo.");
        }
        if (categoria.getSigla() == null || categoria.getSigla().isEmpty()) {
            throw new NegocioException("Sigla da categoria nula.");
        }
    }
}
