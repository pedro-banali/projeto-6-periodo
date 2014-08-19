package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;

public class PrimeiraBC extends BilheteBC {

private static PrimeiraBC instance;
	
	public PrimeiraBC(){
		
	}
	
	public static PrimeiraBC getInstance() {
	      if (instance == null)
	         instance = new PrimeiraBC();
	      return instance;
	   }

	@Override
	public Bilhete findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bilhete> findByFilter(Bilhete filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bilhete> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long insert(Bilhete object) {
		// TODO Auto-generated method stub
		if(object == null)
			throw new TicketsAereosBSIException("ER0040");
		else if (object.getAssento() == null)
			throw new TicketsAereosBSIException("ER0041");
		else if (object.getAssento().trim().equals(""))
			throw new TicketsAereosBSIException("ER0041");
		else if(object.getNumero()  == 0)
			throw new TicketsAereosBSIException("ER0042");
		else if(object.getNumero()  < 0)
			throw new TicketsAereosBSIException("ER0043");
		
		HorarioBC.getInstance().insert(object.getHorario());
		
		PassageiroBC.getInstance().insert(object.getPassageiro());
		return 0;
	}

	@Override
	public boolean update(Bilhete object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Bilhete object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void validateForDataModification(Bilhete object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validateForFindData(Bilhete object) {
		// TODO Auto-generated method stub
		
	}

	
	}