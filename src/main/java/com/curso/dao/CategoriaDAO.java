package com.curso.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.curso.modelo.Categoria;
import com.curso.util.jpa.Transactional;

public class CategoriaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	
	@Transactional
	public void salvar(Categoria categoria) {
		manager.merge(categoria);
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> buscarTodos() {
		return manager.createNamedQuery("Categoria.buscarTodos").getResultList();
	}
}
