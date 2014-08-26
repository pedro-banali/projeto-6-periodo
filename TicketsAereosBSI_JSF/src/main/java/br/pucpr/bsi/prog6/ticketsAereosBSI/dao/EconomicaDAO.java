package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

public class EconomicaDAO extends BilheteDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static EconomicaDAO instance = new EconomicaDAO();
	
	private EconomicaDAO()
	{
		super();
	}
	public static EconomicaDAO getInstance() {
		return instance;
	}
}
