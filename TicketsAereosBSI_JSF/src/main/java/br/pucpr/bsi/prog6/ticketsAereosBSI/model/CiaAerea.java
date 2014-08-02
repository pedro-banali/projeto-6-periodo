package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;

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
	
	public CiaAerea() {
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
	
	@Override
	public String toString() {
		return "CiaAerea  [id=" + id + ", nome=" + nome + "]" ;
	}
	
	
}
 
