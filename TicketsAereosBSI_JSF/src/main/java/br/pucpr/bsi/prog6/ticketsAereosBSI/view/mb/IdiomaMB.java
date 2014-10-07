package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages.LocaleEnum.ENGLISH;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages.LocaleEnum.PORTUGUESE;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 * Locales validos:
 * 		br_PT
 * 		Locale.US
 * 
 * @author Everson Mauda
 * @version 1.0.0
 */

@ManagedBean
@SessionScoped
public class IdiomaMB implements Serializable{

	private static final long serialVersionUID = 1L;
	private static Locale locale = PORTUGUESE.getLocale();
	 
	public static Locale getLocale() {
		return locale;
	}
	
	public static void setLocale(Locale locale){
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		IdiomaMB.locale = locale;
	}
	
	public void mudarBrPt(){
		setLocale(PORTUGUESE.getLocale());
	}
	
	public void mudarUsEn(){
		setLocale(ENGLISH.getLocale());
	}
	
}
