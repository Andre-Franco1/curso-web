package com.curso.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.curso.dao.CompeticaoDAO;
import com.curso.modelo.Competicao;
import com.curso.util.NegocioException;

public class CompeticaoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CompeticaoDAO competicaoDAO;

    public void salvar(Competicao competicao) throws NegocioException {
        validarCompeticao(competicao);
        competicaoDAO.salvar(competicao);
    }

    public List<Competicao> buscarTodas() {
        return competicaoDAO.buscarTodos();
    }

    public void excluir(Long codigo) throws NegocioException {
        if (codigo == null) {
            throw new NegocioException("Código nulo.");
        }
        Competicao competicao = competicaoDAO.buscarPeloCodigo(codigo);
        if (competicao == null) {
            throw new NegocioException("Competição não encontrada.");
        }
        competicaoDAO.excluir(competicao);
    }

    private void validarCompeticao(Competicao competicao) throws NegocioException {
        if (competicao == null) {
            throw new NegocioException("Competição nula.");
        }
        if (competicao.getNome() == null || competicao.getNome().isEmpty()) {
            throw new NegocioException("Nome da competição nulo.");
        }
    }
}
