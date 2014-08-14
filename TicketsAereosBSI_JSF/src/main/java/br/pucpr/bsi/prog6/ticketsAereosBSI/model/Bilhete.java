package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;

public abstract class Bilhete implements IdentifierInterface, Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1288350832675933793L;
	
	private long id;
	private int numero;
	private String assento;
	private TipoBilheteEnum tipoBilheteEnum;
	private SituacaoBilheteEnum situacaoBilheteEnum;
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getAssento() {
		return assento;
	}
	public void setAssento(String assento) {
		this.assento = assento;
	}
	public TipoBilheteEnum getTipoBilheteEnum() {
		return tipoBilheteEnum;
	}
	public void setTipoBilheteEnum(TipoBilheteEnum tipoBilheteEnum) {
		this.tipoBilheteEnum = tipoBilheteEnum;
	}
	public SituacaoBilheteEnum getSituacaoBilheteEnum() {
		return situacaoBilheteEnum;
	}
	public void setSituacaoBilheteEnum(SituacaoBilheteEnum situacaoBilheteEnum) {
		this.situacaoBilheteEnum = situacaoBilheteEnum;
	}
	
	
}
