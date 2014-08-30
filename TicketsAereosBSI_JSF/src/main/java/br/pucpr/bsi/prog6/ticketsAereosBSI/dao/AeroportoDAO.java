package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;

public class AeroportoDAO extends PatternDAO<Aeroporto> {
	
	@Override
	public Aeroporto findById(long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<Aeroporto> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Long insert(Aeroporto obj) {
		// TODO Auto-generated method stub
		return super.insert(obj);
	}

	@Override
	public boolean update(Aeroporto obj) {
		// TODO Auto-generated method stub
		return super.update(obj);
	}

	@Override
	public boolean delete(Aeroporto obj) {
		// TODO Auto-generated method stub
		return super.delete(obj);
	}
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