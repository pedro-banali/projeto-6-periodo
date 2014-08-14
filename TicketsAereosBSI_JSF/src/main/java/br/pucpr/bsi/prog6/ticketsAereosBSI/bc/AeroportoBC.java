package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;


public class AeroportoBC {

private static AeroportoBC instance;
	
	private AeroportoBC(){
		
	}
	
	public static AeroportoBC getInstance() {
	      if (instance == null)
	         instance = new AeroportoBC();
	      return instance;
	   }
}
