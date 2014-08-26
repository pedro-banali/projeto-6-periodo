package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;

public class BilheteBCFactory {
	
	 private static BilheteBCFactory instance;
		
	 public BilheteBCFactory()
	 {
		 
	 }

	public static BilheteBC getInstanceBC(TipoBilheteEnum tipoBilheteEnum) {
		// TODO Auto-generated method stub
		if(tipoBilheteEnum == TipoBilheteEnum.ECONOMICA)
			return null;
		else if(tipoBilheteEnum == TipoBilheteEnum.EXECUTIVA)
			return null;
		else
			return null;
	}
	
	 
	 
	 
}
