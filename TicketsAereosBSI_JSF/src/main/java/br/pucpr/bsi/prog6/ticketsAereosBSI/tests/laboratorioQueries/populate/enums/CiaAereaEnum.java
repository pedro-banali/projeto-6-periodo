package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums;

public enum CiaAereaEnum {
	
	AZUL("Azul"),
	GOL("Gol"),
	TAM("Tam");
	
	private String nome;
	
	private CiaAereaEnum(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
