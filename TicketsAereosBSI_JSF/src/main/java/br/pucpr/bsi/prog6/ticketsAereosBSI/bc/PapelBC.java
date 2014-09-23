package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Restrictions;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.CiaAereaDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.PapelDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;

public class PapelBC extends PatternBC<Papel> {

	private static PapelBC instance;

	private PapelBC() {

	}

	public static PapelBC getInstance() {
		if (instance == null)
			instance = new PapelBC();
		return instance;
	}

	@Override
	public Papel findById(long id) {
		// TODO Auto-generated method stub
		return PapelDAO.getInstance().findById(id);
	}

	@Override
	public List<Papel> findByFilter(Papel filter) {
		// TODO Auto-generated method stub
		PapelDAO papelDao = PapelDAO.getInstance();
		if (!this.validateForFindData(filter))
			throw new TicketsAereosBSIException("ER0001");

		return papelDao.findByFilter(filter);
	}

	@Override
	public List<Papel> findAll() {
		// TODO Auto-generated method stub
		return PapelDAO.getInstance().findAll();
	}

	@Override
	public long insert(Papel object) {
		// TODO Auto-generated method stub
		PapelDAO papelDao = PapelDAO.getInstance();
		this.validateForDataModification(object);

		return papelDao.insert(object);
	}

	@Override
	public boolean update(Papel object) {
		// TODO Auto-generated method stub
		PapelDAO papelDao = PapelDAO.getInstance();
		this.validateForDataModification(object);
		return papelDao.update(object);
	}

	@Override
	public boolean delete(Papel object) {
		// TODO Auto-generated method stub
		PapelDAO papelDao = PapelDAO.getInstance();
		this.validateForDataModification(object);
		return papelDao.delete(object);
	}

	@Override
	protected void validateForDataModification(Papel object) {
		// TODO Auto-generated method stub
		if (object == null) {
			throw new TicketsAereosBSIException("Papel Nulo");
		} else if (object.getNome() == null) {
			throw new TicketsAereosBSIException("Nome nulo");
		} else if (object.getNome().trim().equals(""))
			throw new TicketsAereosBSIException("Nome Vazio");
		else if (object.getDescricao() == null)
			throw new TicketsAereosBSIException("Descricao nula");
		else if (object.getDescricao().trim().equals(""))
			throw new TicketsAereosBSIException("Descricao Vazia");
	}

	@Override
	protected boolean validateForFindData(Papel object) {
		// TODO Auto-generated method stub
		if (object != null) {
			if (StringUtils.isNotBlank(object.getNome())
					&& StringUtils.isNotBlank(object.getDescricao())
					&& !CiaAereaBC.getInstance().validateForFindData(object.getCiaAerea())) {
				return true;
			}
			return true;
		} else {
			return false;
		}
	}
}
