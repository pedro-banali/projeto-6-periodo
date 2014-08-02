package br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages;

import java.util.Locale;
import java.util.ResourceBundle;

public enum LocaleEnum {
	ENGLISH(Locale.US),
	PORTUGUESE(new Locale("pt","BR"));
	
	private Locale locale;
	private ResourceBundle resourceBundle;
	
	private LocaleEnum(Locale locale) {
		this.locale = locale;
		resourceBundle = ResourceBundle.getBundle("br.pucpr.bsi.prog6.ticketsAereosBSI.view.properties.messages", locale);
	}
	
	public Locale getLocale() {
		return locale;
	}
	
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	public static ResourceBundle getResourceBundle(Locale locale) {
		if(ENGLISH.locale.equals(locale))
			return ENGLISH.resourceBundle;
		else if(PORTUGUESE.locale.equals(locale))
			return PORTUGUESE.resourceBundle;
		return null;
	}
}
