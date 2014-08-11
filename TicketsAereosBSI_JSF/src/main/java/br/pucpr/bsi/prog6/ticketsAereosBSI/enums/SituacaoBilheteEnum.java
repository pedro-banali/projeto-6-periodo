package br.pucpr.bsi.prog6.ticketsAereosBSI.enums;

public enum SituacaoBilheteEnum {
	UM(1, "Disponível"), 
	DOIS(2,"Reservado"),
	TRES(3, "Vendido");
	
	private int id;
	private String nome;
	
	SituacaoBilheteEnum(int id, String nome)
	{
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
}
