package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CiaAerea implements IdentifierInterface, Serializable {
 
	private static final long serialVersionUID = 4810696674439654676L;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private List<Aviao> avioes;
	private List<Papel> papeis;
	private List<Rota> rotas;
	
	public CiaAerea() {
		avioes = new ArrayList<Aviao>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public List<Aviao> getAvioes() {
		return avioes;
	}

	public void setAvioes(List<Aviao> avioes) {
		this.avioes = avioes;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}

	public List<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(List<Rota> rotas) {
		this.rotas = rotas;
	}

	@Override
	public String toString() {
		return "CiaAerea [" + (id != null ? "id=" + id + ", " : "")
				+ (nome != null ? "nome=" + nome + ", " : "") + "]";
	}
	
	
	
	
}
 
