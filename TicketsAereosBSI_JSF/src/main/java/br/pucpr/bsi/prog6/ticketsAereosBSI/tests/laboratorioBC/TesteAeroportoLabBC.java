package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC;

import org.junit.Before;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel.TesteAeroportoLabModel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.PrintUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TesteAeroportoLabBC extends TesteAeroportoLabModel{
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Before
	public void criarAeroporto(){
		aeroporto = novoAeroporto1();
	}	
	
	/**
	 * Valida o aeroporto nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarAeroportoNulo(){
		aeroporto = null;
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(aeroporto);
		AeroportoBC.getInstance().insert(aeroporto);
	}
	
	/**
	 * Valida o aeroporto com endereco nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarAeroportoEnderecoNulo(){
		aeroporto.setEndereco(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(aeroporto);		
		AeroportoBC.getInstance().insert(aeroporto);
	}
	
	/**
	 * Valida o aeroporto preenchido com espacos em branco
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarAeroportoEspacosBranco(){
		aeroporto.setCodigo("                               ");
		aeroporto.setNome("                              ");
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(aeroporto);		
		AeroportoBC.getInstance().insert(aeroporto);
	}
	
	/**
	 * Valida o aeroporto sem codigo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarAeroportoSemCodigo(){
		aeroporto.setCodigo(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(aeroporto);		
		AeroportoBC.getInstance().insert(aeroporto);
	}
	
	/**
	 * Valida o aeroporto sem nome
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarAeroportoSemNome(){
		aeroporto.setNome(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(aeroporto);		
		AeroportoBC.getInstance().insert(aeroporto);
	}
	
	/**
	 * Metodo responsavel por criar um aeroporto completo
	 */
	@Test
	public void criarAeroportoCompleto(){
		super.criarAeroportoCompleto();
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(aeroporto);		
		AeroportoBC.getInstance().insert(aeroporto);
	}
}