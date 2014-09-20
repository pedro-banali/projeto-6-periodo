package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums;

public enum PassageiroEnum {
	
	PASSAGEIRO_01("09/03/1997", "782.221.373-36", "passageiro01@passageiros.com.br", 
			"Passageiro 01", "PASS-0001", "senhaPass01", "PASS0123", "passageiro01"),
			
	PASSAGEIRO_02("07/05/2000", "515.553.590-51", "passageiro02@passageiros.com.br",
			"Passageiro 02", "PASS-0002", "senhaPass02", "PASS0456", "passageiro02"),
			
	PASSAGEIRO_03("20/07/1954", "579.251.448-82", "passageiro03@passageiros.com.br", 
			"Passageiro 03", "PASS-0003", "senhaPass03", "PASS0789", "passageiro03"),
			
	PASSAGEIRO_04("25/01/1985", "750.522.846-32", "passageiro04@passageiros.com.br",
			"Passageiro 04", "PASS-0004", "senhaPass04", "PASS3210", "passageiro04"),
			
	PASSAGEIRO_05("09/02/1984", "468.246.046-31", "passageiro05@passageiros.com.br",
			"Passageiro 05", "PASS-0005", "senhaPass05", "PASS6540", "passageiro05"),
			
	PASSAGEIRO_06("14/03/1987", "654.801.274-70", "passageiro06@passageiros.com.br",
			"Passageiro 06", "PASS-0006", "senhaPass06", "PASS9870", "passageiro06");
	
	private String dataNascimento, documento, email, nome, numeroCartao, senha, telefone, usuario;
	
	private PassageiroEnum(String dataNascimento, String documento, String email, String nome, 
			String numeroCartao, String senha, String telefone, String usuario) {
		
		this.dataNascimento = dataNascimento;
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.numeroCartao = numeroCartao;
		this.senha = senha;
		this.telefone = telefone;
		this.usuario = usuario;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public String getDocumento() {
		return documento;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getUsuario() {
		return usuario;
	}
}
