package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.PrimeiraDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;

public class PrimeiraBC extends BilheteBC<Bilhete> {

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
		return PrimeiraDAO.getInstance().findById(id);
	}

	@Override
	public List<Bilhete> findByFilter(Bilhete filter) {
		// TODO Auto-generated method stub
		
		this.validateForDataModification(filter);
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
		PrimeiraDAO primeiraDao = PrimeiraDAO.getInstance();
		this.validateForDataModification(object);
		
		return primeiraDao.insert(object);
	}

	@Override
	public boolean update(Bilhete object) {
		// TODO Auto-generated method stub
		PrimeiraDAO primeiraDao = PrimeiraDAO.getInstance();
		this.validateForDataModification(object);
		return primeiraDao.update(object);
	}

	@Override
	public boolean delete(Bilhete object) {
		// TODO Auto-generated method stub
		PrimeiraDAO primeiraDao = PrimeiraDAO.getInstance();
		this.validateForDataModification(object);
		return primeiraDao.delete(object);
	}

	@Override
	protected void validateForDataModification(Bilhete object) {
		// TODO Auto-generated method stub
		if (object == null)
			throw new TicketsAereosBSIException("ER0040");
		else if (object.getAssento() == null)
			throw new TicketsAereosBSIException("ER0041");
		else if (object.getAssento().trim().equals(""))
			throw new TicketsAereosBSIException("ER0041");
		else if (object.getNumero() == 0)
			throw new TicketsAereosBSIException("ER0042");
		else if (object.getNumero() < 0)
			throw new TicketsAereosBSIException("ER0043");

		
		HorarioBC.getInstance().validateForDataModification(object.getHorario());
		
		PassageiroBC.getInstance().validateForDataModification(object.getPassageiro());
	}

	@Override
	protected boolean validateForFindData(Bilhete object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reservarBilhete(Long idBilhete, Passageiro passageiro,
			String string) {
		// TODO Auto-generated method stub
		
	}

	
	}