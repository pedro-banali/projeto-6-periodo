package br.pucpr.bsi.prog6.ticketsAereosBSI.enums;

public enum TipoBagagemEnum {
	MAO(1, "Mão", 12), 
	NACIONAL(2,"Nacional", 23.0),
	INTERNACIONAL(3, "Internacional", 32.0);
	
	private int id;
	private String nome;
	private double pesoMax;
	
	TipoBagagemEnum(int id, String nome, double pesoMax)
	{
		this.id = id;
		this.nome = nome;
		this.pesoMax = pesoMax;
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPesoMax() {
		return pesoMax;
	}

	public void setPesoMax(double pesoMax) {
		this.pesoMax = pesoMax;
	}
	
	
}
