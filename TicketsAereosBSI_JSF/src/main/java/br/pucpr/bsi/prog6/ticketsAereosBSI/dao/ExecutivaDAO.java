package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;

public class ExecutivaDAO extends BilheteDAO {


	private static final long serialVersionUID = 1L;
	
	private final static ExecutivaDAO instance = new ExecutivaDAO();
	
	private ExecutivaDAO()
	{
		super();
	}
	public static ExecutivaDAO getInstance() {
		return instance;
	}
	@Override
	public List<String> findAssentosDisponiveis(Long idHorario) {
		// TODO Auto-generated method stub
		return null;
	}
}
