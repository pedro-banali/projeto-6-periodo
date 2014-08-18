package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private List<Funcionario> funcionarios;
	private CiaAerea ciaAerea;
	
	public Papel(CiaAerea ciaAerea)
	{
		List<Papel> papeis;
		this.ciaAerea = ciaAerea;
		papeis = this.ciaAerea.getPapeis();
		
		if(papeis == null)
			papeis = new ArrayList<Papel>();
		
		papeis.add(this);
		
		this.ciaAerea.setPapeis(papeis);
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
	public void setCiaAerea(CiaAerea ciaAerea) {
		this.ciaAerea = ciaAerea;
	}
	
	
}
