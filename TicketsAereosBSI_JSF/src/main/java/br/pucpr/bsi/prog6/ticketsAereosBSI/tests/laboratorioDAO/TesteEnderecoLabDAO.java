package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioDAO;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.EnderecoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC.TesteEnderecoLabBC;
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

public class TesteEnderecoLabDAO extends TesteEnderecoLabBC {
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	/**
	 * Valida o endereco completo
	 */
	@Test
	@Override
	public void criarEnderecoCompleto(){
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(endereco);		
		Long idEndereco = EnderecoBC.getInstance().insert(endereco);

		//Verifica se o id eh maior que zero
		Assert.assertTrue(idEndereco > 0);
		//Verifica se os Ids sao iguais
		Assert.assertEquals(idEndereco, endereco.getId());
		
		//Imprime para verificar se o id foi inserido dentro do objeto endereco
		PrintUtils.imprimeNomeMetodoChamadorEClasse(endereco);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(EnderecoBC.getInstance().findById(idEndereco), endereco);		
	}
	
	/**
	 * Valida o endereco completo
	 */
	@Test
	public void updateEnderecoCompleto(){
		criarEnderecoCompleto();
		
		//Atualiza objeto
		Atualizador.atualizarEndereco(endereco, "Update EN - ");
		
		//Atualiza o BD
		EnderecoBC.getInstance().update(endereco);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(EnderecoBC.getInstance().findById(endereco.getId()), endereco);		
	}
	
	/**
	 * Valida o endereco completo
	 */
	@Test
	public void deleteEnderecoCompleto(){
		criarEnderecoCompleto();

		//Imprime para verificar se o endereco foi atualizado
		PrintUtils.imprimeNomeMetodoChamadorEClasse(endereco);
		
		//Deleta o endereco do BD
		EnderecoBC.getInstance().delete(endereco);
		Assert.assertNull(EnderecoBC.getInstance().findById(endereco.getId()));
	}
			
	
	
}
