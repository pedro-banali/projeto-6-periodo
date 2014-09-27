package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.FuncionarioDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Funcionario;

public class FuncionarioBC extends PessoaBC<Funcionario> {

	private static FuncionarioBC instance;

	private FuncionarioBC() {

	}

	public static FuncionarioBC getInstance() {
		if (instance == null)
			instance = new FuncionarioBC();
		return instance;
	}

	@Override
	public Funcionario findById(long id) {
		// TODO Auto-generated method stub
		return FuncionarioDAO.getInstance().findById(id);
	}

	@Override
	public List<Funcionario> findByFilter(Funcionario filter) {
		// TODO Auto-generated method stub
		if (!(this.validateForFindData(filter))) {
			throw new TicketsAereosBSIException("ER0001");
		}
		return FuncionarioDAO.getInstance().findByFilter(filter);
	}

	@Override
	public List<Funcionario> findAll() {
		// TODO Auto-generated method stub
		return FuncionarioDAO.getInstance().findAll();
	}

	@Override
	public long insert(Funcionario object) {
		FuncionarioDAO funcionarioDao = FuncionarioDAO.getInstance();

		this.validateForDataModification(object);

		return funcionarioDao.insert(object);
	}

	@Override
	public boolean update(Funcionario object) {
		// TODO Auto-generated method stub
		FuncionarioDAO funcionarioDao = FuncionarioDAO.getInstance();

		this.validateForDataModification(object);

		return funcionarioDao.update(object);
	}

	@Override
	public boolean delete(Funcionario object) {
		// TODO Auto-generated method stub
		FuncionarioDAO funcionarioDao = FuncionarioDAO.getInstance();

		this.validateForDataModification(object);

		return funcionarioDao.delete(object);
	}

	@Override
	protected void validateForDataModification(Funcionario object) {
		// TODO Auto-generated method stub
		Funcionario funcionario;

		funcionario = (Funcionario) object;
		
		super.validateForDataModification(object);
		
		if (funcionario.getContaCorrente() == null)
			throw new TicketsAereosBSIException("ER0071");
		else if (funcionario.getCodigo() == null)
			throw new TicketsAereosBSIException("ER0071");

		EnderecoBC.getInstance().validateForDataModification(
				object.getEndereco());
		PapelBC.getInstance().validateForDataModification(
				funcionario.getPapel());
	}

	@Override
	protected boolean validateForFindData(Funcionario object) {
		// TODO Auto-generated method stub

		if (object != null) {
			if (StringUtils.isBlank(object.getCodigo())
					&& StringUtils.isBlank(object.getContaCorrente())
					&& StringUtils.isBlank(object.getTelefone())
					&& StringUtils.isBlank(object.getTelefone())
					&& PapelBC.getInstance().validateForFindData(object.getPapel())
					&& !super.validateForFindData(object)
					&& StringUtils.isBlank(object.getPapel().getNome())
					&& StringUtils.isBlank(object.getPapel().getCiaAerea().getNome())) {
					return false;
			}
			else
			{
				return true;
			}
		} else {
			return false;
		}
	}

}
