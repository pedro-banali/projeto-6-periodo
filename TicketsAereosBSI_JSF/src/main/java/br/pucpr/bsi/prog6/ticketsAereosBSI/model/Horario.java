package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.util.Date;

public class Horario {
	
	private long id;
	private Date partida;
	private Date chegada;
	private String codigo;
	private int qtdEconomica;
	private int qtdPrimeira;
	private int qtdExecutiva;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getPartida() {
		return partida;
	}
	public void setPartida(Date partida) {
		this.partida = partida;
	}
	public Date getChegada() {
		return chegada;
	}
	public void setChegada(Date chegada) {
		this.chegada = chegada;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getQtdEconomica() {
		return qtdEconomica;
	}
	public void setQtdEconomica(int qtdEconomica) {
		this.qtdEconomica = qtdEconomica;
	}
	public int getQtdPrimeira() {
		return qtdPrimeira;
	}
	public void setQtdPrimeira(int qtdPrimeira) {
		this.qtdPrimeira = qtdPrimeira;
	}
	public int getQtdExecutiva() {
		return qtdExecutiva;
	}
	public void setQtdExecutiva(int qtdExecutiva) {
		this.qtdExecutiva = qtdExecutiva;
	}
	
	
	
}
