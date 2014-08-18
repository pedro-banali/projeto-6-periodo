package br.pucpr.bsi.prog6.ticketsAereosBSI.enums;

public enum SituacaoBilheteEnum {
	DISPONIVEL(1, "Disponível"), 
	RESERVADO(2,"Reservado"),
	VENDIDO(3, "Vendido");
	
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
