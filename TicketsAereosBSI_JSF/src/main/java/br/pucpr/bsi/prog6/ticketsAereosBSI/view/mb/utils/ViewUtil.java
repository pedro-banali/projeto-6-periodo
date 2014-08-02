package br.pucpr.bsi.prog6.ticketsAereosBSI.view.mb.utils;

import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;

public class ViewUtil {
	/**
	 * Adiciona objeto no 'Request'
	 * Este escopo perde o objeto se for realizado um 'redirect'.
	 * @param name
	 * @param value
	 */
	public static void setRequestParameter(String name, Object value) {
		if(StringUtils.isNotBlank(name) && value != null){
			FacesContext.getCurrentInstance().getExternalContext()
				.getRequestMap().put(name, value);
		}
	}

	/**
	 * Seta a variável no 'Request'  usando o nome da classe como chave. <br/>
	 * 
	 * @see this{@link #setRequestParameter(String, Object)} <br/>
	 * @param value
	 */
	public static void setRequestParameter(Object value) {
		setRequestParameter(value.getClass().toString(), value);
	}
	
	/**
	 * Recupera objeto do 'Request'.
	 * 
	 * O método é privado porque ele deve ser usado apenas através do método {@link #getParameter(String)}.
	 * @param name
	 * @return object
	 */
	private static Object getRequestParameter(String name) {
		return FacesContext.getCurrentInstance().getExternalContext().
				getRequestMap().get(name);
    }
	
	/**
	 * Recupera objeto do 'Request Values'.
	 * 
	 * O método é privado porque ele deve ser usado apenas através do método {@link #getParameter(String)}.
	 * @param name
	 * @return object
	 */
	private static Object getRequestParameterValues(String name) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterValuesMap().get(name);
    }	
	
	/**
	 * Procura por um parâmetro com o nome dado.
	 * 
	 * A procura ocorre no escopo request e no flash.
	 * Primeiro olhamos o request porque ele é o escopo mais restritivo (necessariamente o parâmetro foi definido para essa requisição).
	 * 
	 * @param key
	 * @return
	 */
	public static Object getParameter(String key) {
		Object parameter = getRequestParameterValues(key);
		if (parameter == null) {
			parameter = getRequestParameter(key);
		}
		return parameter;
    }

	public static Object getParameter(Class<?> classeDoParametro) {
		return getParameter(classeDoParametro.toString());
    }

}
