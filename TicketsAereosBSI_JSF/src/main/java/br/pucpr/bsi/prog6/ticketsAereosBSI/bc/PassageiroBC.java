package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		return (Passageiro) PassageiroDAO.getInstance().findById(id);
	}

	@Override
	public List<Passageiro> findByFilter(Passageiro filter) {
		// TODO Auto-generated method stub

		if(!(this.validateForFindData(filter)))
		{
			throw new TicketsAereosBSIException("ER0001");
		}
		return PassageiroDAO.getInstance().findByFilter(filter);
	}

	@Override
	public List<Passageiro> findAll() {
		// TODO Auto-generated method stub
		return null;
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
		if(object == null && (object.getNome() == null || object.getNome().equals("")) && 
				(object.getNumeroCartao() == null || object.getNumeroCartao().equals(""))){
			return false;
		}
		return true;
	}
}
