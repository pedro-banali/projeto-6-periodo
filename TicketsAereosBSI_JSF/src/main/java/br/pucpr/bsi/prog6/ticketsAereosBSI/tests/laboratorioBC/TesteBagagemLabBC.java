package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC;

import org.junit.Before;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.BagagemBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel.TesteBagagemLabModel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.PrintUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TesteBagagemLabBC extends TesteBagagemLabModel {
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Before
	public void criarBagagem(){
		bagagem = novaBagagemEconomica();
	}
	
	/**
	 * Valida o bagagem nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarBagagemNulo(){
		bagagem = null;
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(bagagem);		
		BagagemBC.getInstance().insert(bagagem);
	}
	
	/**
	 * Valida o bagagem sem o passageiro
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarBagagemSemBilhete(){
		bagagem.setBilhete(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(bagagem);		
		BagagemBC.getInstance().insert(bagagem);
	}
	
	/**
	 * Valida o carga sem o numero
	 * Como aqui numero eh um tipo primitivo sera setado o 0, indicando que
	 * este nao foi modificado
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarBagagemSemPeso(){
		bagagem.setPeso(0.0);

		PrintUtils.imprimeNomeMetodoChamadorEClasse(bagagem);		
		BagagemBC.getInstance().insert(bagagem);
	}
	
	/**
	 * Valida o bilehte com o numero negativo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarBagagemComPesoNegativo(){
		bagagem.setPeso(-200);

		PrintUtils.imprimeNomeMetodoChamadorEClasse(bagagem);		
		BagagemBC.getInstance().insert(bagagem);
	}
	
	
	/**
	 * Valida o bagagem completo
	 */
	@Test
	@Override
	public void criarBagagemCompleta(){
		super.criarBagagemCompleta();
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(bagagem);		
		BagagemBC.getInstance().insert(bagagem);
	}
}
