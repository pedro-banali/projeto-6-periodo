package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CiaAerea implements IdentifierInterface, Serializable {
 
	private static final long serialVersionUID = 4810696674439654676L;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@OneToMany(mappedBy="ciaAerea", fetch=FetchType.LAZY)
	private List<Aviao> avioes;
	@OneToMany(mappedBy="ciaAerea", fetch=FetchType.LAZY)
	private List<Papel> papeis;
	@OneToMany(mappedBy="ciaAerea", fetch=FetchType.LAZY)
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

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CiaAerea other = (CiaAerea) obj;
		if (avioes == null) {
			if (other.avioes != null)
				return false;
		} else if (!avioes.equals(other.avioes))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (papeis == null) {
			if (other.papeis != null)
				return false;
		} else if (!papeis.equals(other.papeis))
			return false;
		if (rotas == null) {
			if (other.rotas != null)
				return false;
		} else if (!rotas.equals(other.rotas))
			return false;
		return true;
	}
	
	
	
	
}
 
