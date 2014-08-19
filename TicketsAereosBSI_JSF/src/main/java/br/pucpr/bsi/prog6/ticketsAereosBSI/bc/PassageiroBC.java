package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Pessoa;


public class PassageiroBC extends PessoaBC {

private static PassageiroBC instance;
	
	private PassageiroBC(){
		
	}
	
	public static PassageiroBC getInstance() {
	      if (instance == null)
	         instance = new PassageiroBC();
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
		// TODO Auto-generated method stub
		Passageiro passageiro;
	 	String nameMask = "[a-zA-Z]+[a-zA-Z0-9]*([\\.|\\-|_][a-zA-Z0-9]+)*";  
        String domainMask = "[a-zA-Z]+[a-zA-Z0-9]*([\\.|\\-|_][a-zA-Z0-9]+)+";  
        String at = "@";  
        String emailMask = nameMask + at + domainMask;  
        Pattern pattern; 
        Matcher matcher;
		
        passageiro = (Passageiro) object;
        
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
			else if(passageiro.getDocumento() == null)
				throw new TicketsAereosBSIException("ER0100");
			else if(passageiro.getNumeroCartao() == null)
				throw new TicketsAereosBSIException("ER0101");
			

		}
		EnderecoBC.getInstance().insert(object.getEndereco());
		return 0;
	}

	@Override
	public boolean update(Pessoa object) {
		// TODO Auto-generated method stub
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
		
	}

	@Override
	protected void validateForFindData(Pessoa object) {
		// TODO Auto-generated method stub
		
	}
}
