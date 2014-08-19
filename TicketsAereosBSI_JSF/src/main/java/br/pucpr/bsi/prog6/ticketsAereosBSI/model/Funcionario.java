package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2437913993872236059L;
	private String codigo;
	private String contaCorrente;
	private Papel papel;
			
	public Funcionario(Endereco endereco, Papel papel)
	{
		super(endereco);
		List<Funcionario> funcionarios;
		this.papel = papel;
		
		funcionarios = this.papel.getFuncionarios();
		
		if(funcionarios == null)
			funcionarios = new ArrayList<Funcionario>();
		
		funcionarios.add(this);
		
		this.papel.setFuncionarios(funcionarios);
		
	}
	
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
	public Papel getPapel() {
		return papel;
	}
	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	@Override
	public String toString() {
		return "Funcionario ["
				+ (codigo != null ? "codigo=" + codigo + ", " : "")
				+ (contaCorrente != null ? "contaCorrente=" + contaCorrente
						+ ", " : "") + (papel != null ? "papel=" + papel : "")
				+ "]";
	}
	
	
}
