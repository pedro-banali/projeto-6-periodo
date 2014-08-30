package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

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
	@Transient
	private Aeroporto origem;
	@Transient
	private Aeroporto destino;
	@Transient
	private List<Horario> horarios;
	@ManyToOne
	@JoinColumn(name="id_ciaaerea")
	private CiaAerea ciaAerea;
	
	public Rota(CiaAerea ciaAerea, Aeroporto origem, Aeroporto destino)
	{
		List<Rota> rotas;
		this.destino = destino;
		this.origem = origem;
		this.ciaAerea = ciaAerea;
		
		rotas = ciaAerea.getRotas();
		
		if(rotas == null)
			rotas = new ArrayList<Rota>();
		
		rotas.add(this);
		
		this.ciaAerea.setRotas(rotas);
		
		
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

	@Override
	public String toString() {
		return "Rota [id=" + id + ", "
				+ (nome != null ? "nome=" + nome + ", " : "")
				+ (descricao != null ? "descricao=" + descricao + ", " : "")
				+ (origem != null ? "origem=" + origem + ", " : "")
				+ (destino != null ? "destino=" + destino + ", " : "") + "]";
	}
	
	
	
}
