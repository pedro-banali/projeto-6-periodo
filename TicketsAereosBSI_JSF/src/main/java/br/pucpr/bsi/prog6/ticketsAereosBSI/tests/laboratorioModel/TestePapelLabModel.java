package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */
public class TestePapelLabModel {
	
	//////////////////////////////////////////
	// ATRIBUTOS
	//////////////////////////////////////////
	protected Papel papel;
	protected static CiaAerea ciaAerea;
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Test
	public void criarPapelCompleto(){
		//Cria um novo papel
		papel = novoPapel1();
		//Verifica se o papel nao eh nulo
		Assert.assertNotNull(papel);
		//Verifica se a ciaAerea do papel eh igual a ciaAerea
		Assert.assertEquals(papel.getCiaAerea(), ciaAerea);
		Assert.assertTrue(ciaAerea.getPapeis().contains(papel));
		
		//Cria um novo papel
		papel = novoPapel2();
		//Verifica se o papel nao eh nulo
		Assert.assertNotNull(papel);
		//Verifica se a ciaAerea do papel eh igual a ciaAerea
		Assert.assertEquals(papel.getCiaAerea(), ciaAerea);
		Assert.assertTrue(ciaAerea.getPapeis().contains(papel));
		
		//Cria um novo papel
		papel = novoPapel3();
		//Verifica se o papel nao eh nulo
		Assert.assertNotNull(papel);
		//Verifica se a ciaAerea do papel eh igual a ciaAerea
		Assert.assertEquals(papel.getCiaAerea(), ciaAerea);
		Assert.assertTrue(ciaAerea.getPapeis().contains(papel));
	}
	
	//////////////////////////////////////////
	// METODOS AUXILIARES
	//////////////////////////////////////////
	
	/**
	 * Metodo para criar um novo papel
	 * @return
	 */
	public static Papel novoPapel1(){
		ciaAerea = TesteCiaAereaLabModel.novaCiaAerea1();
		Papel papel = new Papel(ciaAerea);
		papel.setNome("Comissario");
		papel.setDescricao("Realiza servicos a bordo");
		return papel;
	}
	
	/**
	 * Metodo para criar um novo papel
	 * @return
	 */
	public static Papel novoPapel2(){
		ciaAerea = TesteCiaAereaLabModel.novaCiaAerea1();
		Papel papel = new Papel(ciaAerea);
		papel.setNome("Piloto");
		papel.setDescricao("Realiza a decolagem e aterrisagem do aviao");
		return papel;
	}
	
	/**
	 * Metodo para criar um novo papel
	 * @return
	 */
	public static Papel novoPapel3(){
		ciaAerea = TesteCiaAereaLabModel.novaCiaAerea1();
		Papel papel = new Papel(ciaAerea);
		papel.setNome("Faxineiro");
		papel.setDescricao("Realiza a faxina de rotina ap�s um voo");
		return papel;
	}
}
