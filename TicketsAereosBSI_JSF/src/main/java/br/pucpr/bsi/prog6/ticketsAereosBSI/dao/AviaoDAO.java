package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.util.HibernateUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;

public class AviaoDAO extends PatternDAO<Aviao> {
	
	private static final long serialVersionUID = 1L;
	private final static AviaoDAO instance = new AviaoDAO();

	public AviaoDAO() {
		super(Aviao.class);
		// TODO Auto-generated constructor stub
	}

	public static AviaoDAO getInstance() {
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Aviao> findByFilter(Aviao filter) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			
			Criteria c = session.createCriteria(Aviao.class);
			if (StringUtils.isNotBlank(filter.getCodigo())) {
				c.add(Restrictions.like("codigo", "%" + filter.getCodigo() + "%"));
			}
			if(filter.getCarga() > 0)
			{
				c.add(Restrictions.like("carga", "%" + filter.getCarga() + "%"));
			}
			
			return ((List<Aviao>) c.list());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{ session.close(); }
	}

	@Override
	public Aviao findById(long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<Aviao> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Long insert(Aviao obj) {
		// TODO Auto-generated method stub
		return super.insert(obj);
	}

	@Override
	public boolean update(Aviao obj) {
		// TODO Auto-generated method stub
		return super.update(obj);
	}

	@Override
	public boolean delete(Aviao obj) {
		// TODO Auto-generated method stub
		return super.delete(obj);
	}

}
