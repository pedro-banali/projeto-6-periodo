package br.pucpr.bsi.prog6.ticketsAereosBSI.exception;


/**
 * Classe de Exception para o projeto de Tickets Eventos
 * @author Mauda
 *
 */

public class TicketsAereosBSIException extends RuntimeException{

	private static final long serialVersionUID = 4928599035264976611L;
	
	public TicketsAereosBSIException(String message) {
		super(message);
	}
	
	
	public TicketsAereosBSIException(Throwable t) {
		super(t);
	}
}
