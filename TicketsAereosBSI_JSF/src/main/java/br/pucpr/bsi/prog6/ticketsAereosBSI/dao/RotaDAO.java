package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.util.HibernateUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;

public class RotaDAO extends PatternDAO<Rota>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2997507448312008422L;
	private static RotaDAO instance = new RotaDAO();

	private RotaDAO() {
		super(Rota.class);
		// TODO Auto-generated constructor stub
	}
	
	public static RotaDAO getInstance(){
		return instance;
	}

	@Override
	public List<Rota> findByFilter(Rota filter) {
		Session session = HibernateUtil.getSession();
		try {

			Criteria c = session.createCriteria(Rota.class);
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
			if (StringUtils.isNotBlank(filter.getOrigem().getEndereco().getCidade())) {
				c.createAlias("origem", "aeroportoO");
				c.createAlias("aeroportoO.endereco", "enderecoO");
				c.add(Restrictions.like("enderecoO.cidade", "%"+ filter.getOrigem().getEndereco().getCidade() + "%"));
			}
			if (StringUtils.isNotBlank(filter.getDestino().getEndereco().getCidade())) {
				c.createAlias("destino", "aeroportoD");
				c.createAlias("aeroportoD.endereco", "enderecoD");
				c.add(Restrictions.like("enderecoD.cidade", "%"+ filter.getDestino().getEndereco().getCidade() + "%"));
			}
			if (StringUtils.isNotBlank(filter.getDestino().getNome())) {
				c.createAlias("destino", "aeroportoD");
				c.add(Restrictions.like("aeroportoD.nome", "%"+ filter.getDestino().getNome() + "%"));
			}
			if (StringUtils.isNotBlank(filter.getOrigem().getNome())) {
				c.createAlias("origem", "aeroportoO");
				c.add(Restrictions.like("aeroportoO.nome", "%"+ filter.getOrigem().getNome() + "%"));
			}
			return ((List<Rota>) c.list());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
}
