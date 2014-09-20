package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums;


public enum AeroportoEnum {
	
	AERO_BRASILIA("Brasilia", "BSB", EnderecoEnum.END_AERO_BRASILIA),
	AERO_CONFINS("Confins", "CNF", EnderecoEnum.END_AERO_CONFINS),
	AERO_CURITIBA("Curitiba", "CWB", EnderecoEnum.END_AERO_CURITIBA),
	AERO_GUARULHOS("Guarulhos", "GRU", EnderecoEnum.END_AERO_GUARULHOS),
	AERO_PORTO_ALEGRE("Porto Alegre", "POA", EnderecoEnum.END_AERO_PORTO_ALEGRE),
	AERO_SANTOS_DUMONT("Santos Dumont", "SDU", EnderecoEnum.END_AERO_SANTOS_DUMONT);
	
	private String nome, codigo;
	private EnderecoEnum enderecoEnum;
	
	private AeroportoEnum(String nome, String codigo, EnderecoEnum enderecoEnum) {
		this.nome = nome;
		this.codigo = codigo;
		this.enderecoEnum = enderecoEnum;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public EnderecoEnum getEnderecoEnum() {
		return enderecoEnum;
	}
}
