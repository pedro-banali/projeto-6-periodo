package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.util.HibernateUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;

public abstract class BilheteDAO<T extends Bilhete> extends PatternDAO<T> {

	@SuppressWarnings("rawtypes")
	public BilheteDAO(Class entityClass) {
		super(entityClass);
	}

	private static final long serialVersionUID = 1L;

	public abstract List<String> findAssentosDisponiveis(Long idHorario);

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByFilter(T filter) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			String queryString = ("select new br.pucpr.bsi.prog6.ticketsAereosBSI.dto.BilheteDTO(origemEndereco.cidade, destinoEndereco.cidade, origem.codigo, destino.codigo, ciaAerea.nome, b.id, horario.id, horario.partida, b.tipoBilhete, b.situacaoBilhete) "
					+ "from Bilhete as b, Horario as horario, Rota as rota, Aeroporto as origem, Aeroporto as destino, CiaAerea as ciaAerea, Endereco as origemEndereco, Endereco as destinoEndereco "
					+ "where b.horario = horario "
					+ "and horario.rota = rota "
					+ "and rota.ciaAerea = ciaAerea "
					+ "and rota.origem = origem "
					+ "and rota.destino = destino "
					+ "and origem.endereco = origemEndereco "
					+ "and destino.endereco = destinoEndereco "
					+ "and b.situacaoBilhete = :situacao "
					+ "and horario.partida = :partida ");

			if (StringUtils.isNotBlank(filter.getHorario().getRota()
					.getOrigem().getCodigo()))
				queryString += "and origem.codigo = :origemCodigo ";
			else if (StringUtils.isNotBlank(filter.getHorario()
						.getRota().getOrigem().getEndereco().getCidade()))
				queryString += "and origemEndereco.cidade = :origemCidade";

			if (StringUtils.isNotBlank(filter.getHorario().getRota()
					.getDestino().getCodigo()))
				queryString += "and destino.codigo = :destinoCodigo ";
			else if (StringUtils.isNotBlank(filter.getHorario()
					.getRota().getDestino().getEndereco().getCidade()))
				queryString += "and destinoEndereco.cidade = :destinoCidade";

			if (filter.getTipoBilheteEnum() != null)
				queryString += "and b.tipoBilhete = :tipo ";

			if (StringUtils.isNotBlank(filter.getHorario().getRota()
					.getCiaAerea().getNome()))
				queryString += "and ciaAerea.nome = :ciaAereaNome";

			Query query = session.createQuery(queryString);

			query.setParameter("situacao", filter.getSituacaoEnum());
			query.setParameter("partida", filter.getHorario().getPartida());

			if (StringUtils.isNotBlank(filter.getHorario().getRota()
					.getOrigem().getCodigo()))
				query.setParameter("origemCodigo", filter.getHorario()
						.getRota().getOrigem().getCodigo());
			else if (StringUtils.isNotBlank(filter.getHorario()
					.getRota().getOrigem().getEndereco().getCidade()))
				query.setParameter("origemCidade", filter.getHorario()
						.getRota().getOrigem().getEndereco().getCidade());

			if (StringUtils.isNotBlank(filter.getHorario().getRota()
					.getDestino().getCodigo()))
				query.setParameter("destinoCodigo", filter.getHorario()
						.getRota().getDestino().getCodigo());
			else if (StringUtils.isNotBlank(filter.getHorario()
					.getRota().getDestino().getEndereco().getCidade()))
				query.setParameter("destinoCidade", filter.getHorario()
						.getRota().getDestino().getEndereco().getCidade());

			if (filter.getSituacaoEnum() != null)
				query.setParameter("tipo", filter.getTipoBilheteEnum());

			if (StringUtils.isNotBlank(filter.getHorario().getRota()
					.getCiaAerea().getNome()))
				query.setParameter("ciaAereaNome", filter.getHorario()
						.getRota().getCiaAerea().getNome());

			return query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
				session.close();
		}
	}
}
