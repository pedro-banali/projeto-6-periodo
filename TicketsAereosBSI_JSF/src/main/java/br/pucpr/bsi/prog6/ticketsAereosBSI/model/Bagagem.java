package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBagagemEnum;

@Entity
public class Bagagem implements IdentifierInterface, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1548664053401217429L;
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	
	private long id;
	private double peso;
	private TipoBagagemEnum tipoBagagem;
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public TipoBagagemEnum getTipoBagagem() {
		return tipoBagagem;
	}
	public void setTipoBagagem(TipoBagagemEnum tipoBagagem) {
		this.tipoBagagem = tipoBagagem;
	}
	
	
}
