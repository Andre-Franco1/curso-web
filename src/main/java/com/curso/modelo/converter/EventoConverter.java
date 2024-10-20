package com.curso.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.curso.dao.EventoDAO;
import com.curso.modelo.Evento;
import com.curso.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Evento.class)
public class EventoConverter implements Converter {

	private EventoDAO eventoDAO;
	
	public EventoConverter() {
		this.eventoDAO = CDIServiceLocator.getBean(EventoDAO.class);
	}

	@Override    //converte tipo String para objeto - necessário mapear do modelo relacional para obj
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Evento retorno = null;

		if (value != null) {
			retorno = this.eventoDAO.buscarPeloCodigo(Long.parseLong(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
}
