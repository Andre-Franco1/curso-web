package com.curso.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.curso.modelo.Competicao;
import com.curso.util.jpa.Transactional;

public class CompeticaoDAO implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Transactional
	public void salvar(Competicao competicao) {
		manager.merge(competicao);
	}
}
