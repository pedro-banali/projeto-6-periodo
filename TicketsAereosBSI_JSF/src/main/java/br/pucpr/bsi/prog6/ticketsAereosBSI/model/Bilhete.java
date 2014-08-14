package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;

public abstract class Bilhete implements IdentifierInterface, Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1288350832675933793L;
	
	private long id;
	private int numero;
	private String assento;
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getAssento() {
		return assento;
	}
	public void setAssento(String assento) {
		this.assento = assento;
	}
	
	
}
