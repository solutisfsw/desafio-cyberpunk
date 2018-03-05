package br.com.solutis.cyberpunk.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.solutis.cyberpunk.model.Clone;
import br.com.solutis.cyberpunk.repository.Clones;

@FacesConverter(forClass = Clone.class)
public class CloneConverter implements Converter {

	@Inject
	private Clones usuarios;

	@Override
	public Object getAsObject(FacesContext context, UIComponent componet,
			String value) {
		Clone retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			return retorno = usuarios.porId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Clone usuario = (Clone) value;
			return usuario.getId() == null ? null : usuario.getId().toString();
		}

		return "";
	}

}
