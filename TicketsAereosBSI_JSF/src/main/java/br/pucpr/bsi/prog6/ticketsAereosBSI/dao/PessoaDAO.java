package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Funcionario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Pessoa;

public abstract class  PessoaDAO <T extends Pessoa> extends PatternDAO<T> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PessoaDAO(Class entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

}
