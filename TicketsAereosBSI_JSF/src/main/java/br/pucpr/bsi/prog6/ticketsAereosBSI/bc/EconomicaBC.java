package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.EconomicaDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.dto.BilheteDTO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Economica;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;

public class EconomicaBC extends BilheteBC<Economica> {

	private static EconomicaBC instance = new EconomicaBC();

	private EconomicaBC() {
	}

	public static EconomicaBC getInstance() {
		return instance;
	}

	@Override
	public Economica findById(long id) {
		if (id < 0) {
			return null;
		}
		return EconomicaDAO.getInstance().findById(id);
	}

	@Override
	public List<Economica> findByFilter(Economica filter) {
		if (!validateForFindData(filter)) {
			throw new TicketsAereosBSIException("ER0001");
		}
		return EconomicaDAO.getInstance().findByFilter(filter);
	}

	@Override
	public List<Economica> findAll() {
		return EconomicaDAO.getInstance().findAll();
	}

	@Override
	public long insert(Economica object) {
		validateForDataModification(object);
		return EconomicaDAO.getInstance().insert(object);
	}

	@Override
	public boolean update(Economica object) {
		validateForDataModification(object);
		return EconomicaDAO.getInstance().update(object);
	}

	@Override
	public boolean delete(Economica object) {
		return EconomicaDAO.getInstance().delete(object);
	}

	@Override
	protected void validateForDataModification(Economica object) {
		if (object == null) {
			throw new TicketsAereosBSIException("ER0040");
		}

		if (StringUtils.isBlank(object.getAssento())) {
			throw new TicketsAereosBSIException("ER0041");
		}
		if (object.getNumero() == 0) {
			throw new TicketsAereosBSIException("ER0042");
		}

		if (object.getNumero() < 0) {
			throw new TicketsAereosBSIException("ER0043");
		}

		if (object.getHorario() == null) {
			throw new TicketsAereosBSIException("ER0044");
		}

		if (object.getPassageiro() == null) {
			throw new TicketsAereosBSIException("ER0045");
		}

	}

	@Override
	protected boolean validateForFindData(Economica object) {
		if (object == null) {
			return false;
		}
		if (!(super.validateForFindData(object))) {
			return false;
		}
		return true;

	}

	@Override
	public List<String> findAssentosDisponiveis(long idHorario) {
		if (idHorario <= 0) {
			return null; 
		}
		return EconomicaDAO.getInstance().findAssentosDisponiveis(idHorario);
	}

	@Override
	public List<BilheteDTO> findBySituacao(Passageiro passageiro,
			SituacaoBilheteEnum reservado) {
		// TODO Auto-generated method stub
		return EconomicaDAO.getInstance().findBySituacao(passageiro, reservado);
	}



}
