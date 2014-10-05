package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.util.HibernateUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Horario;

public class HorarioDAO extends PatternDAO<Horario> {

	@Override
	public Horario findById(long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<Horario> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Long insert(Horario obj) {
		// TODO Auto-generated method stub
		return super.insert(obj);
	}

	@Override
	public boolean update(Horario obj) {
		// TODO Auto-generated method stub
		return super.update(obj);
	}

	@Override
	public boolean delete(Horario obj) {
		// TODO Auto-generated method stub
		return super.delete(obj);
	}

	private static final long serialVersionUID = 1L;
	private final static HorarioDAO instance = new HorarioDAO();

	public HorarioDAO() {
		super(Horario.class);
		// TODO Auto-generated constructor stub
	}

	public static HorarioDAO getInstance() {
		return instance;
	}

	@Override
	public List<Horario> findByFilter(Horario filter) {
		Session session = HibernateUtil.getSession();
		try {

			Criteria c = session.createCriteria(Horario.class);
			if (StringUtils.isNotBlank(filter.getCodigo())) {
				c.add(Restrictions.like("codigo", "%" + filter.getCodigo()
						+ "%"));
			}
			if (filter.getPartida() != null) {
				c.add(Restrictions.eq("partida", filter.getPartida()));
			}
			if (filter.getChegada() != null) {
				c.add(Restrictions.eq("chegada", filter.getChegada()));
			}
			if (StringUtils.isNotBlank(filter.getAviao().getCodigo())) {
				c.createAlias("aviao", "aviao");
				c.add(Restrictions.like("aviao.codigo", "%"
						+ filter.getAviao().getCodigo() + "%"));
			}
			if (StringUtils.isNotBlank(filter.getRota().getOrigem()
					.getEndereco().getCidade())) {
				c.createAlias("rota", "rota");
				c.createAlias("rota.origem", "aeroportoO");
				c.createAlias("aeroportoO.endereco", "endereco");
				c.add(Restrictions.like("endereco.cidade", "%"
						+ filter.getRota().getOrigem().getEndereco()
								.getCidade() + "%"));
			}
			if (StringUtils.isNotBlank(filter.getRota().getDestino()
					.getEndereco().getCidade())) {
				c.createAlias("rota", "rota");
				c.createAlias("rota.destino", "aeroportoD");
				c.createAlias("aeroportoD.endereco", "endereco");
				c.add(Restrictions.like("endereco.cidade", "%"
						+ filter.getRota().getDestino().getEndereco()
								.getCidade() + "%"));
			}
			if (StringUtils.isNotBlank(filter.getRota().getOrigem().getNome())) {
				c.createAlias("rota", "rota");
				c.createAlias("rota.origem", "aeroportoO");
				c.add(Restrictions.like("aeroportoO.nome", "%"
						+ filter.getRota().getOrigem().getNome() + "%"));
			}
			if (StringUtils.isNotBlank(filter.getRota().getDestino().getNome())) {
				c.createAlias("rota", "rota");
				c.createAlias("rota.destino", "aeroportoD");
				c.add(Restrictions.like("aeroportoD.nome", "%"
						+ filter.getRota().getDestino().getNome() + "%"));
			}
			if (StringUtils
					.isNotBlank(filter.getRota().getCiaAerea().getNome())) {
				c.createAlias("rota", "rota");
				c.createAlias("rota.ciaAerea", "ciaAerea");
				c.add(Restrictions.like("ciaAerea.nome", "%"
						+ filter.getRota().getCiaAerea().getNome() + "%"));
			}
			return ((List<Horario>) c.list());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

}