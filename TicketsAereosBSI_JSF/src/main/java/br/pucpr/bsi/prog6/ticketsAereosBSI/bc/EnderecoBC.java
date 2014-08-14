package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;


public class EnderecoBC {
	
	private static EnderecoBC instance;
	
	private EnderecoBC(){
		
	}
	
	public static EnderecoBC getInstance() {
	      if (instance == null)
	         instance = new EnderecoBC();
	      return instance;
	   }
}
