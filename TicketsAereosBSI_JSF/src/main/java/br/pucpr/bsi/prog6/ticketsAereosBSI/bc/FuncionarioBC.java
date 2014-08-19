package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public Pessoa findById(long id) {
		// TODO Auto-generated method stub
		return null;
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
		this.validateForDataModification(object);
		return 0;
	}

	@Override
	public boolean update(Pessoa object) {
		// TODO Auto-generated method stub
		this.validateForDataModification(object);
		return false;
	}

	@Override
	public boolean delete(Pessoa object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void validateForDataModification(Pessoa object) {
		// TODO Auto-generated method stub
		Funcionario funcionario;
	 	String nameMask = "[a-zA-Z]+[a-zA-Z0-9]*([\\.|\\-|_][a-zA-Z0-9]+)*";  
        String domainMask = "[a-zA-Z]+[a-zA-Z0-9]*([\\.|\\-|_][a-zA-Z0-9]+)+";  
        String at = "@";  
        String emailMask = nameMask + at + domainMask;  
        Pattern pattern; 
        Matcher matcher;
		
        funcionario = (Funcionario) object;
        
		if(object == null)
			throw new TicketsAereosBSIException("ER0110");
		else if(object.getDataNascimento() == null)
			throw new TicketsAereosBSIException("ER0111");
		else if(object.getDataNascimento().after(new Date()))
			throw new TicketsAereosBSIException("ER0112");
		else if(object.getEmail() == null)
			throw new TicketsAereosBSIException("ER0113");
		else
		{
			pattern = Pattern.compile(emailMask);
			matcher = pattern.matcher(object.getEmail());  
			if(!matcher.matches())
				throw new TicketsAereosBSIException("ER0114");
			else if(object.getNome() == null)
				throw new TicketsAereosBSIException("ER0115");
			else if(object.getSenha() == null)
				throw new TicketsAereosBSIException("ER0116");
			else if(object.getTelefone() == null)
				throw new TicketsAereosBSIException("ER0117");
			else if(object.getUsuario() == null)
				throw new TicketsAereosBSIException("ER0118");
			else if(funcionario.getContaCorrente() == null)
				throw new TicketsAereosBSIException("ER0071");
			else if(funcionario.getCodigo() == null)
				throw new TicketsAereosBSIException("ER0071");
			

		}
		EnderecoBC.getInstance().insert(object.getEndereco());
		PapelBC.getInstance().insert(funcionario.getPapel());
	}

	@Override
	protected void validateForFindData(Pessoa object) {
		// TODO Auto-generated method stub
		
	}
}
