package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;


public class FuncionarioBC extends PessoaBC {

private static FuncionarioBC instance;
	
	private FuncionarioBC(){
		
	}
	
	public static FuncionarioBC getInstance() {
	      if (instance == null)
	         instance = new FuncionarioBC();
	      return instance;
	   }
}
