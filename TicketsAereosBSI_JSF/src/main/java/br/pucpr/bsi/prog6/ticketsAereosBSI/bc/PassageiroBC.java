package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;


public class PassageiroBC extends PessoaBC {

private static PassageiroBC instance;
	
	private PassageiroBC(){
		
	}
	
	public static PassageiroBC getInstance() {
	      if (instance == null)
	         instance = new PassageiroBC();
	      return instance;
	   }
}
