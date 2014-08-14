package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Aviao  implements IdentifierInterface, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8098161633398123820L;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	
	private long id;
	private String codigo;
	private double carga;
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getCarga() {
		return carga;
	}
	public void setCarga(double carga) {
		this.carga = carga;
	}
	
	
}
