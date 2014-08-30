package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;

public class PrimeiraDAO extends BilheteDAO {

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
	@Override
	public List<Bilhete> findByFilter(Bilhete filter) {
		// TODO Auto-generated method stub
		return super.findByFilter(filter);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static PrimeiraDAO instance = new PrimeiraDAO();
	
	private PrimeiraDAO()
	{
		super();
	}
	public static PrimeiraDAO getInstance() {
		return instance;
	}
}

