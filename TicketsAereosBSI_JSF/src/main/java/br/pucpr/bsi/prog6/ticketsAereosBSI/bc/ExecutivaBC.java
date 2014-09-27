package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.ExecutivaDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Executiva;

public class ExecutivaBC extends BilheteBC<Executiva> {

	private static ExecutivaBC instance = new ExecutivaBC();

	private ExecutivaBC() {
	}

	public static ExecutivaBC getInstance() {
		return instance;
	}

	@Override
	public Executiva findById(long id) {
		if (id < 0) {
			return null;
		}
		return ExecutivaDAO.getInstance().findById(id);
	}

	@Override
	public List<Executiva> findByFilter(Executiva filter) {
		if (!validateForFindData(filter)) {
			throw new TicketsAereosBSIException("ER0001");
		}
		return ExecutivaDAO.getInstance().findByFilter(filter);
	}

	@Override
	public List<Executiva> findAll() {
		return ExecutivaDAO.getInstance().findAll();
	}

	@Override
	public long insert(Executiva object) {
		validateForDataModification(object);
		return ExecutivaDAO.getInstance().insert(object);
	}

	@Override
	public boolean update(Executiva object) {
		validateForDataModification(object);
		return ExecutivaDAO.getInstance().update(object);
	}

	@Override
	public boolean delete(Executiva object) {
		return ExecutivaDAO.getInstance().delete(object);
	}

	@Override
	protected void validateForDataModification(Executiva object) {
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
	protected boolean validateForFindData(Executiva object) {
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
			return null; // Talvez tenha que dar throw
		}

		return ExecutivaDAO.getInstance().findAssentosDisponiveis(idHorario);
	}

}
