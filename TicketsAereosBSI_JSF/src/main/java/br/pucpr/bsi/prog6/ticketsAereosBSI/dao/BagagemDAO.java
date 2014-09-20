package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.util.HibernateUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bagagem;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Horario;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Bagagem> findByFilter(Bagagem filter) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			Criteria c = session.createCriteria(Bagagem.class);
			Criteria ca = c.createCriteria(Horario.class);
			if (filter.getTipoBagagemEnum() != null) {
				c.add(Restrictions.like("tipo", "%" + filter.getTipoBagagemEnum() + "%"));
			}
			if (filter.getPeso() <= 0) {
				c.add(Restrictions.like("peso", "%" + filter.getPeso() + "%"));
			}
			return ((List<Bagagem>) c.list());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {session.close();}
	}

}