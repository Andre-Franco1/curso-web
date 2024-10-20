package com.curso.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.curso.modelo.Clube;
import com.curso.modelo.Competicao;
import com.curso.util.NegocioException;
import com.curso.util.jpa.Transactional;

public class CompeticaoDAO implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Transactional
	public void salvar(Competicao competicao) {
		manager.merge(competicao);
	}
	
	@SuppressWarnings("unchecked")
	public List<Competicao> buscarTodos() {
		return manager.createNamedQuery("Competicao.buscarTodos").getResultList();
	}
	
	@Transactional
	public void excluir(Competicao competicao) throws NegocioException {
		competicao = buscarPeloCodigo(competicao.getCodigo());
		try {
			manager.remove(competicao);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Esta competicao não pode ser excluída.");
		}
	}
	public Competicao buscarPeloCodigo(Long codigo) {
		return manager.find(Competicao.class, codigo);
	}
	
}
