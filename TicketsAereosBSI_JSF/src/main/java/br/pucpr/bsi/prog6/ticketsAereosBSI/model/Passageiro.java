package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Passageiro extends Pessoa{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2426758354030168231L;
	private String numeroCartao;
	private String documento;
	
	
	@OneToMany(mappedBy="passageiro", fetch = FetchType.LAZY)
	private List<Bilhete> bilhetes;
	
	public Passageiro(Endereco end) {
		super(end);
		bilhetes = new ArrayList<Bilhete>();
	}
	
	public Passageiro() {}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public List<Bilhete> getBilhetes() {
		return bilhetes;
	}

	public void setBilhetes(List<Bilhete> bilhetes) {
		this.bilhetes = bilhetes;
	}
	
	@Override
	public String toString() {
		return "Passageiro ["
				+ (numeroCartao != null ? "numeroCartao=" + numeroCartao + ", "
						: "")
				+ (documento != null ? "documento=" + documento + ", " : "") + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((documento == null) ? 0 : documento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passageiro other = (Passageiro) obj;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "Passageiro [numeroCartao=" + numeroCartao + ", documento="
//				+ documento + "]";
//	}		
	
/*	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passageiro other = (Passageiro) obj;
		if (bilhetes == null) {
			if (other.bilhetes != null)
				return false;
		} else if (!bilhetes.equals(other.bilhetes))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (numeroCartao == null) {
			if (other.numeroCartao != null)
				return false;
		} else if (!numeroCartao.equals(other.numeroCartao))
			return false;
		return true;
	}*/
}
