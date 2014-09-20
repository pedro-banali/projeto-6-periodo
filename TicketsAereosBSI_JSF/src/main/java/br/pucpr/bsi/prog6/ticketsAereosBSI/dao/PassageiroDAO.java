package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.util.HibernateUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Pessoa;


public class PassageiroDAO extends PessoaDAO<Passageiro> {
	
	@Override
	public Passageiro findById(long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}
	@Override
	public List<Passageiro> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}
	@Override
	public Long insert(Passageiro obj) {
		// TODO Auto-generated method stub
		return super.insert(obj);
	}
	@Override
	public boolean update(Passageiro obj) {
		// TODO Auto-generated method stub
		return super.update(obj);
	}
	@Override
	public boolean delete(Passageiro obj) {
		// TODO Auto-generated method stub
		return super.delete(obj);
	}
	@Override
	public List<Passageiro> findByFilter(Passageiro filter) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			
			Criteria c = session.createCriteria(Passageiro.class);
			if (StringUtils.isNotBlank(filter.getDocumento())) {
				c.add(Restrictions.like("documento", "%" + filter.getDocumento() + "%"));
			}
			if(StringUtils.isNotBlank(filter.getNumeroCartao()))
			{
				c.add(Restrictions.like("numeroCartao", "%" + filter.getNumeroCartao() + "%"));
			}
			
			return ((List<Passageiro>) c.list());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{ session.close(); }
	}
	private static final long serialVersionUID = 1L;
	
	private final static PassageiroDAO instance = new PassageiroDAO();
	
	private PassageiroDAO()
	{
		super();
	}
	public static PassageiroDAO getInstance() {
		return instance;
	}
}
