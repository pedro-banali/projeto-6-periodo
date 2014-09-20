package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;


public abstract class BilheteBC<T extends Bilhete> extends PatternBC<T>  {

	 protected static BilheteBC instance;
	
	 protected BilheteBC()
	 {
		 
	 }
	 

}
