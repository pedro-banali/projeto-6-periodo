package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.util.HibernateUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;

public class PapelDAO extends PatternDAO<Papel> {
	
	private static final long serialVersionUID = 1L;
	private final static PapelDAO instance = new PapelDAO();

	public PapelDAO() {
		super(Papel.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Papel findById(long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<Papel> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Long insert(Papel obj) {
		// TODO Auto-generated method stub
		return super.insert(obj);
	}

	@Override
	public boolean update(Papel obj) {
		// TODO Auto-generated method stub
		return super.update(obj);
	}

	@Override
	public boolean delete(Papel obj) {
		// TODO Auto-generated method stub
		return super.delete(obj);
	}

	public static PapelDAO getInstance() {
		return instance;
	}
	@Override
	public List<Papel> findByFilter(Papel filter) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			
			session = HibernateUtil.getSession();
			Criteria c = session.createCriteria(Papel.class);
			if (StringUtils.isNotBlank(filter.getNome())) {
				c.add(Restrictions.like("nome", "%" + filter.getNome() + "%"));
			}
			if (StringUtils.isNotBlank(filter.getDescricao())) {
				c.add(Restrictions.like("descricao", "%" + filter.getDescricao() + "%"));
			}
			if (StringUtils.isNotBlank(filter.getCiaAerea().getNome())) {
				c.createAlias("ciaAerea", "ciaAerea");
				c.add(Restrictions.like("ciaAerea.nome", "%" + filter.getCiaAerea().getNome() + "%"));
			}
			return ((List<Papel>)c.list());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
//			if(session != null)
//				session.close();
		}
	}

}