package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;


public class AviaoBC {

private static AviaoBC instance;
	
	private AviaoBC(){
		
	}
	
	public static AviaoBC getInstance() {
	      if (instance == null)
	         instance = new AviaoBC();
	      return instance;
	   }
}
