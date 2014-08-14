package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;


public class BagagemBC {

private static BagagemBC instance;
	
	private BagagemBC(){
		
	}
	
	public static BagagemBC getInstance() {
	      if (instance == null)
	         instance = new BagagemBC();
	      return instance;
	   }
}
