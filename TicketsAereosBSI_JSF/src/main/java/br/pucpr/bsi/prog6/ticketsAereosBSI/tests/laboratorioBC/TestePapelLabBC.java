package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC;

import org.junit.Before;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PapelBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel.TestePapelLabModel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.PrintUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TestePapelLabBC extends TestePapelLabModel {
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Before
	public void criarPapel(){
		papel = novoPapel1();
	}
	
	/**
	 * Valida o papel nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPapelNulo(){
		papel = null;
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(papel);		
		PapelBC.getInstance().insert(papel);
	}
	
	/**
	 * Valida o papel nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPapelCiaAereaNula(){
		papel.setCiaAerea(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(papel);		
		PapelBC.getInstance().insert(papel);
	}
	
	
	/**
	 * Valida o papel preenchido com espacos em branco
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPapelEspacosBranco(){
		papel.setNome("                         ");
		papel.setDescricao("                         ");

		PrintUtils.imprimeNomeMetodoChamadorEClasse(papel);		
		PapelBC.getInstance().insert(papel);
	}	
	
	/**
	 * Valida o papel sem o nome
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPapelSemDescricao(){
		papel.setDescricao(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(papel);		
		PapelBC.getInstance().insert(papel);
	}
	
	/**
	 * Valida o papel sem o nome
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPapelSemNome(){
		papel.setNome(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(papel);		
		PapelBC.getInstance().insert(papel);
	}
	
	/**
	 * Valida o papel completo
	 */
	@Test
	@Override
	public void criarPapelCompleto(){
		super.criarPapelCompleto();
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(papel);		
		PapelBC.getInstance().insert(papel);
	}
}
