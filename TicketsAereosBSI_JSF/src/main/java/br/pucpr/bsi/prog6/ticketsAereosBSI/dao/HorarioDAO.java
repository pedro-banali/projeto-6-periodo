package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Horario;

public class HorarioDAO extends PatternDAO<Horario> {
	
	private static final long serialVersionUID = 1L;
	private final static HorarioDAO instance = new HorarioDAO();

	public HorarioDAO() {
		super(Horario.class);
		// TODO Auto-generated constructor stub
	}

	public static HorarioDAO getInstance() {
		return instance;
	}
	@Override
	public List<Horario> findByFilter(Horario filter) {
		// TODO Auto-generated method stub
		return null;
	}

}