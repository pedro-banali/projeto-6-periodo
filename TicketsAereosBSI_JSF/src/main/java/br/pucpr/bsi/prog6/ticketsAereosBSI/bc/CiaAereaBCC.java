package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.CiaAereaDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;

public class CiaAereaBCC extends PatternBC<CiaAerea> {
	 
	private static CiaAereaBCC instance = new CiaAereaBCC();
	
	private CiaAereaBCC() {
	}

	public static CiaAereaBCC getInstance() {
		return instance;
	}

	@Override
	public long insert(CiaAerea object) {
		validateForDataModification(object);
		return CiaAereaDAO.getInstance().insert(object);
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
		validateForFindData(filter);
		return CiaAereaDAO.getInstance().findByFilter(filter);
	}
	
	@Override
	public boolean update(CiaAerea object) {
		validateForDataModification(object);
		return CiaAereaDAO.getInstance().update(object);
	}

	@Override
	public boolean delete(CiaAerea object) {
		return CiaAereaDAO.getInstance().delete(object);
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
	protected void validateForFindData(CiaAerea object) {
		if(object != null &&
				StringUtils.isNotBlank(object.getNome())){
			return;	
		}
		throw new TicketsAereosBSIException("ER0001");
	}
}

