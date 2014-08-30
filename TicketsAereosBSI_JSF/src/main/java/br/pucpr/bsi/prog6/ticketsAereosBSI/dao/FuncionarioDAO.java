package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Pessoa;

public class FuncionarioDAO extends PessoaDAO {

	@Override
	public List<Pessoa> findByFilter(Pessoa filter) {
		// TODO Auto-generated method stub
		return super.findByFilter(filter);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static FuncionarioDAO instance = new FuncionarioDAO();
	
	private FuncionarioDAO()
	{
		super();
	}
	public static FuncionarioDAO getInstance() {
		return instance;
	}
}
