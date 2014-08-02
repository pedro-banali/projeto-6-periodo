package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC;

import org.junit.Before;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel.TesteCiaAereaLabModel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.PrintUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TesteCiaAereaLabBC extends TesteCiaAereaLabModel {
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Before
	public void criarCiaAerea(){
		ciaAerea = novaCiaAerea1();
	}
	
	/**
	 * Valida o ciaAerea nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarCiaAereaNula(){
		ciaAerea = null;
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(ciaAerea);		
		CiaAereaBC.getInstance().insert(ciaAerea);
	}
	
	/**
	 * Valida o ciaAerea preenchido com espacos em branco
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarCiaAereaEspacosBranco(){
		ciaAerea = new CiaAerea();
		ciaAerea.setNome("                         ");

		PrintUtils.imprimeNomeMetodoChamadorEClasse(ciaAerea);		
		CiaAereaBC.getInstance().insert(ciaAerea);
	}	
	
	/**
	 * Valida o ciaAerea sem o nome
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarCiaAereaSemNome(){
		ciaAerea.setNome(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(ciaAerea);		
		CiaAereaBC.getInstance().insert(ciaAerea);
	}
	
	/**
	 * Valida o ciaAerea completo
	 */
	@Test
	@Override
	public void criarCiaAereaCompleta(){
		super.criarCiaAereaCompleta();
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(ciaAerea);		
		CiaAereaBC.getInstance().insert(ciaAerea);
	}
}
