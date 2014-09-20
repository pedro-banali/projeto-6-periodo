package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.FuncionarioDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Funcionario;


public class FuncionarioBC extends PessoaBC<Funcionario> {

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
	public List<Funcionario> findByFilter(Funcionario filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> findAll() {
		// TODO Auto-generated method stub
		return null;
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
		
		// TODO Auto-generated method stub
		String nameMask = "[a-zA-Z]+[a-zA-Z0-9]*([\\.|\\-|_][a-zA-Z0-9]+)*";
		String domainMask = "[a-zA-Z]+[a-zA-Z0-9]*([\\.|\\-|_][a-zA-Z0-9]+)+";
		String at = "@";
		String emailMask = nameMask + at + domainMask;
		Pattern pattern;
		Matcher matcher;

		if (object == null)
			throw new TicketsAereosBSIException("ER0110");
		else if (object.getDataNascimento() == null)
			throw new TicketsAereosBSIException("ER0111");
		else if (object.getDataNascimento().after(new Date()))
			throw new TicketsAereosBSIException("ER0112");
		else if (object.getEmail() == null)
			throw new TicketsAereosBSIException("ER0113");
		else {
			pattern = Pattern.compile(emailMask);
			matcher = pattern.matcher(object.getEmail());
			if (!matcher.matches())
				throw new TicketsAereosBSIException("ER0114");
			else if (object.getNome() == null)
				throw new TicketsAereosBSIException("ER0115");
			else if (object.getSenha() == null)
				throw new TicketsAereosBSIException("ER0116");
			else if (object.getTelefone() == null)
				throw new TicketsAereosBSIException("ER0117");
			else if (object.getUsuario() == null)
				throw new TicketsAereosBSIException("ER0118");
		}

		
        funcionario = (Funcionario) object;
        

		
		if(funcionario.getContaCorrente() == null)
			throw new TicketsAereosBSIException("ER0071");
		else if(funcionario.getCodigo() == null)
			throw new TicketsAereosBSIException("ER0071");

		EnderecoBC.getInstance().validateForDataModification(object.getEndereco());
		PapelBC.getInstance().validateForDataModification(funcionario.getPapel());
	}

	@Override
	protected boolean validateForFindData(Funcionario object) {
		// TODO Auto-generated method stub
		return false;
	}
}
