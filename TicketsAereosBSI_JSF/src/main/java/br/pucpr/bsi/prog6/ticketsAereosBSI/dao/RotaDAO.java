package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;

public class RotaDAO extends PatternDAO<Rota>{
	private static RotaDAO instance = new RotaDAO();

	private RotaDAO() {
		super(Rota.class);
		// TODO Auto-generated constructor stub
	}
	
	public static RotaDAO getInstance(){
		return instance;
	}

	@Override
	public List<Rota> findByFilter(Rota filter) {
		// TODO Auto-generated method stub
		return null;
	}
}
