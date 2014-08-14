package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.IdentifierInterface;


public abstract class BilheteBC extends PatternBC<IdentifierInterface>  {

	 protected static BilheteBC instance;
	
	 protected BilheteBC()
	 {
		 
	 }
	 
}
