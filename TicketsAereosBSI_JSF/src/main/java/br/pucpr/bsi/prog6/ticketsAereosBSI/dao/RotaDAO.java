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
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			
			Criteria c = session.createCriteria(Passageiro.class);
			c.createAlias("endereco", "endereco");
			if (StringUtils.isNotBlank(filter.getNome())) {
				c.add(Restrictions.like("nome", "%" + filter.getNome() + "%"));
			}
			if(StringUtils.isNotBlank(filter.getDescricao()))
			{
				c.add(Restrictions.like("descricao", "%" + filter.getDescricao() + "%"));
			}
			if(StringUtils.isNotBlank(filter.getDestino().getNome()))
			{
				c.createAlias("destino", "destino");
				c.add(Restrictions.like("destino.nome", "%" + filter.getDestino().getNome() + "%"));
			}
			if(StringUtils.isNotBlank(filter.getOrigem().getNome()))
			{
				c.createAlias("origem", "origem");
				c.add(Restrictions.like("origem.nome", "%" + filter.getOrigem().getNome() + "%"));
			}
			if(StringUtils.isNotBlank(filter.getDestino().getEndereco().getCidade()))
			{
				c.createAlias("destino", "destino");
				c.createAlias("destino.endereco", "dEndereco");
				c.add(Restrictions.like("dEndereco.cidade", "%" + filter.getDestino().getEndereco().getCidade() + "%"));
			}
			if(StringUtils.isNotBlank(filter.getOrigem().getNome()))
			{
				c.createAlias("origem", "origem");
				c.createAlias("origem.endereco", "oEndereco");
				c.add(Restrictions.like("oEndereco.cidade", "%" + filter.getOrigem().getEndereco().getCidade() + "%"));
			}
			
			return ((List<Rota>) c.list());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{ session.close(); }
	}
}
