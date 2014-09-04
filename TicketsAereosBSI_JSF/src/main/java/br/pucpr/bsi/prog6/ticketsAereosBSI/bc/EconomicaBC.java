package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.BagagemDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.EconomicaDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;


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
	public Bilhete findById(long id) {
		// TODO Auto-generated method stub
		return EconomicaDAO.getInstance().findById(id);
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
		
		EconomicaDAO economica = EconomicaDAO.getInstance();
		
		this.validateForDataModification(object);
				
		return economica.insert(object);
	}

	@Override
	public boolean update(Bilhete object) {
		
		EconomicaDAO economica = EconomicaDAO.getInstance();
		
		this.validateForDataModification(object);
				
		return economica.update(object);
	}

	@Override
	public boolean delete(Bilhete object) {
		
		EconomicaDAO economica = EconomicaDAO.getInstance();
		
		this.validateForDataModification(object);
			
		
		return economica.delete(object);
	}

	@Override
	protected void validateForDataModification(Bilhete object) {
		// TODO Auto-generated method stub
		super.validateForDataModification(object);
		
		HorarioBC.getInstance().validateForDataModification(object.getHorario());
		
		PassageiroBC.getInstance().validateForDataModification(object.getPassageiro());
	}

	@Override
	protected void validateForFindData(Bilhete object) {
		// TODO Auto-generated method stub
		
	}

	
	}