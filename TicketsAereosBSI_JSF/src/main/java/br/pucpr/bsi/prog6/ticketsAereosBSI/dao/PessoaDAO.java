package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Pessoa;

public class PessoaDAO extends PatternDAO<Pessoa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static PessoaDAO instance = new PessoaDAO();
	
	private PessoaDAO() {
		super(Pessoa.class);
	}
	
	public static PessoaDAO getInstance() {
		return instance;
	}
	
	@Override
	public List<Pessoa> findByFilter(Pessoa filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
