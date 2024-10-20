package com.curso.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.curso.modelo.Categoria;
import com.curso.service.CategoriaService;

@Named
@ViewScoped
public class PesquisaCategoriaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Categoria> categorias = new ArrayList<Categoria>();

	@Inject
	CategoriaService categoriaService;

		
	@PostConstruct
	public void inicializar() {
		categorias = categoriaService.buscarTodos();
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	
}
