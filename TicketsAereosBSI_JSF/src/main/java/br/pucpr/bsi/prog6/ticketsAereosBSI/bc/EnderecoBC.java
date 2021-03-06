package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.AviaoDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.EnderecoDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;

public class EnderecoBC extends PatternBC<Endereco> {

	private static EnderecoBC instance;

	private EnderecoBC() {

	}

	public static EnderecoBC getInstance() {
		if (instance == null)
			instance = new EnderecoBC();
		return instance;
	}

	@Override
	public Endereco findById(long id) {
		// TODO Auto-generated method stub
		return EnderecoDAO.getInstance().findById(id);
	}

	@Override
	public List<Endereco> findByFilter(Endereco filter) {
		// TODO Auto-generated method stub
		if (!this.validateForFindData(filter)) {
			throw new TicketsAereosBSIException("ER0001");
		}

		return EnderecoDAO.getInstance().findByFilter(filter);
	}

	@Override
	public List<Endereco> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long insert(Endereco object) {

		EnderecoDAO endereco = EnderecoDAO.getInstance();

		this.validateForDataModification(object);

		return endereco.insert(object);
	}

	@Override
	public boolean update(Endereco object) {

		EnderecoDAO endereco = EnderecoDAO.getInstance();

		this.validateForDataModification(object);

		return endereco.update(object);
	}

	@Override
	public boolean delete(Endereco object) {

		EnderecoDAO endereco = EnderecoDAO.getInstance();

		this.validateForDataModification(object);

		return endereco.delete(object);
	}

	@Override
	protected void validateForDataModification(Endereco object) {
		// TODO Auto-generated method stub
		if (object == null)
			throw new TicketsAereosBSIException("ER0060");
		else if (object.getNumero() == 0)
			throw new TicketsAereosBSIException("ER0063");
		else if (object.getNumero() <= 0)
			throw new TicketsAereosBSIException("ER0063");
		else if (object.getPais() == null)
			throw new TicketsAereosBSIException("ER0068");
		else if (object.getCidade() == null)
			throw new TicketsAereosBSIException("ER0066");
		else if (object.getEstado() == null)
			throw new TicketsAereosBSIException("ER0067");
		else if (object.getComplemento() == null)
			throw new TicketsAereosBSIException("ER0064");
		else if (object.getRua() == null)
			throw new TicketsAereosBSIException("ER0061");
		else if (object.getBairro() == null)
			throw new TicketsAereosBSIException("ER0065");
	}

	@Override
	protected boolean validateForFindData(Endereco object) {
		// TODO Auto-generated method stub
		if(object != null )
		{
			if( StringUtils.isBlank(object.getRua())
					&& object.getNumero() <= 0
					&& StringUtils.isBlank(object.getComplemento())
					&& StringUtils.isBlank(object.getBairro())
					&& StringUtils.isBlank(object.getCidade())
					&& StringUtils.isBlank(object.getPais())
					&& StringUtils.isBlank(object.getEstado()))
					return false;
			else
				return true;
		}
		else
			return false;
		
	}
}
