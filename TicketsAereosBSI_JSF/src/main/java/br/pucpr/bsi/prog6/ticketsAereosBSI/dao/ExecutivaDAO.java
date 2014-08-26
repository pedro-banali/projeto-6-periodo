package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

public class ExecutivaDAO extends BilheteDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static ExecutivaDAO instance = new ExecutivaDAO();
	
	private ExecutivaDAO()
	{
		super();
	}
	public static ExecutivaDAO getInstance() {
		return instance;
	}
}
