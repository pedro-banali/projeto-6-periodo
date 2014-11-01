package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.AviaoDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.HorarioDAO;
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
		return HorarioDAO.getInstance().findById(id);
	}

	@Override
	public List<Horario> findByFilter(Horario filter) {
		// TODO Auto-generated method stub
		if(!(this.validateForFindData(filter)))
		{
			throw new TicketsAereosBSIException("ER0001");
		}
		return HorarioDAO.getInstance().findByFilter(filter);
	}

	@Override
	public List<Horario> findAll() {
		// TODO Auto-generated method stub
		return HorarioDAO.getInstance().findAll();
	}

	@Override
	public long insert(Horario object) {
		// TODO Auto-generated method stub
		HorarioDAO horarioDao = HorarioDAO.getInstance();
		this.validateForDataModification(object);
		return horarioDao.insert(object);
	}

	@Override
	public boolean update(Horario object) {
		// TODO Auto-generated method stub
		HorarioDAO horarioDao = HorarioDAO.getInstance();
		this.validateForDataModification(object);
		return horarioDao.update(object);
	}

	@Override
	public boolean delete(Horario object) {
		// TODO Auto-generated method stub
		HorarioDAO horarioDao = HorarioDAO.getInstance();
		this.validateForDataModification(object);
		return horarioDao.delete(object);
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
//		else if(object.getPartida().compareTo(new Date()) < 0)
//			throw new TicketsAereosBSIException("ER0084");
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
		
		RotaBC.getInstance().validateForDataModification(object.getRota());
		AviaoBC.getInstance().validateForDataModification(object.getAviao());
	}

	@Override
	protected boolean validateForFindData(Horario object) {
		// TODO Auto-generated method stub
		if(object != null)
		{
			if(StringUtils.isBlank(object.getCodigo()) &&
					StringUtils.isBlank(object.getAviao().getCodigo()) &&
					object.getPartida() == null &&
					object.getChegada() == null &&
					!AviaoBC.getInstance().validateForFindData(object.getAviao()) &&
					!RotaBC.getInstance().validateForFindData(object.getRota()))
			{
				return false;
			}
			else
				return true;
		}
		else
			return false;
	}
}
