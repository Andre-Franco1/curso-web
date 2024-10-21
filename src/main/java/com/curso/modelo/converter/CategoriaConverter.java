package com.curso.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.curso.dao.CategoriaDAO;
import com.curso.modelo.Categoria;
import com.curso.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Categoria.class)
public class CategoriaConverter  implements Converter {

	private CategoriaDAO categoriaDAO;
	
	public CategoriaConverter() {
		this.categoriaDAO = CDIServiceLocator.getBean(CategoriaDAO.class);
	}
	
	@Override    //converte tipo String para objeto - necessário mapear do modelo relacional para obj
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Categoria retorno = null;

		if (value != null) {
			retorno = this.categoriaDAO.buscarPeloCodigo(Long.parseLong(value));
		}

		return retorno;
	}

	@Override  //converte de objeto para codigo - necessário mapear do modelo obj para relacional
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Categoria) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}
}
