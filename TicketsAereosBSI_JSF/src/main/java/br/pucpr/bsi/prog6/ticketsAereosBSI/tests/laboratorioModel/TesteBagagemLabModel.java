package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBagagemEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bagagem;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TesteBagagemLabModel {
	
	//////////////////////////////////////////
	// ATRIBUTOS
	//////////////////////////////////////////
	
	protected Bagagem bagagem;
	protected static Bilhete bilhete;
	
	//////////////////////////////////////////
	// METODO DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Test
	public void criarBagagemCompleta(){
		bagagem = novaBagagemEconomica();
		Assert.assertNotNull(bagagem);
		Assert.assertEquals(bagagem.getBilhete(), bilhete);
		Assert.assertTrue(bilhete.getBagagens().contains(bagagem));
		Assert.assertTrue(TipoBagagemEnum.MAO.equals(bagagem.getTipoBagagemEnum()));
		
		
		bagagem = novaBagagemExecutiva();
		Assert.assertNotNull(bagagem);
		Assert.assertEquals(bagagem.getBilhete(), bilhete);
		Assert.assertTrue(bilhete.getBagagens().contains(bagagem));
		Assert.assertTrue(TipoBagagemEnum.NACIONAL.equals(bagagem.getTipoBagagemEnum()));
		
		
		bagagem = novaBagagemPrimeira();
		Assert.assertNotNull(bagagem);
		Assert.assertEquals(bagagem.getBilhete(), bilhete);
		Assert.assertTrue(bilhete.getBagagens().contains(bagagem));
		Assert.assertTrue(TipoBagagemEnum.INTERNACIONAL.equals(bagagem.getTipoBagagemEnum()));
	}
	
	//////////////////////////////////////////
	// METODOS AUXILIARES
	//////////////////////////////////////////
	
	/**
	 * Metodo responsavel por criar um bagagem
	 */
	public static Bagagem novaBagagemEconomica(){
		bilhete = TesteEconomicaLabModel.novaEconomica1();
		
		//Metodo que cria um novo rota
		Bagagem bagagem = new Bagagem(TipoBagagemEnum.MAO, bilhete);
		bagagem.setPeso(4.5);
		
		return bagagem;
	}
	
	/**
	 * Metodo responsavel por criar um bagagem
	 */
	public static Bagagem novaBagagemExecutiva(){
		bilhete = TesteExecutivaLabModel.novaExecutiva1();
		
		//Metodo que cria um novo rota
		Bagagem bagagem = new Bagagem(TipoBagagemEnum.NACIONAL, bilhete);
		bagagem.setPeso(20);
		
		return bagagem;
	}
	
	/**
	 * Metodo responsavel por criar um bagagem
	 */
	public static Bagagem novaBagagemPrimeira(){
		bilhete = TestePrimeiraLabModel.novaPrimeira1();
		
		//Metodo que cria um novo rota
		Bagagem bagagem = new Bagagem(TipoBagagemEnum.INTERNACIONAL, bilhete);
		bagagem.setPeso(30);
		
		return bagagem;
	}
	
}

