package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TesteRotaLabModel {
	
	//////////////////////////////////////////
	// ATRIBUTOS
	//////////////////////////////////////////
	
	protected Rota rota;
	protected static CiaAerea ciaAerea;
	protected static Aeroporto origem;
	protected static Aeroporto destino;
	
	//////////////////////////////////////////
	// METODO DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Test
	public void criarRotaCompleta(){
		rota = novaRota1();
		Assert.assertNotNull(rota);
		
		Assert.assertEquals(rota.getCiaAerea(), ciaAerea);
		Assert.assertTrue(ciaAerea.getRotas().contains(rota));
		
		Assert.assertEquals(rota.getOrigem(), origem);
		Assert.assertEquals(rota.getDestino(), destino);

		
		
		rota = novaRota2();
		Assert.assertNotNull(rota);
		
		Assert.assertEquals(rota.getCiaAerea(), ciaAerea);
		Assert.assertTrue(ciaAerea.getRotas().contains(rota));
		
		Assert.assertEquals(rota.getOrigem(), origem);
		Assert.assertEquals(rota.getDestino(), destino);
		
		
		
		rota = novaRota3();
		Assert.assertNotNull(rota);
		
		Assert.assertEquals(rota.getCiaAerea(), ciaAerea);
		Assert.assertTrue(ciaAerea.getRotas().contains(rota));
		
		Assert.assertEquals(rota.getOrigem(), origem);
		Assert.assertEquals(rota.getDestino(), destino);
	}
	
	//////////////////////////////////////////
	// METODOS AUXILIARES
	//////////////////////////////////////////
	
	/**
	 * Metodo responsavel por criar uma rota
	 */
	public static Rota novaRota1(){
		ciaAerea = TesteCiaAereaLabModel.novaCiaAerea1();
		origem = TesteAeroportoLabModel.novoAeroporto1();
		destino = TesteAeroportoLabModel.novoAeroporto2();
		
		//Metodo que cria um novo rota
		Rota rota = new Rota(ciaAerea, origem, destino);
		rota.setDescricao("Rota Congonhas - Curitiba");
		rota.setNome("CGH-CWB");
		
		return rota;
	}
	
	/**
	 * Metodo responsavel por criar uma rota
	 */
	public static Rota novaRota2(){
		ciaAerea = TesteCiaAereaLabModel.novaCiaAerea2();
		origem = TesteAeroportoLabModel.novoAeroporto2();
		destino = TesteAeroportoLabModel.novoAeroporto3();
		
		//Metodo que cria um novo rota
		Rota rota = new Rota(ciaAerea, origem, destino);
		rota.setDescricao("Rota Curitiba - Brasilia");
		rota.setNome("CWB-BSB");
		
		return rota;
	}
	
	/**
	 * Metodo responsavel por criar uma rota
	 */
	public static Rota novaRota3(){
		ciaAerea = TesteCiaAereaLabModel.novaCiaAerea2();
		origem = TesteAeroportoLabModel.novoAeroporto2();
		destino = TesteAeroportoLabModel.novoAeroporto3();
		
		//Metodo que cria um novo rota
		Rota rota = new Rota(ciaAerea, origem, destino);
		rota.setDescricao("Rota Brasilia - Congonhas");
		rota.setNome("BSB-CGH");
		
		return rota;
	}
	
}
