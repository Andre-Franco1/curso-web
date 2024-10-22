package com.curso.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.curso.dao.InscricaoDAO;
import com.curso.modelo.Inscricao;
import com.curso.util.NegocioException;

public class InscricaoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private InscricaoDAO inscricaoDAO;

    public void salvar(Inscricao inscricao) throws NegocioException {
        validarInscricao(inscricao);
        inscricaoDAO.salvar(inscricao);
    }

    public List<Inscricao> buscarTodas() {
        return inscricaoDAO.buscarTodos();
    }

    public void excluir(Long codigo) throws NegocioException {
        if (codigo == null) {
            throw new NegocioException("Código nulo.");
        }
        Inscricao inscricao = inscricaoDAO.buscarPeloCodigo(codigo);
        if (inscricao == null) {
            throw new NegocioException("Inscrição não encontrada.");
        }
        inscricaoDAO.excluir(inscricao);
    }

    private void validarInscricao(Inscricao inscricao) throws NegocioException {
        if (inscricao == null) {
            throw new NegocioException("Inscrição nula.");
        }

        if (inscricao.getAtleta() == null) {
            throw new NegocioException("Atleta não pode ser nulo.");
        }
    }
}
