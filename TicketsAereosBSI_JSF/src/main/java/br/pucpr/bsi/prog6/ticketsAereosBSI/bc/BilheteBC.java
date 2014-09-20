package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;


public abstract class BilheteBC<T extends Bilhete> extends PatternBC<T>  {

	 protected static BilheteBC instance;
	
	 protected BilheteBC()
	 {
		 
	 }

	public void comprarBilhete(Long idBilhete) {
		// TODO Auto-generated method stub
		
	}

	public List<Object[]> findAssentosDisponiveis(Long idHorario) {
		// TODO Auto-generated method stub
		return null;
	}
	public abstract void reservarBilhete(Long idBilhete, Passageiro passageiro,
			String string);

}
