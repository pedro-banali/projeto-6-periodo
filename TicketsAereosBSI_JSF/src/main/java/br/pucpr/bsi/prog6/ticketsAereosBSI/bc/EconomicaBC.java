package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.IdentifierInterface;


public class EconomicaBC extends BilheteBC {

private static EconomicaBC instance;
	
	public EconomicaBC(){
		
	}
	
	public static EconomicaBC getInstance() {
	      if (instance == null)
	         instance = new EconomicaBC();
	      return instance;
	   }

	@Override
	public IdentifierInterface findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IdentifierInterface> findByFilter(IdentifierInterface filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IdentifierInterface> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long insert(IdentifierInterface object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(IdentifierInterface object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(IdentifierInterface object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void validateForDataModification(IdentifierInterface object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validateForFindData(IdentifierInterface object) {
		// TODO Auto-generated method stub
		
	}
	}