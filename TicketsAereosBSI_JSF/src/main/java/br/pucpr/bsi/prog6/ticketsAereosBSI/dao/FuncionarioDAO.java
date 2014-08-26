package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

public class FuncionarioDAO extends PessoaDAO {

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
