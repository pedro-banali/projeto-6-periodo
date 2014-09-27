package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.RotaDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;

public class RotaBC extends PatternBC<Rota> {

	private static RotaBC instance;

	private RotaBC() {

	}

	public static RotaBC getInstance() {
		if (instance == null)
			instance = new RotaBC();
		return instance;
	}

	@Override
	public Rota findById(long id) {
		// TODO Auto-generated method stub
		return RotaDAO.getInstance().findById(id);
	}

	@Override
	public List<Rota> findByFilter(Rota filter) {
		// TODO Auto-generated method stub
		if(!(this.validateForFindData(filter)))
		{
			throw new TicketsAereosBSIException("ER0001");
		}
		return RotaDAO.getInstance().findByFilter(filter);
	}

	@Override
	public List<Rota> findAll() {
		// TODO Auto-generated method stub
		return RotaDAO.getInstance().findAll();
	}

	@Override
	public long insert(Rota object) {
		validateForDataModification(object);
		return RotaDAO.getInstance().insert(object);

	}

	@Override
	public boolean update(Rota object) {
		// TODO Auto-generated method stub
		RotaDAO rotaDao = RotaDAO.getInstance();
		this.validateForDataModification(object);

		return rotaDao.update(object);
	}

	@Override
	public boolean delete(Rota object) {
		// TODO Auto-generated method stub
		RotaDAO rotaDao = RotaDAO.getInstance();
		this.validateForDataModification(object);

		return rotaDao.delete(object);
	}

	@Override
	protected void validateForDataModification(Rota object) {
		// TODO Auto-generated method stub
		if (object == null)
			throw new TicketsAereosBSIException("ER0120");
		else if (object.getNome() == null || object.getNome().trim().equals(""))
			throw new TicketsAereosBSIException("ER0121");
		else if (object.getDescricao() == null)
			throw new TicketsAereosBSIException("ER0122");
		else if (object.getCiaAerea() == null)
			throw new TicketsAereosBSIException("ER0050");

		AeroportoBC.getInstance().validateForDataModification(
				object.getDestino());
		AeroportoBC.getInstance().validateForDataModification(
				object.getOrigem());
	}

	@Override
	protected boolean validateForFindData(Rota object) {
		// TODO Auto-generated method stub]
		if (object != null) {
			if(StringUtils.isBlank(object.getOrigem().getCodigo()) || StringUtils.isBlank(object.getDestino().getCodigo()))
				return false;
			
			if (StringUtils.isBlank(object.getNome()) &&
					StringUtils.isBlank(object.getDescricao()) &&
					StringUtils.isBlank(object.getDestino().getNome()) &&
					StringUtils.isBlank(object.getOrigem().getNome())&&
					StringUtils.isBlank(object.getDestino().getEndereco().getCidade()) &&
					StringUtils.isBlank(object.getOrigem().getEndereco().getCidade()) &&
					!CiaAereaBC.getInstance().validateForFindData(object.getCiaAerea()))
			{
				return false;
			}
			else{
				return true;
			}
		} else {
			return false;
		}
	}
}
