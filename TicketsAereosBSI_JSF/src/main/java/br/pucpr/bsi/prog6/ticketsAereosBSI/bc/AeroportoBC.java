package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;

public class AeroportoBC extends PatternBC<Aeroporto>{

private static AeroportoBC instance;
	
	private AeroportoBC(){
		
	}
	
	public static AeroportoBC getInstance() {
	      if (instance == null)
	         instance = new AeroportoBC();
	      return instance;
	   }

	@Override
	public Aeroporto findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aeroporto> findByFilter(Aeroporto filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aeroporto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long insert(Aeroporto object) {
		// TODO Auto-generated method stub
		if(object == null)
			throw new TicketsAereosBSIException("Aeroporto Nulo");
		else if(object.getNome() == null ||object.getNome().trim().equals(""))
			throw new TicketsAereosBSIException("Aeroporto Vazio");
		else if(object.getEndereco() == null)
			throw new TicketsAereosBSIException("Endereco Nulo");
		else if(object.getCodigo() == null || object.getCodigo().equals(""))
			throw new TicketsAereosBSIException("Codigo Endereco Vazio");
		return 0;
	}

	@Override
	public boolean update(Aeroporto object) {
		// TODO Auto-generated method stub
		if(object == null)
			throw new TicketsAereosBSIException("Aeroporto Nulo");
		else if(object.toString().trim().equals(""))
			throw new TicketsAereosBSIException("Aeroporto Vazio");
		return false;
	}

	@Override
	public boolean delete(Aeroporto object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void validateForDataModification(Aeroporto object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validateForFindData(Aeroporto object) {
		// TODO Auto-generated method stub
		
	}


}
