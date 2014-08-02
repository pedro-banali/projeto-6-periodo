package br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

public class MessagesUtils {

	private static final Logger log = Logger.getLogger(MessagesUtils.class);

	public static void addInfo(String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, getLabel(title)+":", getLabel(message)));
		log.info(getLabel(message));
	}

	public static void addWarn(String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, getLabel(title)+":", getLabel(message)));
		log.warn(getLabel(message));
	}

	public static void addError(String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, getLabel(title)+":", getLabel(message)));
		log.error(getLabel(message));
	}

	public static void addFatal(String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, getLabel(title)+":", getLabel(message)));
		log.fatal(getLabel(message));
	}

	public static String getLabel(String label) {
		ResourceBundle rb = LocaleEnum.getResourceBundle(FacesContext
				.getCurrentInstance().getViewRoot().getLocale());
		return rb.getString(label);
	}

}
