package com.curso.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.curso.modelo.Categoria;
import com.curso.util.NegocioException;
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
	
	@Transactional
	public void excluir(Categoria categoria) throws NegocioException {
		categoria = buscarPeloCodigo(categoria.getCodigo());
		try {
			manager.remove(categoria);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Esta categoria não pode ser excluído.");
		}
	}
	
	public Categoria buscarPeloCodigo(Long codigo) {
		return manager.find(Categoria.class, codigo);
	}
}
