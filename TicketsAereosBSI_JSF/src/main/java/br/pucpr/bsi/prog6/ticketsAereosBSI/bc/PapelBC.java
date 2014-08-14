package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;


public class PapelBC {

private static PapelBC instance;
	
	private PapelBC(){
		
	}
	
	public static PapelBC getInstance() {
	      if (instance == null)
	         instance = new PapelBC();
	      return instance;
	   }
}
