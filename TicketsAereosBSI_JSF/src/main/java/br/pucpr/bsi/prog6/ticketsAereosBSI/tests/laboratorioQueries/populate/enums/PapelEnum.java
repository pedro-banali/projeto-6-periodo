package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums;

public enum PapelEnum {
	
	COMANDANTE_AZUL("Comandante Azul", "Comandante da Companhia Aerea Azul"),
	CO_PILOTO_AZUL("Co-Piloto_Azul", "Co-Piloto da Companhia Aerea Azul"),
	COMISSARIO_AZUL("Comissario_Azul", "Comissario de Bordo da Companhia Aerea Azul"),
	
	COMANDANTE_GOL("Comandante Gol", "Comandante da Companhia Aerea Gol"),
	CO_PILOTO_GOL("Co-Piloto_Gol", "Co-Piloto da Companhia Aerea Gol"),
	COMISSARIO_GOL("Comissario_Gol", "Comissario de Bordo  da Companhia Aerea Gol"),

	COMANDANTE_TAM("Comandante Tam", "Comandante da Companhia Aerea Tam"),
	CO_PILOTO_TAM("Co-Piloto_Tam", "Co-Piloto da Companhia Aerea Tam"),
	COMISSARIO_TAM("Comissario_Tam", "Comissario de Bordo  da Companhia Aerea Tam");
	
	private String nome;
	private String descricao;
	
	private PapelEnum(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
