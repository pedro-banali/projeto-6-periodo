package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.FuncionarioDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Funcionario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Pessoa;


public class FuncionarioBC extends PessoaBC {

	private static FuncionarioBC instance;
	
	private FuncionarioBC(){
		
	}
	
	public static FuncionarioBC getInstance() {
	      if (instance == null)
	         instance = new FuncionarioBC();
	      return instance;
	   }

	@Override
	public Funcionario findById(long id) {
		// TODO Auto-generated method stub
		return (Funcionario) FuncionarioDAO.getInstance().findById(id);
	}

	@Override
	public List<Pessoa> findByFilter(Pessoa filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long insert(Pessoa object) {
		FuncionarioDAO funcionarioDao = FuncionarioDAO.getInstance();
		
		this.validateForDataModification(object);
		
		return funcionarioDao.insert(object);
	}

	@Override
	public boolean update(Pessoa object) {
		// TODO Auto-generated method stub
		FuncionarioDAO funcionarioDao = FuncionarioDAO.getInstance();
		
		this.validateForDataModification(object);
		
		return funcionarioDao.update(object);
	}

	@Override
	public boolean delete(Pessoa object) {
		// TODO Auto-generated method stub
		FuncionarioDAO funcionarioDao = FuncionarioDAO.getInstance();
		
		this.validateForDataModification(object);
		
		return funcionarioDao.delete(object);
	}

	@Override
	protected void validateForDataModification(Pessoa object) {
		// TODO Auto-generated method stub
		Funcionario funcionario;
		
        funcionario = (Funcionario) object;
        
        super.validateForDataModification(object);
		
		if(funcionario.getContaCorrente() == null)
			throw new TicketsAereosBSIException("ER0071");
		else if(funcionario.getCodigo() == null)
			throw new TicketsAereosBSIException("ER0071");

		EnderecoBC.getInstance().validateForDataModification(object.getEndereco());
		PapelBC.getInstance().validateForDataModification(funcionario.getPapel());
	}

	@Override
	protected boolean validateForFindData(Pessoa object) {
		// TODO Auto-generated method stub
		return false;
	}
}
