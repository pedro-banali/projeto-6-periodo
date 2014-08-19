package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.Date;
import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Horario;


public class HorarioBC extends PatternBC<Horario> {

private static HorarioBC instance;
	
	private HorarioBC(){
		
	}
	
	public static HorarioBC getInstance() {
	      if (instance == null)
	         instance = new HorarioBC();
	      return instance;
	   }

	@Override
	public Horario findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Horario> findByFilter(Horario filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Horario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long insert(Horario object) {
		// TODO Auto-generated method stub
		this.validateForDataModification(object);
		return 0;
	}

	@Override
	public boolean update(Horario object) {
		// TODO Auto-generated method stub
		this.validateForDataModification(object);
		return false;
	}

	@Override
	public boolean delete(Horario object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void validateForDataModification(Horario object) {
		// TODO Auto-generated method stub
		if(object == null)
			throw new TicketsAereosBSIException("ER0080");
		else if(object.getPartida() == null)
			throw new TicketsAereosBSIException("ER0081");
		else if(object.getChegada() == null)
			throw new TicketsAereosBSIException("ER0082");
		else if(object.getPartida().compareTo(new Date()) < 0)
			throw new TicketsAereosBSIException("ER0084");
		else if(object.getChegada().compareTo(object.getPartida()) <  0)
			throw new TicketsAereosBSIException("ER0084");
		else if(object.getQtdEconomica() < 0)
			throw new TicketsAereosBSIException("ER0085");
		else if(object.getQtdExecutiva() < 0)
			throw new TicketsAereosBSIException("ER0086");
		else if(object.getQtdPrimeira() < 0)
			throw new TicketsAereosBSIException("ER0087");
		else if(object.getCodigo() == null)
			throw new TicketsAereosBSIException("ER0088");
		else if(object.getCodigo().trim().equals(""))
			throw new TicketsAereosBSIException("ER0088");
		
		RotaBC.getInstance().insert(object.getRota());
		AviaoBC.getInstance().insert(object.getAviao());
	}

	@Override
	protected void validateForFindData(Horario object) {
		// TODO Auto-generated method stub
		
	}
}
