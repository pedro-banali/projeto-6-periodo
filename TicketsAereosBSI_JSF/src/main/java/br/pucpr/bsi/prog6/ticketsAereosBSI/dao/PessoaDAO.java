package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Pessoa;

public abstract class  PessoaDAO extends PatternDAO<Pessoa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PessoaDAO() {
		super(Pessoa.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Pessoa> findByFilter(Pessoa filter) {
		// TODO Auto-generated method stub
		return null;
	}

}