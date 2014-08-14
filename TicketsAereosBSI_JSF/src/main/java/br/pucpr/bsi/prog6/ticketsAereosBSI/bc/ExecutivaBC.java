package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

public class ExecutivaBC extends BilheteBC {

private static ExecutivaBC instance;
	
	public ExecutivaBC(){
		
	}
	
	public static ExecutivaBC getInstance() {
	      if (instance == null)
	         instance = new ExecutivaBC();
	      return instance;
	   }
	}
