package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

public abstract class Bilhete {
	private long id;
	private int numero;
	private String assento;
	
	public long getId() {
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
