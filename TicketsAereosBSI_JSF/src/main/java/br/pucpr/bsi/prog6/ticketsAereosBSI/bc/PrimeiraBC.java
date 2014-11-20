package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.ExecutivaDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.PrimeiraDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.dto.BilheteDTO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Primeira;

public class PrimeiraBC extends BilheteBC<Primeira> {

	private static PrimeiraBC instance = new PrimeiraBC();

	private PrimeiraBC() {
	}

	public static PrimeiraBC getInstance() {
		return instance;
	}

	@Override
	public Primeira findById(long id) {
		if (id < 0) {
			return null;
		}
		return PrimeiraDAO.getInstance().findById(id);
	}

	@Override
	public List<Primeira> findByFilter(Primeira filter) {
		if (!validateForFindData(filter)) {
			throw new TicketsAereosBSIException("ER0001");
		}
		return PrimeiraDAO.getInstance().findByFilter(filter);
	}

	@Override
	public List<Primeira> findAll() {
		return PrimeiraDAO.getInstance().findAll();
	}

	@Override
	public long insert(Primeira object) {
		validateForDataModification(object);
		return PrimeiraDAO.getInstance().insert(object);
	}

	@Override
	public boolean update(Primeira object) {
		validateForDataModification(object);
		return PrimeiraDAO.getInstance().update(object);
	}

	@Override
	public boolean delete(Primeira object) {
		return PrimeiraDAO.getInstance().delete(object);
	}

	@Override
	protected void validateForDataModification(Primeira object) {
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
	protected boolean validateForFindData(Primeira object) {
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

		return PrimeiraDAO.getInstance().findAssentosDisponiveis(idHorario);
	}

	@Override
	public List<BilheteDTO> findBySituacao(Passageiro passageiro,
			SituacaoBilheteEnum reservado) {
		// TODO Auto-generated method stub
		return PrimeiraDAO.getInstance().findBySituacao(passageiro, reservado);
	}

}
