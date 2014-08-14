package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

public class PrimeiraBC extends BilheteBC {

private static PrimeiraBC instance;
	
	public PrimeiraBC(){
		
	}
	
	public static PrimeiraBC getInstance() {
	      if (instance == null)
	         instance = new PrimeiraBC();
	      return instance;
	   }
	}