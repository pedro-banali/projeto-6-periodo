package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums;

public enum FuncionarioEnum {
	
	FUNC_AZUL_01("AZUL-0001", "CC-AZUL-0001", "20/05/1968", "func01@azul.com.br", 
			"Funcionario Azul 01", "senhaAzul01", "AZUL0123", "funcAzul01"), 
	FUNC_AZUL_02("AZUL-0002", "CC-AZUL-0002", "10/05/1978", "func02@azul.com.br", 
			"Funcionario Azul 02", "senhaAzul02", "AZUL0456", "funcAzul02"), 
	FUNC_AZUL_03("AZUL-0003", "CC-AZUL-0003", "30/05/1995", "func03@azul.com.br", 
			"Funcionario Azul 03", "senhaAzul03", "AZUL0789", "funcAzul03"),
	
	FUNC_GOL_01("GOL-0001", "CC-GOL-0001", "02/07/1969", "func01@gol.com.br", 
			"Funcionario Gol 01", "senhaGol01", "GOL0123", "funcGol01"), 
	FUNC_GOL_02("GOL-0002", "CC-GOL-0002", "10/07/1979", "func02@gol.com.br", 
			"Funcionario Gol 02", "senhaGol02", "GOL0456", "funcGol02"), 
	FUNC_GOL_03("GOL-0003", "CC-GOL-0003", "30/07/1989", "func03@gol.com.br", 
			"Funcionario Gol 03", "senhaGol03", "GOL0789", "funcGol03"), 
	
	FUNC_TAM_01("TAM-0001", "CC-TAM-0001", "02/09/1970", "func01@tam.com.br", 
			"Funcionario Tam 01", "senhaTam01", "TAM0123", "funcTam01"), 
	FUNC_TAM_02("TAM-0002", "CC-TAM-0002", "10/09/1980", "func02@tam.com.br", 
			"Funcionario Tam 02", "senhaTam02", "TAM0456", "funcTam02"), 
	FUNC_TAM_03("TAM-0003", "CC-TAM-0003", "30/09/1990", "func03@tam.com.br", 
			"Funcionario Tam 03", "senhaTam03", "TAM0789", "funcTam03"); 
	
	private String codigo, contaCorrente, dataNascimento, email, nome, senha, telefone, usuario;
	
	private FuncionarioEnum(String codigo, String contaCorrente, String dataNascimento, 
			String email, String nome, String senha, String telefone, String usuario) {
		this.codigo = codigo;
		this.contaCorrente = contaCorrente;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.telefone = telefone;
		this.usuario = usuario;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getContaCorrente() {
		return contaCorrente;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getNome() {
		return nome;
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
