package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.IdentifierInterface;

@FacesConverter(forClass = Aeroporto.class, value="aeroportoConverter")
public class AeroportoConverter implements Converter {
	    @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value != null && value instanceof Aeroporto ) {
	        	IdentifierInterface entity = (IdentifierInterface) value;  
	        	  
	            
	        	if(((Aeroporto) value).getId() != null)
	        	{
		        	String key = ((Aeroporto) value).getId().toString(); 
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

