package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

public class Passageiro extends Pessoa {
	
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
