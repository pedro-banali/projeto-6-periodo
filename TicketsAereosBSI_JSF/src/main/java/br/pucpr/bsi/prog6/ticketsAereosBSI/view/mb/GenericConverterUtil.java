package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AviaoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.HorarioBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PapelBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PassageiroBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.RotaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.IdentifierInterface;

@FacesConverter(value = "generic")
public class GenericConverterUtil implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		try{
			String className = value.split(",")[0];
			Long id = Long.parseLong(value.split(",")[1]);
			
			if( className.equals("CiaAerea") ){
				return CiaAereaBC.getInstance().findById(id);
			}
			if( className.equals("Aviao") ){
				return AviaoBC.getInstance().findById(id);
			}
			if( className.equals("Papel") ){
				return PapelBC.getInstance().findById(id);
			}
			if( className.equals("Aeroporto") ){
				return AeroportoBC.getInstance().findById(id);
			}
			if( className.equals("Rota") ){
				return RotaBC.getInstance().findById(id);
			}
			if( className.equals("Horario") ){
				return HorarioBC.getInstance().findById(id);
			}
			if( className.equals("Passageiro") ){
				return PassageiroBC.getInstance().findById(id);
			}
			
		}catch(Exception e){
			
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try{
			return value.getClass().getSimpleName() + "," +((IdentifierInterface)value).getId().toString();
		}catch(Exception e){
			
		}
		return "Not Found";
	}
	
}