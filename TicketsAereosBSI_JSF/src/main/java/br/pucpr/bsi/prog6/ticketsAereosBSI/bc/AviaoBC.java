package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import javax.persistence.Entity;

import org.apache.commons.lang3.StringUtils;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.AviaoDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;

@Entity
public class AviaoBC extends PatternBC<Aviao>{

private static AviaoBC instance;
	
	private AviaoBC(){
		
	}
	
	public static AviaoBC getInstance() {
	      if (instance == null)
	         instance = new AviaoBC();
	      return instance;
	   }

	@Override
	public Aviao findById(long id) {
		// TODO Auto-generated method stub
		return AviaoDAO.getInstance().findById(id);
	}

	@Override
	public List<Aviao> findByFilter(Aviao filter) {
		// TODO Auto-generated method stub
		if(!this.validateForFindData(filter)){
			throw new TicketsAereosBSIException("ER0001");
		}

		return AviaoDAO.getInstance().findByFilter(filter);
	}

	@Override
	public List<Aviao> findAll() {
		// TODO Auto-generated method stub
		return AviaoDAO.getInstance().findAll();
	}

	@Override
	public long insert(Aviao object) {
		// TODO Auto-generated method stub
		AviaoDAO aviaoDao = AviaoDAO.getInstance();
		
		this.validateForDataModification(object);
		
		return aviaoDao.insert(object);
	}

	@Override
	public boolean update(Aviao object) {
		// TODO Auto-generated method stub
		AviaoDAO aviaoDao = AviaoDAO.getInstance();
		
		this.validateForDataModification(object);
		
		return aviaoDao.update(object);
	}

	@Override
	public boolean delete(Aviao object) {
		// TODO Auto-generated method stub
		AviaoDAO aviaoDao = AviaoDAO.getInstance();
		
		this.validateForDataModification(object);
		
		return aviaoDao.delete(object);
	}

	@Override
	protected void validateForDataModification(Aviao object) {
		// TODO Auto-generated method stub
		if(object == null)
			throw new TicketsAereosBSIException("ER0020");
		else if(object.getCodigo() == null || object.getCodigo().equals(""))
			throw new TicketsAereosBSIException("ER0021");
		else if (object.getCarga() == 0)
			throw new TicketsAereosBSIException("ER0022");
		else if (object.getCarga() < 0)
			throw new TicketsAereosBSIException("ER0023");
	}

	@Override
	protected boolean validateForFindData(Aviao object) {
		if(object != null) 
		{
			
			if(StringUtils.isNotBlank(object.getCodigo()) && object.getCarga() < 0)
				return CiaAereaBC.getInstance().validateForFindData(object.getCiaAerea());
			
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
