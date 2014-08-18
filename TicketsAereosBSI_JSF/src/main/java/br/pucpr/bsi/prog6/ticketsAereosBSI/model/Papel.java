package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
		
		if(nome == null)
			throw new TicketsAereosBSIException("Nome nulo");
		
		String n = nome.trim();
		
		if(n.equals(""))
			throw new TicketsAereosBSIException("Nome Vazio");
		
		this.nome = nome;
		
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		
		if(descricao == null)
			throw new TicketsAereosBSIException("Descricao nula");
		
		String d = descricao.trim();
		
		if(d.equals(""))
			throw new TicketsAereosBSIException("Descricao Vazia");
		
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
	
	
}
