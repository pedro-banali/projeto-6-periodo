package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

public class PrimeiraDAO extends BilheteDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static PrimeiraDAO instance = new PrimeiraDAO();
	
	private PrimeiraDAO()
	{
		super();
	}
	public static PrimeiraDAO getInstance() {
		return instance;
	}
}

