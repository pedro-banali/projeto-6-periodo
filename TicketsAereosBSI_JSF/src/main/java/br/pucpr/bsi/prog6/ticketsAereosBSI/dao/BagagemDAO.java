package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bagagem;

public class BagagemDAO extends PatternDAO<Bagagem> {
	
	private static final long serialVersionUID = 1L;
	private final static BagagemDAO instance = new BagagemDAO();

	public BagagemDAO() {
		super(Bagagem.class);
		// TODO Auto-generated constructor stub
	}

	public static BagagemDAO getInstance() {
		return instance;
	}
	@Override
	public Bagagem findById(long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<Bagagem> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Long insert(Bagagem obj) {
		// TODO Auto-generated method stub
		return super.insert(obj);
	}

	@Override
	public boolean update(Bagagem obj) {
		// TODO Auto-generated method stub
		return super.update(obj);
	}

	@Override
	public boolean delete(Bagagem obj) {
		// TODO Auto-generated method stub
		return super.delete(obj);
	}

	@Override
	public List<Bagagem> findByFilter(Bagagem filter) {
		// TODO Auto-generated method stub
		return null;
	}

}