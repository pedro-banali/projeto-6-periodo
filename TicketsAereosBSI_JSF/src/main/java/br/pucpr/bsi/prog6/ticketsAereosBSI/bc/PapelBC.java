package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;


public class PapelBC extends PatternBC<Papel> {

private static PapelBC instance;
	
	private PapelBC(){
		
	}
	
	public static PapelBC getInstance() {
	      if (instance == null)
	         instance = new PapelBC();
	      return instance;
	   }

	@Override
	public Papel findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Papel> findByFilter(Papel filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Papel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long insert(Papel object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Papel object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Papel object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void validateForDataModification(Papel object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validateForFindData(Papel object) {
		// TODO Auto-generated method stub
		
	}
}
