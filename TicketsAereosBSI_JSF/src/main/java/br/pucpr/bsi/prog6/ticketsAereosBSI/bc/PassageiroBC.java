package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

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
		Passageiro passageiro;
	 		
		super.validateForDataModification(object);
		
        passageiro = (Passageiro) object;
        
		if(passageiro.getDocumento() == null)
			throw new TicketsAereosBSIException("ER0100");
		else if(passageiro.getNumeroCartao() == null)
			throw new TicketsAereosBSIException("ER0101");
			

		EnderecoBC.getInstance().insert(object.getEndereco());
	}

	@Override
	protected void validateForFindData(Pessoa object) {
		// TODO Auto-generated method stub
		
	}
}
