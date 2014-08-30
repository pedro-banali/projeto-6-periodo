package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Horario;

public class HorarioDAO extends PatternDAO<Horario> {
	
	@Override
	public Horario findById(long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<Horario> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Long insert(Horario obj) {
		// TODO Auto-generated method stub
		return super.insert(obj);
	}

	@Override
	public boolean update(Horario obj) {
		// TODO Auto-generated method stub
		return super.update(obj);
	}

	@Override
	public boolean delete(Horario obj) {
		// TODO Auto-generated method stub
		return super.delete(obj);
	}
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