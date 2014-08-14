package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

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
		return 0;
	}

	@Override
	public boolean update(Horario object) {
		// TODO Auto-generated method stub
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
		
	}

	@Override
	protected void validateForFindData(Horario object) {
		// TODO Auto-generated method stub
		
	}
}
