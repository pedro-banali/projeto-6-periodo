package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.ExecutivaDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;


public class ExecutivaBC extends BilheteBC {
	
	private static ExecutivaBC instance; 
	
	private ExecutivaBC() {
		super();
	}
	public static ExecutivaBC getInstance()
	{
		instance = new ExecutivaBC();
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
		
		ExecutivaDAO executiva = ExecutivaDAO.getInstance();
		
		this.validateForDataModification(object);
		
		executiva.insert(object);
		
		return executiva.insert(object);
	}
	@Override
	public boolean update(Bilhete object) {
		
		ExecutivaDAO executiva = ExecutivaDAO.getInstance();
		
		this.validateForDataModification(object);
		
		executiva.update(object);
		
		return executiva.update(object);
	}
	@Override
	public boolean delete(Bilhete object) {
		
		ExecutivaDAO executiva = ExecutivaDAO.getInstance();
		
		this.validateForDataModification(object);
		
		executiva.delete(object);
		
		return executiva.delete(object);
	}
	@Override
	protected void validateForDataModification(Bilhete object) {
		// TODO Auto-generated method stub
		super.validateForDataModification(object);
		
		HorarioBC.getInstance().insert(object.getHorario());
		
		PassageiroBC.getInstance().insert(object.getPassageiro());
	}
	@Override
	protected void validateForFindData(Bilhete object) {
		// TODO Auto-generated method stub
		
	}
	
}
