package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioDAO;

import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AviaoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC.TesteAviaoLabBC;
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

public class TesteAviaoLabDAO extends TesteAviaoLabBC {
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	/**
	 * Valida a aviao completa
	 */
	@Test
	@Override
	public void criarAviaoCompleto(){
		
		//Para nao ocorrer problemas na base de dados de constraint violation
		CiaAereaBC.getInstance().insert(aviao.getCiaAerea());
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(aviao);		
		Long idAviao = AviaoBC.getInstance().insert(aviao);

		//Verifica se o id eh maior que zero
		Assert.assertTrue(idAviao > 0);
		//Verifica se os Ids sao iguais
		Assert.assertEquals(idAviao, aviao.getId());
		
		//Imprime para verificar se o id foi inserido dentro do objeto aviao
		PrintUtils.imprimeNomeMetodoChamadorEClasse(aviao);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(AviaoBC.getInstance().findById(idAviao), aviao);		
	}
	
	
	/**
	 * Valida o atributo Aviao como se esta com FecthType Lazy
	 */
	@Test(expected = LazyInitializationException.class)
	public void validarCiaAereaLazy(){
		criarAviaoCompleto();
		
		//Obtem o objeto do BD para as comparacoes basicas
		CiaAerea ciaAereaBD = CiaAereaBC.getInstance().findById(aviao.getCiaAerea().getId());
		
		//Exception de Lazy
		ciaAereaBD.getAvioes().get(0);
	}
	
	/**
	 * Valida o aviao completo
	 */
	@Test
	public void updateAviaoCompleto(){
		criarAviaoCompleto();
		
		//Atualiza objeto
		Atualizador.atualizarAviao(aviao, "Update EN - ");
		
		//Atualiza o BD
		AviaoBC.getInstance().update(aviao);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(AviaoBC.getInstance().findById(aviao.getId()), aviao);		
	}
	
	/**
	 * Valida o aviao completo
	 */
	@Test
	public void deleteAviaoCompleto(){
		criarAviaoCompleto();

		//Imprime para verificar se o aviao foi atualizado
		PrintUtils.imprimeNomeMetodoChamadorEClasse(aviao);
		
		//Deleta o aviao do BD
		AviaoBC.getInstance().delete(aviao);
		Assert.assertNull(AviaoBC.getInstance().findById(aviao.getId()));
	}
}
