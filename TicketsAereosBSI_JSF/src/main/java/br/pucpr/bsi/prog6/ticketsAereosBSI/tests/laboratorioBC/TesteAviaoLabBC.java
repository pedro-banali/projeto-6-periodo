package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC;

import org.junit.Before;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AviaoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel.TesteAviaoLabModel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.PrintUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TesteAviaoLabBC extends TesteAviaoLabModel {
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Before
	public void criarAviao(){
		aviao = novoAviao1();
	}
	
	/**
	 * Valida o aviao nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarAviaoNula(){
		aviao = null;
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(aviao);		
		AviaoBC.getInstance().insert(aviao);
	}
	
	/**
	 * Valida o aviao preenchido com espacos em branco
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarAviaoEspacosBranco(){
		aviao.setCodigo("                         ");
		aviao.setCarga(0.0);

		PrintUtils.imprimeNomeMetodoChamadorEClasse(aviao);		
		AviaoBC.getInstance().insert(aviao);
	}	
	
	/**
	 * Valida o aviao sem o codigo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarAviaoSemCodigo(){
		aviao.setCodigo(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(aviao);		
		AviaoBC.getInstance().insert(aviao);
	}
	
	/**
	 * Valida o carga sem o numero
	 * Como aqui numero eh um tipo primitivo sera setado o 0, indicando que
	 * este nao foi modificado
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarCargaSemNumero(){
		aviao.setCarga(0);

		PrintUtils.imprimeNomeMetodoChamadorEClasse(aviao);		
		AviaoBC.getInstance().insert(aviao);
	}
	
	/**
	 * Valida o endereco com o numero negativo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarCargaComNumeroNegativo(){
		aviao.setCarga(-200);

		PrintUtils.imprimeNomeMetodoChamadorEClasse(aviao);		
		AviaoBC.getInstance().insert(aviao);
	}
	
	
	/**
	 * Valida o aviao completo
	 */
	@Test
	@Override
	public void criarAviaoCompleto(){
		super.criarAviaoCompleto();
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(aviao);		
		AviaoBC.getInstance().insert(aviao);
	}
}
