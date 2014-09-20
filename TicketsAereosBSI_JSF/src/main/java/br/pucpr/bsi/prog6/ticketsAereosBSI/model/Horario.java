package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

@Entity
public class Horario  implements IdentifierInterface, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3371437216184129924L;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	
	private long id;
	private Date partida;
	private Date chegada;
	private String codigo;
	
	@Column(name="qtd_economica")
	private int qtdEconomica;
	
	@Column(name="qtd_primeira")
	private int qtdPrimeira;
	
	@Column(name="qtd_executiva")
	private int qtdExecutiva;
	
	@ManyToOne
	@JoinColumn(name="id_rota")
	private Rota rota;
	
	@ManyToOne
	@JoinColumn(name="id_aviao")
	private Aviao aviao;
	
	@OneToMany(cascade={CascadeType.PERSIST})
	@JoinColumn(name="ID_HORARIO", updatable=false)
	@Where(clause="tipo='EXECUTIVA'")
	private List<Executiva>executivas;
	
	@OneToMany(cascade={CascadeType.PERSIST})
	@JoinColumn(name="ID_HORARIO", updatable=false)
	@Where(clause="tipo='ECONOMICA'")
	private List<Economica>economicas;

	
	@OneToMany(cascade={CascadeType.PERSIST})
	@JoinColumn(name="ID_HORARIO", updatable=false)
	@Where(clause="tipo='PRIMEIRA'")
	private List<Primeira>primeiras;

	
	@SuppressWarnings("unused")
	private Horario()
	{}
	
	public Horario(Rota rota, Aviao aviao)
	{
		List<Horario> horarios;
		this.rota = rota;
		this.aviao = aviao;
		
		primeiras = new ArrayList<Primeira>();
		executivas = new ArrayList<Executiva>();
		economicas = new ArrayList<Economica>();
		
		horarios = this.rota.getHorarios();
		
		if(horarios == null)
			horarios = new ArrayList<Horario>();
		
		horarios.add(this);
		
		this.rota.setHorarios(horarios);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getPartida() {
		return partida;
	}
	public void setPartida(Date partida) {
		this.partida = partida;
	}
	public Date getChegada() {
		return chegada;
	}
	public void setChegada(Date chegada) {
		this.chegada = chegada;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getQtdEconomica() {
		return qtdEconomica;
	}
	public void setQtdEconomica(int qtdEconomica) {
		this.qtdEconomica = qtdEconomica;
	}
	public int getQtdPrimeira() {
		return qtdPrimeira;
	}
	public void setQtdPrimeira(int qtdPrimeira) {
		this.qtdPrimeira = qtdPrimeira;
	}
	public int getQtdExecutiva() {
		return qtdExecutiva;
	}
	public void setQtdExecutiva(int qtdExecutiva) {
		this.qtdExecutiva = qtdExecutiva;
	}
	public Rota getRota() {
		return rota;
	}
	public void setRota(Rota rota) {
		this.rota = rota;
	}
	public Aviao getAviao() {
		return aviao;
	}
	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}
	public List<Executiva> getExecutivas() {
		return executivas;
	}
	public List<Economica> getEconomicas() {
		return economicas;
	}
	public List<Primeira> getPrimeiras() {
		return primeiras;
	}



	public void setExecutivas(List<Executiva> executivas) {
		this.executivas = executivas;
	}

	public void setEconomicas(List<Economica> economicas) {
		this.economicas = economicas;
	}

	public void setPrimeiras(List<Primeira> primeiras) {
		this.primeiras = primeiras;
	}

	@Override
	public String toString() {
		return "Horario [id=" + id + ", "
				+ (partida != null ? "partida=" + partida + ", " : "")
				+ (chegada != null ? "chegada=" + chegada + ", " : "")
				+ (codigo != null ? "codigo=" + codigo + ", " : "")
				+ "qtdEconomica=" + qtdEconomica + ", qtdPrimeira="
				+ qtdPrimeira + ", qtdExecutiva=" + qtdExecutiva +  "]";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horario other = (Horario) obj;
		if (aviao == null) {
			if (other.aviao != null)
				return false;
		} else if (!aviao.equals(other.aviao))
			return false;
		if (chegada == null) {
			if (other.chegada != null)
				return false;
		} else if (!chegada.equals(other.chegada))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (economicas == null) {
			if (other.economicas != null)
				return false;
		} else if (!economicas.equals(other.economicas))
			return false;
		if (executivas == null) {
			if (other.executivas != null)
				return false;
		} else if (!executivas.equals(other.executivas))
			return false;
		if (id != other.id)
			return false;
		if (partida == null) {
			if (other.partida != null)
				return false;
		} else if (!partida.equals(other.partida))
			return false;
		if (primeiras == null) {
			if (other.primeiras != null)
				return false;
		} else if (!primeiras.equals(other.primeiras))
			return false;
		if (qtdEconomica != other.qtdEconomica)
			return false;
		if (qtdExecutiva != other.qtdExecutiva)
			return false;
		if (qtdPrimeira != other.qtdPrimeira)
			return false;
		if (rota == null) {
			if (other.rota != null)
				return false;
		} else if (!rota.equals(other.rota))
			return false;
		return true;
	}
	
	
	
	
}
