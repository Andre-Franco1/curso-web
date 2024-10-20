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
import com.curso.util.MessageUtil;
import com.curso.util.NegocioException;

@Named
@ViewScoped
public class PesquisaCategoriaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private Categoria categoriaSelecionada;

	@Inject
	CategoriaService categoriaService;
	

		
	@PostConstruct
	public void inicializar() {
		categorias = categoriaService.buscarTodos();
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void excluir() {
		try {
			categoriaService.excluir(categoriaSelecionada);			
			this.categorias.remove(categoriaSelecionada);
			MessageUtil.sucesso("Categotia " + categoriaSelecionada.getNome() + " excluída com sucesso.");
		} catch (NegocioException e) {
			MessageUtil.erro(e.getMessage());
		}
	}

	public Categoria getCategoriaSelecionada() {
		return categoriaSelecionada;
	}

	public void setCategoriaSelecionada(Categoria categoriaSelecionada) {
		this.categoriaSelecionada = categoriaSelecionada;
	}
	
	
}
