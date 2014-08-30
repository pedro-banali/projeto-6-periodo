package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;

public abstract class  BilheteDAO extends PatternDAO<Bilhete> {

	@Override
	public Bilhete findById(long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<Bilhete> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Long insert(Bilhete obj) {
		// TODO Auto-generated method stub
		return super.insert(obj);
	}

	@Override
	public boolean update(Bilhete obj) {
		// TODO Auto-generated method stub
		return super.update(obj);
	}

	@Override
	public boolean delete(Bilhete obj) {
		// TODO Auto-generated method stub
		return super.delete(obj);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BilheteDAO() {
		super(Bilhete.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Bilhete> findByFilter(Bilhete filter) {
		// TODO Auto-generated method stub
		return null;
	}

}