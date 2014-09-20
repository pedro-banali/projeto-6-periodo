package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBagagemEnum;

@Entity
 
public class Bagagem implements IdentifierInterface, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1548664053401217429L;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	
	private Long id;
	private double peso;
	@Column(name="tipo")
	private TipoBagagemEnum tipoBagagem;
	
	@ManyToOne
	@JoinColumn(name="id_bilhete")
	private Bilhete bilhete;
	
	@SuppressWarnings("unused")
	private Bagagem()
	{}
	
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

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bagagem other = (Bagagem) obj;
		if (bilhete == null) {
			if (other.bilhete != null)
				return false;
		} else if (!bilhete.equals(other.bilhete))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(peso) != Double
				.doubleToLongBits(other.peso))
			return false;
		if (tipoBagagem != other.tipoBagagem)
			return false;
		return true;
	}
	
	
	
}
