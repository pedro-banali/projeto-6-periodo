package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;

public class PapelDAO extends PatternDAO<Papel> {
private final static PapelDAO instance = new PapelDAO();
	
	
	public PapelDAO() {
		super(Papel.class);
		// TODO Auto-generated constructor stub
	}

	public static PapelDAO getInstance() {
		return instance;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Papel> findByFilter(Papel filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
