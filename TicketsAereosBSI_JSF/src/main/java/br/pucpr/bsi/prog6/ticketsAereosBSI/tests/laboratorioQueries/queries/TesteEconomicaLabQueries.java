package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.queries;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Economica;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

public class TesteEconomicaLabQueries extends TesteBilheteLabQueries<Economica> {
	
	/**
	 * Metodo a ser implementado nos testes das filhas
	 * @return
	 */
	public TipoBilheteEnum getTipoBilheteEnum(){
		return TipoBilheteEnum.ECONOMICA;
	}
}
