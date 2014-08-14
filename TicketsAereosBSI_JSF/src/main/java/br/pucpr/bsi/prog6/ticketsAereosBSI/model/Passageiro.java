package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

public class Passageiro extends Pessoa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5323481036344324077L;
	private String numeroCartao;
	private double carga;
	
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public double getCarga() {
		return carga;
	}
	public void setCarga(double carga) {
		this.carga = carga;
	}
	
	
	
}
