package com.curso.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.curso.modelo.Inscricao;
import com.curso.util.NegocioException;
import com.curso.util.jpa.Transactional;

public class InscricaoDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Transactional
	public void salvar(Inscricao inscricao) throws NegocioException {
			manager.merge(inscricao);
	}
	
	@SuppressWarnings("unchecked")
	public List<Inscricao> buscarTodos() {
		return manager.createNamedQuery("Inscricao.buscarTodos").getResultList();
	}	
	
	public Inscricao buscarPeloCodigo(Long codigo) {
		return manager.find(Inscricao.class, codigo);
	}
}
