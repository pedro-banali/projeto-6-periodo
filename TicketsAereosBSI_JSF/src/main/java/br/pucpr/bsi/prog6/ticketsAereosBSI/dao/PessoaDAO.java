package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Pessoa;

public abstract class  PessoaDAO extends PatternDAO<Pessoa> {

	@Override
	public Pessoa findById(long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<Pessoa> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Long insert(Pessoa obj) {
		// TODO Auto-generated method stub
		return super.insert(obj);
	}

	@Override
	public boolean update(Pessoa obj) {
		// TODO Auto-generated method stub
		return super.update(obj);
	}

	@Override
	public boolean delete(Pessoa obj) {
		// TODO Auto-generated method stub
		return super.delete(obj);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PessoaDAO() {
		super(Pessoa.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Pessoa> findByFilter(Pessoa filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
