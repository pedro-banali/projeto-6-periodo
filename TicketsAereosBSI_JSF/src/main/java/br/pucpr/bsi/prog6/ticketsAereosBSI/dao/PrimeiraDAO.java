package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.util.HibernateUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Primeira;

public class PrimeiraDAO extends BilheteDAO<Primeira> {

	private static final long serialVersionUID = 1L;
	private final static PrimeiraDAO instance = new PrimeiraDAO();

	private PrimeiraDAO() {
		super(Primeira.class);
	}
	
	public static PrimeiraDAO getInstance() {
		return instance;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Primeira> findAll() {
		Session session = HibernateUtil.getSession();
		try {
			Query listQuery = session
					.createQuery("FROM Bilhete b "
							+ "WHERE b.tipoBilhete = :tipo");

			listQuery.setParameter("tipo", TipoBilheteEnum.PRIMEIRA);
			return listQuery.list();
		} catch (Exception e) {
			throw new TicketsAereosBSIException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<String> findAssentosDisponiveis(Long idHorario) {
		Session session = HibernateUtil.getSession();
		try {
			Query q = session
					.createQuery("SELECT b FROM Bilhete b JOIN b.horario h "
							+ "WHERE h.id = :id " + "AND b.tipoBilhete = :tipo "
							+ "AND b.situacaoBilhete = :situacao");
			q.setParameter("id", idHorario);
			q.setParameter("tipo", TipoBilheteEnum.PRIMEIRA);
			q.setParameter("situacao", SituacaoBilheteEnum.DISPONIVEL);

			@SuppressWarnings("unchecked")
			List<Bilhete> bilhetes = (List<Bilhete>)q.list();
			List<String> ho = new ArrayList<String>();

			for (int i = 0; i < bilhetes.size(); i++) {
				Bilhete hue = bilhetes.get(i);
				String vaiPraLaVemPraCa = "PR" + hue.getNumero();
				ho.add(vaiPraLaVemPraCa);
			}

			return ho;
		} finally {
			session.close();
		}
	}
}
