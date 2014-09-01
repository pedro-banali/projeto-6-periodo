package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioDAO;

import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PapelBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC.TestePapelLabBC;
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

public class TestePapelLabDAO extends TestePapelLabBC {
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	/**
	 * Valida a papel completa
	 */
	@Test
	@Override
	public void criarPapelCompleto(){
		
		//Para nao ocorrer problemas na base de dados de constraint violation
		CiaAereaBC.getInstance().insert(papel.getCiaAerea());
		

		PrintUtils.imprimeNomeMetodoChamadorEClasse(papel);		
		Long idPapel = PapelBC.getInstance().insert(papel);

		//Verifica se o id eh maior que zero
		Assert.assertTrue(idPapel > 0);
		//Verifica se os Ids sao iguais
		Assert.assertEquals(idPapel, papel.getId());
		
		//Imprime para verificar se o id foi inserido dentro do objeto papel
		PrintUtils.imprimeNomeMetodoChamadorEClasse(papel);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(PapelBC.getInstance().findById(idPapel), papel);		
	}
	
	/**
	 * Valida o atributo Papel como se esta com FecthType Lazy
	 */
	@Test(expected = LazyInitializationException.class)
	public void validarCiaAereaLazy(){
		criarPapelCompleto();
		
		//Obtem o objeto do BD para as comparacoes basicas
		CiaAerea ciaAereaBD = CiaAereaBC.getInstance().findById(papel.getCiaAerea().getId());
		
		//Exception de Lazy
		ciaAereaBD.getPapeis().get(0);
	}
	
	
	/**
	 * Valida o papel completo
	 */
	@Test
	public void updatePapelCompleto(){
		criarPapelCompleto();
		
		//Atualiza objeto
		Atualizador.atualizarPapel(papel, "Update EN - ");
		
		//Atualiza o BD
		PapelBC.getInstance().update(papel);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(PapelBC.getInstance().findById(papel.getId()), papel);		
	}
	
	/**
	 * Valida o papel completo
	 */
	@Test
	public void deletePapelCompleto(){
		criarPapelCompleto();

		//Imprime para verificar se o papel foi atualizado
		PrintUtils.imprimeNomeMetodoChamadorEClasse(papel);
		
		//Deleta o papel do BD
		PapelBC.getInstance().delete(papel);
		Assert.assertNull(PapelBC.getInstance().findById(papel.getId()));
	}
}
