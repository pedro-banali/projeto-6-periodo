package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.util.HibernateUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Funcionario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Pessoa;

public class FuncionarioDAO extends PessoaDAO {

	@Override
	public List<Pessoa> findByFilter(Pessoa filter) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSession();
		try {
			
			Criteria c = session.createCriteria(Funcionario.class);
			if (StringUtils.isNotBlank(((Funcionario)filter).getCodigo())) {
				c.add(Restrictions.like("codigo", "%" + ((Funcionario)filter).getCodigo() + "%"));
			}
			if (StringUtils.isNotBlank(((Funcionario)filter).getContaCorrente())) {
				c.add(Restrictions.like("contaCorrente", "%" + ((Funcionario)filter).getContaCorrente() + "%"));
			}
			
			return ((List<Pessoa>) c.list());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{ session.close(); }
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static FuncionarioDAO instance = new FuncionarioDAO();
	
	private FuncionarioDAO()
	{
		super();
	}
	public static FuncionarioDAO getInstance() {
		return instance;
	}
}
