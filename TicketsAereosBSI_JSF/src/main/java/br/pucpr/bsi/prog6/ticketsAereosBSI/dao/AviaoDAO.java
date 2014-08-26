package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;

public class AviaoDAO extends PatternDAO<Aviao> {
	
	private static final long serialVersionUID = 1L;
	private final static AviaoDAO instance = new AviaoDAO();

	public AviaoDAO() {
		super(Aviao.class);
		// TODO Auto-generated constructor stub
	}

	public static AviaoDAO getInstance() {
		return instance;
	}
	@Override
	public List<Aviao> findByFilter(Aviao filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
