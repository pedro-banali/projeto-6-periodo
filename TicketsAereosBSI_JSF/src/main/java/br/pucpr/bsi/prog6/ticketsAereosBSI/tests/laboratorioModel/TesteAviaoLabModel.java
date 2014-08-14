package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */
public class TesteAviaoLabModel {
	
	//////////////////////////////////////////
	// ATRIBUTOS
	//////////////////////////////////////////
	protected Aviao aviao; 
	protected static CiaAerea ciaAerea;
	
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Test
	public void criarAviaoCompleto(){
		//Cria uma nova Aviao
		aviao = novoAviao1();
		//Verifica se nao eh nulo
		Assert.assertNotNull(aviao);
		//Verifica se a ciaAerea do aviao eh igual a ciaAerea
		Assert.assertEquals(aviao.getCiaAerea(), ciaAerea);
		Assert.assertTrue(ciaAerea.getAvioes().contains(aviao));

		
		//Cria uma nova Aviao
		aviao = novoAviao2();
		//Verifica se nao eh nulo
		Assert.assertNotNull(aviao);
		//Verifica se a ciaAerea do aviao eh igual a ciaAerea
		Assert.assertEquals(aviao.getCiaAerea(), ciaAerea);
		Assert.assertTrue(ciaAerea.getAvioes().contains(aviao));
		
		//Cria uma nova Aviao
		aviao = novoAviao3();
		//Verifica se nao eh nulo
		Assert.assertNotNull(aviao);
		//Verifica se a ciaAerea do aviao eh igual a ciaAerea
		Assert.assertEquals(aviao.getCiaAerea(), ciaAerea);
		Assert.assertTrue(ciaAerea.getAvioes().contains(aviao));
	}
	
	//////////////////////////////////////////
	// METODOS AUXILIARES
	//////////////////////////////////////////
	
	/**
	 * Metodo para criar uma nova Cia Aerea
	 * @return
	 */
	public static Aviao novoAviao1(){
		ciaAerea = TesteCiaAereaLabModel.novaCiaAerea1();
		Aviao aviao = new Aviao(ciaAerea);
		aviao.setCodigo("AV0001");
		aviao.setCarga(10000.00);
		return aviao;
	}
	
	/**
	 * Metodo para criar uma nova Cia Aerea
	 * @return
	 */
	public static Aviao novoAviao2(){
		ciaAerea = TesteCiaAereaLabModel.novaCiaAerea2();
		Aviao aviao = new Aviao(ciaAerea);
		aviao.setCodigo("AV0002");
		aviao.setCarga(20000.00);
		return aviao;
	}
	
	/**
	 * Metodo para criar uma nova Cia Aerea
	 * @return
	 */
	public static Aviao novoAviao3(){
		ciaAerea = TesteCiaAereaLabModel.novaCiaAerea3();
		Aviao aviao = new Aviao(ciaAerea);
		aviao.setCodigo("AV0003");
		aviao.setCarga(30000.00);
		return aviao;
	}
	
}
