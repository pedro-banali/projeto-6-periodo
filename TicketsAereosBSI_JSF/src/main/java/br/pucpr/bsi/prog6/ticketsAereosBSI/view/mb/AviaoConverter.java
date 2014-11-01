package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.IdentifierInterface;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;

@FacesConverter(forClass = Aviao.class, value="aviaoConverter")
public class AviaoConverter implements Converter {



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
		        if (value != null && value instanceof Aviao ) {
		        	IdentifierInterface entity = (IdentifierInterface) value;  
		        	  
		            // adiciona item como atributo do componente 
		        	if(((Aviao) value).getId() != null)
		        	{
			        	String key = ((Aviao) value).getId().toString(); 
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
