package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rota  implements IdentifierInterface, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -165094054573537635L;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;
	private Aeroporto origem;
	private Aeroporto destino;
	private List<Horario> horarios;
	private CiaAerea ciaAerea;
	
	public Rota(CiaAerea ciaAerea, Aeroporto origem, Aeroporto destino)
	{
		this.destino = destino;
		this.origem = origem;
		this.ciaAerea = ciaAerea;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Aeroporto getOrigem() {
		return origem;
	}
	public void setOrigem(Aeroporto origem) {
		this.origem = origem;
	}
	public Aeroporto getDestino() {
		return destino;
	}
	public void setDestino(Aeroporto destino) {
		this.destino = destino;
	}
	public List<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	public CiaAerea getCiaAerea() {
		return ciaAerea;
	}
	public void setCiaAerea(CiaAerea ciaAerea) {
		this.ciaAerea = ciaAerea;
	}
	
	
	
}
