package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;

@Entity
public class Papel implements IdentifierInterface, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4150094108190432699L;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	
	private long id;
	private String nome;
	private String descricao;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(targetEntity = Funcionario.class, mappedBy="papel", fetch=FetchType.LAZY)
	private List<Funcionario> funcionarios;
	
	@ManyToOne
	@JoinColumn(name="id_ciaaerea")
	private CiaAerea ciaAerea;
	
	@SuppressWarnings("unused")
	private Papel()
	{
		
	}
	
	public Papel(CiaAerea ciaAerea)
	{
		this.ciaAerea = ciaAerea;
		ciaAerea.getPapeis().add(this);
		funcionarios = new ArrayList<Funcionario>();
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
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public CiaAerea getCiaAerea() {
		return ciaAerea;
	}
	public void setCiaAerea(CiaAerea ciaAerea) throws TicketsAereosBSIException{
		if(ciaAerea == null)
			throw new TicketsAereosBSIException("Cia Aerea");
		
		this.ciaAerea = ciaAerea;
	}

	@Override
	public String toString() {
		return "Papel [id="
				+ id
				+ ", "
				+ (nome != null ? "nome=" + nome + ", " : "")
				+ (descricao != null ? "descricao=" + descricao + ", " : "") + "]";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Papel other = (Papel) obj;
		if (ciaAerea == null) {
			if (other.ciaAerea != null)
				return false;
		} else if (!ciaAerea.equals(other.ciaAerea))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (funcionarios == null) {
			if (other.funcionarios != null)
				return false;
		} else if (!funcionarios.equals(other.funcionarios))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
	
}
