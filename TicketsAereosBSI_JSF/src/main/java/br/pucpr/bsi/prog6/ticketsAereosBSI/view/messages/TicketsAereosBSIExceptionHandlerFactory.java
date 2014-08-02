package br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class TicketsAereosBSIExceptionHandlerFactory extends ExceptionHandlerFactory {
	private ExceptionHandlerFactory parent;

	// this injection handles jsf
	public TicketsAereosBSIExceptionHandlerFactory(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {

		ExceptionHandler handler = new TicketsAereosBSIExceptionHandler(
				parent.getExceptionHandler());

		return handler;
	}

}
