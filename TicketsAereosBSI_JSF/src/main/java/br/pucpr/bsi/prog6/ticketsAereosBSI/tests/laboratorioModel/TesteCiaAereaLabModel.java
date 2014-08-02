package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;



/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */
public class TesteCiaAereaLabModel {
	
	//////////////////////////////////////////
	// ATRIBUTOS
	//////////////////////////////////////////
	protected CiaAerea ciaAerea; 
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Test
	public void criarCiaAereaCompleta(){
		//Cria uma nova CiaAerea
		ciaAerea = novaCiaAerea1();
		//Verifica se nao eh nulo
		Assert.assertNotNull(ciaAerea);
		
		//Cria uma nova CiaAerea
		ciaAerea = novaCiaAerea2();
		//Verifica se nao eh nulo
		Assert.assertNotNull(ciaAerea);
		
		//Cria uma nova CiaAerea
		ciaAerea = novaCiaAerea3();
		//Verifica se nao eh nulo
		Assert.assertNotNull(ciaAerea);
	}
	
	//////////////////////////////////////////
	// METODOS AUXILIARES
	//////////////////////////////////////////
	
	/**
	 * Metodo para criar uma nova Cia Aerea
	 * @return
	 */
	public static CiaAerea novaCiaAerea1(){
		CiaAerea ciaAerea = new CiaAerea();
		ciaAerea.setNome("TAM");
		return ciaAerea;
	}
	
	/**
	 * Metodo para criar uma nova Cia Aerea
	 * @return
	 */
	public static CiaAerea novaCiaAerea2(){
		CiaAerea ciaAerea = new CiaAerea();
		ciaAerea.setNome("GOL");
		return ciaAerea;
	}
	
	/**
	 * Metodo para criar uma nova Cia Aerea
	 * @return
	 */
	public static CiaAerea novaCiaAerea3(){
		CiaAerea ciaAerea = new CiaAerea();
		ciaAerea.setNome("AZUL");
		return ciaAerea;
	}
	
}
