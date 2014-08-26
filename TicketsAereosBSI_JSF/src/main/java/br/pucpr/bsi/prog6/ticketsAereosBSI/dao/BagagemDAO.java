package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bagagem;

public class BagagemDAO extends PatternDAO<Bagagem> {
	
	private static final long serialVersionUID = 1L;
	private final static AviaoDAO instance = new AviaoDAO();

	public BagagemDAO() {
		super(Bagagem.class);
		// TODO Auto-generated constructor stub
	}

	public static AviaoDAO getInstance() {
		return instance;
	}
	@Override
	public List<Bagagem> findByFilter(Bagagem filter) {
		// TODO Auto-generated method stub
		return null;
	}

}