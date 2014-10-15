package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.IdentifierInterface;

@FacesConverter(forClass = CiaAerea.class, value="ciaAereaConverter")
public class CiaAereaConverter implements Converter {
	    @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	        	System.out.println("Value: " + value);
	            return uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value != null && value instanceof CiaAerea ) {
	        	IdentifierInterface entity = (IdentifierInterface) value;  
	        	  
	            // adiciona item como atributo do componente 
	        	if(((CiaAerea) value).getId() != null)
	        	{
		        	String key = ((CiaAerea) value).getId().toString(); 
		        	uiComponent.getAttributes().put(key, value);
		  
		            Long codigo = entity.getId();  
		            if (codigo != null) {  
		                return String.valueOf(codigo);  
		            }  
	        	}
	        }  
	  
	        return "";  

	    }
	}

