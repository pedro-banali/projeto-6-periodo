package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC;

import org.junit.Before;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.RotaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel.TesteRotaLabModel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.PrintUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TesteRotaLabBC extends TesteRotaLabModel {
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Before
	public void criarRota(){
		rota = novaRota1();
	}
	
	/**
	 * Valida a rota nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarRotaNulo(){
		rota = null;
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(rota);		
		RotaBC.getInstance().insert(rota);
	}
	
	/**
	 * Valida a cia aerea nula
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarCiaAereaNula(){
		rota.setCiaAerea(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(rota);		
		RotaBC.getInstance().insert(rota);
	}
	
	/**
	 * Valida a origem nula
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarOrigemNula(){
		rota.setOrigem(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(rota);		
		RotaBC.getInstance().insert(rota);
	}
	
	/**
	 * Valida o destino nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarDestinoNula(){
		rota.setDestino(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(rota);		
		RotaBC.getInstance().insert(rota);
	}
	
	/**
	 * Valida a rota preenchida com espacos em branco
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarRotaEspacosBranco(){
		rota.setNome("                         ");
		rota.setDescricao("                         ");

		PrintUtils.imprimeNomeMetodoChamadorEClasse(rota);		
		RotaBC.getInstance().insert(rota);
	}	
	
	/**
	 * Valida a rota sem a descricao
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarRotaSemDescricao(){
		rota.setDescricao(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(rota);		
		RotaBC.getInstance().insert(rota);
	}
	
	/**
	 * Valida a rota sem o nome
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarRotaSemNome(){
		rota.setNome(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(rota);		
		RotaBC.getInstance().insert(rota);
	}
	
	/**
	 * Valida a rota completa
	 */
	@Test
	@Override
	public void criarRotaCompleta(){
		super.criarRotaCompleta();
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(rota);		
		RotaBC.getInstance().insert(rota);
	}
}
