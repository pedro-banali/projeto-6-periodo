package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;


public class EnderecoBC extends PatternBC<Endereco>{
	
	private static EnderecoBC instance;
	
	private EnderecoBC(){
		
	}
	
	public static EnderecoBC getInstance() {
	      if (instance == null)
	         instance = new EnderecoBC();
	      return instance;
	   }

	@Override
	public Endereco findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> findByFilter(Endereco filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long insert(Endereco object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Endereco object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Endereco object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void validateForDataModification(Endereco object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validateForFindData(Endereco object) {
		// TODO Auto-generated method stub
		
	}
}
