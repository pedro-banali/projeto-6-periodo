package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;


public class RotaBC {

private static RotaBC instance;
	
	private RotaBC(){
		
	}
	
	public static RotaBC getInstance() {
	      if (instance == null)
	         instance = new RotaBC();
	      return instance;
	   }
}
