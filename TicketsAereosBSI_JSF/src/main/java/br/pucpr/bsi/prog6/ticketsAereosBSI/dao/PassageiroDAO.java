package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

public class PassageiroDAO extends PessoaDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static PassageiroDAO instance = new PassageiroDAO();
	
	private PassageiroDAO()
	{
		super();
	}
	public static PassageiroDAO getInstance() {
		return instance;
	}
}
