package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	@ManyToOne
	@JoinColumn(name="id_ciaaerea")
	private CiaAerea ciaAerea;
	
	@SuppressWarnings("unused")
	private Aviao()
	{
		
	}
	
	public Aviao(CiaAerea ciaAerea)
	{
		List<Aviao> avioes = ciaAerea.getAvioes();
		
		this.ciaAerea = ciaAerea;
		avioes.add(this);
		
		this.ciaAerea.setAvioes(avioes);
	}
	
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
	public CiaAerea getCiaAerea() {
		return ciaAerea;
	}
	public void setCiaAerea(CiaAerea ciaAerea) {
		this.ciaAerea = ciaAerea;
	}

	@Override
	public String toString() {
		return "Aviao [id=" + id + ", "
				+ (codigo != null ? "codigo=" + codigo + ", " : "") + "carga="
				+ carga + "]";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aviao other = (Aviao) obj;
		if (Double.doubleToLongBits(carga) != Double
				.doubleToLongBits(other.carga))
			return false;
		if (ciaAerea == null) {
			if (other.ciaAerea != null)
				return false;
		} else if (!ciaAerea.equals(other.ciaAerea))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
