package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

public class Funcionario extends Pessoa {
	
	private String codigo;
	private String contaCorrente;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	
	
}
