package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;


public class EconomicaBC extends BilheteBC {

private static EconomicaBC instance;
	
	public EconomicaBC(){
		
	}
	
	public static EconomicaBC getInstance() {
	      if (instance == null)
	         instance = new EconomicaBC();
	      return instance;
	   }
	}