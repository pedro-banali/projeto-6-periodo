package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.util.HibernateUtil;

public class EconomicaDAO extends BilheteDAO {

	private static final long serialVersionUID = 1L;
	
	private final static EconomicaDAO instance = new EconomicaDAO();
	
	private EconomicaDAO()
	{
		super();
	}
	public static EconomicaDAO getInstance() {
		return instance;
	}
	
	@Override
	public List<String> findAssentosDisponiveis(Long idHorario) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		 try {
		 Query q = session.createQuery("SELECT e " +
		 " FROM Economica e JOIN e.address a" +
		 "WHERE a.city = :city ");
		 q.setParameter("city", city);
		 return (List<String>) q.list();
		 }finally {
		 session.close();
		}
	}
}
