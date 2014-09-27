package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.CiaAereaDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;

public class CiaAereaBC extends PatternBC<CiaAerea> {
	 
	private static CiaAereaBC instance = new CiaAereaBC();
	
	private CiaAereaBC() {
	}

	public static CiaAereaBC getInstance() {
		return instance;
	}

	@Override
	public long insert(CiaAerea object) {
		
		CiaAereaDAO ciaAerea = CiaAereaDAO.getInstance();
		
		this.validateForDataModification(object);
		
		return ciaAerea.insert(object);
	}

	@Override
	public CiaAerea findById(long id) {
		if(id < 0){
			return null;
		}
		return CiaAereaDAO.getInstance().findById(id);
	}

	@Override
	public List<CiaAerea> findAll() {
		return CiaAereaDAO.getInstance().findAll();
	}

	@Override
	public List<CiaAerea> findByFilter(CiaAerea filter) {
		if(!(validateForFindData(filter)))
		{
			throw new TicketsAereosBSIException("ER0001");
		}
		return CiaAereaDAO.getInstance().findByFilter(filter);
	}
	
	@Override
	public boolean update(CiaAerea object) {
		
		CiaAereaDAO ciaAerea = CiaAereaDAO.getInstance();
		
		this.validateForDataModification(object);
				
		return ciaAerea.update(object);
	}

	@Override
	public boolean delete(CiaAerea object) {
		
		CiaAereaDAO ciaAerea = CiaAereaDAO.getInstance();
		
		this.validateForDataModification(object);
		
				
		return ciaAerea.delete(object);
	}

	@Override
	protected void validateForDataModification(CiaAerea object) {
		if(object == null){
			throw new TicketsAereosBSIException("ER0050");
		}
		
		if(StringUtils.isBlank(object.getNome())){
			throw new TicketsAereosBSIException("ER0051");
		}
	}

	@Override
	protected boolean validateForFindData(CiaAerea object) {
		if(object != null){
				if(StringUtils.isBlank(object.getNome())
						&& !(object.getId() != null))
					return false;	
				else return true;
		}
		else
		return false;
	}
}

