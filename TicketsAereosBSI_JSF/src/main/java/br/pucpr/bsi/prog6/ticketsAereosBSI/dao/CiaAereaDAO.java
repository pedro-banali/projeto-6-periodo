package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.util.HibernateUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;

public class CiaAereaDAO extends PatternDAO<CiaAerea> {

	private static final long serialVersionUID = 1L;
	private final static CiaAereaDAO instance = new CiaAereaDAO();

	private CiaAereaDAO() {
		super(CiaAerea.class);
	}

	public static CiaAereaDAO getInstance() {
		return instance;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CiaAerea> findByFilter(CiaAerea filter) {
		try {
			Session session = HibernateUtil.getSession();
			Criteria c = session.createCriteria(CiaAerea.class);
			if (StringUtils.isNotBlank(filter.getNome())) {
				c.add(Restrictions.like("nome", "%" + filter.getNome() + "%"));
			}
			return c.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
