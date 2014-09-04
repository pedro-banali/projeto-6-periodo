package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.PassageiroDAO;
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
	public Passageiro findById(long id) {
		// TODO Auto-generated method stub
		return (Passageiro) PassageiroDAO.getInstance().findById(id);
	}

	@Override
	public List<Pessoa> findByFilter(Pessoa filter) {
		// TODO Auto-generated method stub
		
		this.validateForDataModification(filter);
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
		PassageiroDAO passageiroDao = PassageiroDAO.getInstance();
		this.validateForDataModification(object);
		return passageiroDao.insert(object);
	}

	@Override
	public boolean update(Pessoa object) {
		// TODO Auto-generated method stub
		PassageiroDAO passageiroDao = PassageiroDAO.getInstance();
		this.validateForDataModification(object);
		return passageiroDao.update(object);
	}

	@Override
	public boolean delete(Pessoa object) {
		// TODO Auto-generated method stub
		PassageiroDAO passageiroDao = PassageiroDAO.getInstance();
		this.validateForDataModification(object);
		return passageiroDao.delete(object);
	}

	@Override
	protected void validateForDataModification(Pessoa object) {
		// TODO Auto-generated method stub
		Passageiro passageiro;
	 		
		super.validateForDataModification(object);
		
        passageiro = (Passageiro) object;
        
		if(passageiro.getDocumento() == null)
			throw new TicketsAereosBSIException("ER0100");
		else if(passageiro.getNumeroCartao() == null)
			throw new TicketsAereosBSIException("ER0101");
			

		EnderecoBC.getInstance().validateForDataModification(object.getEndereco());
	}

	@Override
	protected void validateForFindData(Pessoa object) {
		// TODO Auto-generated method stub
		
	}
}
