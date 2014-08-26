package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;

public abstract class  BilheteDAO extends PatternDAO<Bilhete> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BilheteDAO() {
		super(Bilhete.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Bilhete> findByFilter(Bilhete filter) {
		// TODO Auto-generated method stub
		return null;
	}

}