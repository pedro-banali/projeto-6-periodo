package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.util.HibernateUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bagagem;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;

public class EnderecoDAO extends PatternDAO<Endereco> {

	@Override
	public Endereco findById(long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<Endereco> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Long insert(Endereco obj) {
		// TODO Auto-generated method stub
		return super.insert(obj);
	}

	@Override
	public boolean update(Endereco obj) {
		// TODO Auto-generated method stub
		return super.update(obj);
	}

	@Override
	public boolean delete(Endereco obj) {
		// TODO Auto-generated method stub
		return super.delete(obj);
	}

	private static final long serialVersionUID = 1L;
	private final static EnderecoDAO instance = new EnderecoDAO();

	public EnderecoDAO() {
		super(Endereco.class);
	}

	public static EnderecoDAO getInstance() {
		return instance;
	}

	@Override
	public List<Endereco> findByFilter(Endereco filter) {
		
		Session session = HibernateUtil.getSession();
		try {
			Criteria c = session.createCriteria(Bagagem.class);
			
			if (filter.getRua() != null) {
				c.add(Restrictions.like("rua", "%" + filter.getRua() + "%"));
			}
			return ((List<Endereco>) c.list());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {session.close();}
		
	}
}
