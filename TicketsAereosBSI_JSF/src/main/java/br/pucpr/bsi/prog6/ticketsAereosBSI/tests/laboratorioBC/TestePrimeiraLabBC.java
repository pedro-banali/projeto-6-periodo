package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC;

import org.junit.Before;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PrimeiraBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel.TestePrimeiraLabModel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.PrintUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TestePrimeiraLabBC extends TestePrimeiraLabModel {
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Before
	public void criarBilhete(){
		bilhete = novaPrimeira1();
	}
	
	/**
	 * Valida o bilhete nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarBilheteNulo(){
		bilhete = null;
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(bilhete);		
		PrimeiraBC.getInstance().insert(bilhete);
	}
	
	/**
	 * Valida o bilhete sem o passageiro
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarBilheteSemPassageiro(){
		bilhete.setPassageiro(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(bilhete);		
		PrimeiraBC.getInstance().insert(bilhete);
	}
	
	/**
	 * Valida o bilhete sem o horario
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarBilheteSemHorario(){
		bilhete.setHorario(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(bilhete);		
		PrimeiraBC.getInstance().insert(bilhete);
	}
	
	
	/**
	 * Valida o bilhete preenchido com espacos em branco
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarBilheteEspacosBranco(){
		bilhete.setAssento("                         ");

		PrintUtils.imprimeNomeMetodoChamadorEClasse(bilhete);		
		PrimeiraBC.getInstance().insert(bilhete);
	}	
	
	/**
	 * Valida o bilhete sem o codigo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarBilheteSemAssento(){
		bilhete.setAssento(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(bilhete);		
		PrimeiraBC.getInstance().insert(bilhete);
	}
	
	/**
	 * Valida o carga sem o numero
	 * Como aqui numero eh um tipo primitivo sera setado o 0, indicando que
	 * este nao foi modificado
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarBilheteSemNumero(){
		bilhete.setNumero(0);

		PrintUtils.imprimeNomeMetodoChamadorEClasse(bilhete);		
		PrimeiraBC.getInstance().insert(bilhete);
	}
	
	/**
	 * Valida o bilehte com o numero negativo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarBilheteComNumeroNegativo(){
		bilhete.setNumero(-200);

		PrintUtils.imprimeNomeMetodoChamadorEClasse(bilhete);		
		PrimeiraBC.getInstance().insert(bilhete);
	}
	
	
	/**
	 * Valida o bilhete completo
	 */
	@Test
	@Override
	public void criarPrimeiraCompleta(){
		super.criarPrimeiraCompleta();
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(bilhete);		
		PrimeiraBC.getInstance().insert(bilhete);
	}
}
