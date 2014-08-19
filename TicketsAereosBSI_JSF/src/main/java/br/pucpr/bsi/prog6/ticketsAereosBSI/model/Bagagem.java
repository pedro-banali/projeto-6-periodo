package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	private Bilhete bilhete;
	
	public Bagagem (TipoBagagemEnum tipoBagagemEnum, Bilhete bilhete)
	{
		List<Bagagem> bagagens;
		this.tipoBagagem = tipoBagagemEnum;
		this.bilhete = bilhete;
		
		bagagens = this.bilhete.getBagagens();
		
		if(bagagens == null)
			bagagens = new ArrayList<Bagagem>();
		
		bagagens.add(this);
		
		this.bilhete.setBagagens(bagagens);
	}
	
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
	public TipoBagagemEnum getTipoBagagemEnum() {
		return tipoBagagem;
	}
	public void setTipoBagagemEnum(TipoBagagemEnum tipoBagagem) {
		this.tipoBagagem = tipoBagagem;
	}
	public Bilhete getBilhete() {
		return bilhete;
	}
	public void setBilhete(Bilhete bilhete) {
		this.bilhete = bilhete;
	}

	@Override
	public String toString() {
		return "Bagagem [id="
				+ id
				+ ", peso="
				+ peso
				+  "]";
	}
	
	
}
