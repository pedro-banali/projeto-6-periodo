package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioDAO;

import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.RotaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC.TesteRotaLabBC;
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

public class TesteRotaLabDAO extends TesteRotaLabBC {
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	/**
	 * Valida a rota completa
	 */
	@Test
	@Override
	public void criarRotaCompleta(){
		
		//Para nao ocorrer problemas na base de dados de constraint violation
		CiaAereaBC.getInstance().insert(rota.getCiaAerea());
		AeroportoBC.getInstance().insert(rota.getOrigem());
		AeroportoBC.getInstance().insert(rota.getDestino());
		
		////////////////////////
		// INSERT
		////////////////////////
		PrintUtils.imprimeNomeMetodoChamadorEClasse(rota);		
		Long idRota = RotaBC.getInstance().insert(rota);

		//Verifica se o id eh maior que zero
		Assert.assertTrue(idRota > 0);
		//Verifica se os Ids sao iguais
		Assert.assertEquals(idRota, rota.getId());
		
		//Imprime para verificar se o id foi inserido dentro do objeto rota
		PrintUtils.imprimeNomeMetodoChamadorEClasse(rota);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(RotaBC.getInstance().findById(idRota), rota);		
	}
	
	/**
	 * Valida o atributo Rota como se esta com FecthType Lazy
	 */
	@Test(expected = LazyInitializationException.class)
	public void validarCiaAereaLazy(){
		criarRotaCompleta();
		
		//Obtem o objeto do BD para as comparacoes basicas
		CiaAerea ciaAereaBD = CiaAereaBC.getInstance().findById(rota.getCiaAerea().getId());
		
		//Exception de Lazy
		ciaAereaBD.getRotas().get(0);
	}
	
	
	/**
	 * Valida o rota completo
	 */
	@Test
	public void updateRotaCompleto(){
		criarRotaCompleta();
		
		//Atualiza objeto
		Atualizador.atualizarRota(rota, "Update EN - ");
		
		//Atualiza o BD
		RotaBC.getInstance().update(rota);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(RotaBC.getInstance().findById(rota.getId()), rota);		
	}
	
	/**
	 * Valida o rota completo
	 */
	@Test
	public void deleteRotaCompleto(){
		criarRotaCompleta();

		//Imprime para verificar se o rota foi atualizado
		PrintUtils.imprimeNomeMetodoChamadorEClasse(rota);
		
		//Deleta o rota do BD
		RotaBC.getInstance().delete(rota);
		Assert.assertNull(RotaBC.getInstance().findById(rota.getId()));
	}
}
