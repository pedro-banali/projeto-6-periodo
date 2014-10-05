package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.PassageiroDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;

public class PassageiroBC extends PessoaBC<Passageiro> {

	private static PassageiroBC instance;

	private PassageiroBC() {

	}

	public static PassageiroBC getInstance() {
		if (instance == null)
			instance = new PassageiroBC();
		return instance;
	}

	@Override
	public Passageiro findById(long id) {
		// TODO Auto-generated method stub
		return PassageiroDAO.getInstance().findById(id);
	}

	@Override
	public List<Passageiro> findByFilter(Passageiro filter) {
		// TODO Auto-generated method stub

		if (!(this.validateForFindData(filter))) {
			throw new TicketsAereosBSIException("ER0001");
		}
		return PassageiroDAO.getInstance().findByFilter(filter);
	}

	@Override
	public List<Passageiro> findAll() {
		// TODO Auto-generated method stub
		return PassageiroDAO.getInstance().findAll();
	}

	@Override
	public long insert(Passageiro object) {
		// TODO Auto-generated method stub
		PassageiroDAO passageiroDao = PassageiroDAO.getInstance();
		this.validateForDataModification(object);
		return passageiroDao.insert(object);
	}

	@Override
	public boolean update(Passageiro object) {
		// TODO Auto-generated method stub
		PassageiroDAO passageiroDao = PassageiroDAO.getInstance();
		this.validateForDataModification(object);
		return passageiroDao.update(object);
	}

	@Override
	public boolean delete(Passageiro object) {
		// TODO Auto-generated method stub
		PassageiroDAO passageiroDao = PassageiroDAO.getInstance();
		this.validateForDataModification(object);
		return passageiroDao.delete(object);
	}

	@Override
	protected void validateForDataModification(Passageiro object) {
		// TODO Auto-generated method stub
		Passageiro passageiro;

		super.validateForDataModification(object);

		passageiro = (Passageiro) object;

		if (passageiro.getDocumento() == null)
			throw new TicketsAereosBSIException("ER0100");
		else if (passageiro.getNumeroCartao() == null)
			throw new TicketsAereosBSIException("ER0101");

		EnderecoBC.getInstance().validateForDataModification(
				object.getEndereco());
	}

	@Override
	protected boolean validateForFindData(Passageiro object) {
		// TODO Auto-generated method stub
		if (object != null)
		{	
			if (StringUtils.isBlank(object.getNome())
					&& StringUtils.isBlank(object.getNumeroCartao())
					&& StringUtils.isBlank(object.getDocumento())
					&& !super.validateForFindData(object)) {
				return false;
			} else {
				return true;
			}
		}
		else
		{
			return false;
		}
	}
}
