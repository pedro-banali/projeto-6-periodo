package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;


public abstract class BilheteBC extends PatternBC<Bilhete>  {

	 protected static BilheteBC instance;
	
	 protected BilheteBC()
	 {
		 
	 }
	 
	 @Override
		protected void validateForDataModification(Bilhete object) {
			// TODO Auto-generated method stub
			if(object == null)
				throw new TicketsAereosBSIException("ER0040");
			else if (object.getAssento() == null)
				throw new TicketsAereosBSIException("ER0041");
			else if (object.getAssento().trim().equals(""))
				throw new TicketsAereosBSIException("ER0041");
			else if(object.getNumero()  == 0)
				throw new TicketsAereosBSIException("ER0042");
			else if(object.getNumero()  < 0)
				throw new TicketsAereosBSIException("ER0043");
			
		}
	 
}
