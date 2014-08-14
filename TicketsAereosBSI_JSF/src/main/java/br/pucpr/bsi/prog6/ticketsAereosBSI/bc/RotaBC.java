package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;


public class RotaBC extends PatternBC<Rota>{

private static RotaBC instance;
	
	private RotaBC(){
		
	}
	
	public static RotaBC getInstance() {
	      if (instance == null)
	         instance = new RotaBC();
	      return instance;
	   }

	@Override
	public Rota findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rota> findByFilter(Rota filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rota> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long insert(Rota object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Rota object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Rota object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void validateForDataModification(Rota object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validateForFindData(Rota object) {
		// TODO Auto-generated method stub
		
	}
}
