package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;

public class AeroportoDAO extends PatternDAO<Aeroporto> {
	
	private static final long serialVersionUID = 1L;
	private final static AeroportoDAO instance = new AeroportoDAO();

	public AeroportoDAO() {
		super(Aeroporto.class);
		// TODO Auto-generated constructor stub
	}

	public static AeroportoDAO getInstance() {
		return instance;
	}
	@Override
	public List<Aeroporto> findByFilter(Aeroporto filter) {
		// TODO Auto-generated method stub
		return null;
	}

}