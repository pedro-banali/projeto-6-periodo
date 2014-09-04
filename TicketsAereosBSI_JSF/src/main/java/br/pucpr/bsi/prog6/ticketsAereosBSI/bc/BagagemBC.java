package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.BagagemDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bagagem;


public class BagagemBC extends PatternBC<Bagagem> {

private static BagagemBC instance;
	
	private BagagemBC(){
		
	}
	
	public static BagagemBC getInstance() {
	      if (instance == null)
	         instance = new BagagemBC();
	      return instance;
	   }

	@Override
	public Bagagem findById(long id) {
		// TODO Auto-generated method stub
		return BagagemDAO.getInstance().findById(id);
	}

	@Override
	public List<Bagagem> findByFilter(Bagagem filter) {
		// TODO Auto-generated method stub
		this.validateForDataModification(filter);
		return null;
	}

	@Override
	public List<Bagagem> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long insert(Bagagem object) {
		
		BagagemDAO bagagem = BagagemDAO.getInstance();
		
		this.validateForDataModification(object);
					
		return bagagem.insert(object);
	}

	@Override
	public boolean update(Bagagem object) {
		
		BagagemDAO bagagem = BagagemDAO.getInstance();
		
		this.validateForDataModification(object);
		
				
		return bagagem.update(object);
	}

	@Override
	public boolean delete(Bagagem object) {
		
		BagagemDAO bagagem = BagagemDAO.getInstance();
		
		this.validateForDataModification(object);
		
				
		return bagagem.delete(object);
	}

	@Override
	protected void validateForDataModification(Bagagem object) {
		// TODO Auto-generated method stub
		if(object == null)
			throw new TicketsAereosBSIException("ER0030");
		else if (object.getPeso() == 0)
			throw new TicketsAereosBSIException("ER0031");
		else if (object.getPeso() < 0)
			throw new TicketsAereosBSIException("ER0032");
		else if(object.getTipoBagagemEnum()  == null)
			throw new TicketsAereosBSIException("ER0033");
		else if(object.getBilhete() == null)
			throw new TicketsAereosBSIException("ER0034");
	}

	@Override
	protected void validateForFindData(Bagagem object) {
		// TODO Auto-generated method stub
		
	}
}
