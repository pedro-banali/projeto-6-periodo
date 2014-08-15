package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioDAO;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBCC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC.TesteCiaAereaLabBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util.Atualizador;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util.Verificador;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.PrintUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TesteCiaAereaLabDAO extends TesteCiaAereaLabBC {
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	/**
	 * Valida a ciaAerea completa
	 */
	@Test
	@Override
	public void criarCiaAereaCompleta(){
		
		////////////////////////
		// INSERT
		////////////////////////
		PrintUtils.imprimeNomeMetodoChamadorEClasse(ciaAerea);		
		Long idCiaAerea = CiaAereaBCC.getInstance().insert(ciaAerea);

		//Verifica se o id eh maior que zero
		Assert.assertTrue(idCiaAerea > 0);
		//Verifica se os Ids sao iguais
		Assert.assertEquals(idCiaAerea, ciaAerea.getId());
		
		//Imprime para verificar se o id foi inserido dentro do objeto ciaAerea
		PrintUtils.imprimeNomeMetodoChamadorEClasse(ciaAerea);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(CiaAereaBCC.getInstance().findById(idCiaAerea), ciaAerea);		
	}
	
	/**
	 * Valida o ciaAerea completo
	 */
	@Test
	public void updateCiaAereaCompleto(){
		PrintUtils.imprimeNomeMetodoChamadorEClasse(ciaAerea);		
		long idCiaAerea = CiaAereaBCC.getInstance().insert(ciaAerea);
		
		//Atualiza objeto
		Atualizador.atualizarCiaAerea(ciaAerea, "Update EN - ");
		
		//Atualiza o BD
		CiaAereaBCC.getInstance().update(ciaAerea);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(CiaAereaBCC.getInstance().findById(idCiaAerea), ciaAerea);		
	}
	
	/**
	 * Valida o ciaAerea completo
	 */
	@Test
	public void deleteCiaAereaCompleto(){
		PrintUtils.imprimeNomeMetodoChamadorEClasse(ciaAerea);		
		long idCiaAerea = CiaAereaBCC.getInstance().insert(ciaAerea);

		//Imprime para verificar se o ciaAerea foi atualizado
		PrintUtils.imprimeNomeMetodoChamadorEClasse(ciaAerea);
		
		//Deleta o ciaAerea do BD
		CiaAereaBCC.getInstance().delete(ciaAerea);
		Assert.assertNull(CiaAereaBCC.getInstance().findById(idCiaAerea));
	}
}
