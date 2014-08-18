package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

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
		this.papel = papel;
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
	
	
}
