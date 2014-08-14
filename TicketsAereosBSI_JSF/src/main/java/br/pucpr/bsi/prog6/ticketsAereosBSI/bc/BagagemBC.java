package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

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
		return null;
	}

	@Override
	public List<Bagagem> findByFilter(Bagagem filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bagagem> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long insert(Bagagem object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Bagagem object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Bagagem object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void validateForDataModification(Bagagem object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validateForFindData(Bagagem object) {
		// TODO Auto-generated method stub
		
	}
}
