package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario extends Pessoa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2437913993872236059L;
	private String codigo;
	private String contaCorrente;
	
	@ManyToOne
	@JoinColumn(name="id_papel")
	private Papel papel;
	
	@SuppressWarnings("unused")
	private Funcionario()
	{
		super();
	}
			
	public Funcionario(Endereco endereco, Papel papel)
	{
		super(endereco);
		List<Funcionario> funcionarios;
		this.papel = papel;
		
		funcionarios = this.papel.getFuncionarios();
		
		if(funcionarios == null)
			funcionarios = new ArrayList<Funcionario>();
		
		funcionarios.add(this);
		
		this.papel.setFuncionarios(funcionarios);
		
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	public Papel getPapel() {
		return papel;
	}
	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	@Override
	public String toString() {
		return "Funcionario ["
				+ (codigo != null ? "codigo=" + codigo + ", " : "")
				+ (contaCorrente != null ? "contaCorrente=" + contaCorrente
						+ ", " : "") + "]";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (contaCorrente == null) {
			if (other.contaCorrente != null)
				return false;
		} else if (!contaCorrente.equals(other.contaCorrente))
			return false;
		if (papel == null) {
			if (other.papel != null)
				return false;
		} else if (!papel.equals(other.papel))
			return false;
		return true;
	}
	
	
}
