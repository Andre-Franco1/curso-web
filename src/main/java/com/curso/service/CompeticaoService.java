package com.curso.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.curso.dao.CompeticaoDAO;
import com.curso.modelo.Competicao;
import com.curso.util.NegocioException;

public class CompeticaoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CompeticaoDAO competicaoDAO;
	
	public void salvar(Competicao competicao) throws NegocioException {			
		
		this.competicaoDAO.salvar(competicao);
	}
}
