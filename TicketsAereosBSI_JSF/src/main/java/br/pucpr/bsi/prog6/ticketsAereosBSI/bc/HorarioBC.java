package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;


public class HorarioBC {

private static HorarioBC instance;
	
	private HorarioBC(){
		
	}
	
	public static HorarioBC getInstance() {
	      if (instance == null)
	         instance = new HorarioBC();
	      return instance;
	   }
}
