package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class CiaAerea implements IdentifierInterface, Serializable {
 
	private static final long serialVersionUID = 4810696674439654676L;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="ciaAerea", fetch=FetchType.LAZY)
	private List<Aviao> avioes;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="ciaAerea", fetch=FetchType.LAZY)
	private List<Papel> papeis;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="ciaAerea", fetch=FetchType.LAZY)
	private List<Rota> rotas;
	
	public CiaAerea() {
		avioes = new ArrayList<Aviao>();
		papeis = new ArrayList<Papel>();
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

	

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj.getClass()!= getClass())
			return false;
		if (((IdentifierInterface)obj).getId() != id)
			return false;		
		return true;
	}
	
	
	
	
}
 
