package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private int qtdEconomica;
	private int qtdPrimeira;
	private int qtdExecutiva;
	private Rota rota;
	private Aviao aviao;
	private List<Bilhete> bilhetes;
	
	public Horario(Rota rota, Aviao aviao)
	{
		List<Horario> horarios;
		this.rota = rota;
		this.aviao = aviao;
		bilhetes = new ArrayList<Bilhete>();
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
	public List<Bilhete> getExecutivas() {
		List<Bilhete> executivas = new ArrayList<Bilhete>();
		for(int i = 0; i < this.bilhetes.size(); i++)
		{
			if(this.bilhetes.get(i) instanceof Executiva)
				executivas.add(this.bilhetes.get(i));
		}
		return executivas;
	}
	public List<Bilhete> getEconomicas() {
		List<Bilhete> economicas = new ArrayList<Bilhete>();
		for(int i = 0; i < this.bilhetes.size(); i++)
		{
			if(this.bilhetes.get(i) instanceof Economica)
				economicas.add(this.bilhetes.get(i));
		}
		return economicas;
	}
	public List<Bilhete> getPrimeiras() {
		List<Bilhete> primeiras = new ArrayList<Bilhete>();
		for(int i = 0; i < this.bilhetes.size(); i++)
		{
			if(this.bilhetes.get(i) instanceof Primeira)
				primeiras.add(this.bilhetes.get(i));
		}
		return primeiras;
	}

	public List<Bilhete> getBilhetes() {
		return bilhetes;
	}

	public void setBilhetes(List<Bilhete> bilhetes) {
		this.bilhetes = bilhetes;
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
	
	
	
}
