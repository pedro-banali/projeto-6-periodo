package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;

public class PrimeiraDAO extends BilheteDAO {

	private static final long serialVersionUID = 1L;
	
	private final static PrimeiraDAO instance = new PrimeiraDAO();
	
	private PrimeiraDAO()
	{
		super();
	}
	public static PrimeiraDAO getInstance() {
		return instance;
	}
	@Override
	public List<String> findAssentosDisponiveis(Long idHorario) {
		// TODO Auto-generated method stub
		return null;
	}
}

