package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.util.List;

public class Passageiro extends Pessoa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5323481036344324077L;
	private String numeroCartao;
	private String documento;
	private List<Bilhete> bilhetes;
	
	public Passageiro(Endereco endereco)
	{
		super(endereco);
	}
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public List<Bilhete> getBilhetes() {
		return bilhetes;
	}
	public void setBilhetes(List<Bilhete> bilhetes) {
		this.bilhetes = bilhetes;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "Passageiro ["
				+ (numeroCartao != null ? "numeroCartao=" + numeroCartao + ", "
						: "")
				+ (documento != null ? "documento=" + documento + ", " : "")
				+ (bilhetes != null ? "bilhetes=" + bilhetes : "") + "]";
	}
	
	
	
}
