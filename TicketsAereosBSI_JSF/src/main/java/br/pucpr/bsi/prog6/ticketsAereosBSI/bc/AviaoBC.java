package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import javax.persistence.Entity;

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
		return null;
	}

	@Override
	public List<Aviao> findByFilter(Aviao filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aviao> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long insert(Aviao object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Aviao object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Aviao object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void validateForDataModification(Aviao object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validateForFindData(Aviao object) {
		// TODO Auto-generated method stub
		
	}
}
