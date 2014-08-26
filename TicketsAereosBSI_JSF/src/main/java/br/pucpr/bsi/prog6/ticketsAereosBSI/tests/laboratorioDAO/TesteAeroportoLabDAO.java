package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioDAO;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.EnderecoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC.TesteAeroportoLabBC;
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

public class TesteAeroportoLabDAO extends TesteAeroportoLabBC{
	
	/**
	 * Metodo responsavel por criar uma aeroporto completa
	 */
	@Test
	@Override
	public void criarAeroportoCompleto(){

		PrintUtils.imprimeNomeMetodoChamadorEClasse(aeroporto);		
		Long idAeroporto = AeroportoBC.getInstance().insert(aeroporto);

		//Verifica se o id eh maior que zero
		Assert.assertTrue(idAeroporto > 0);
		//Verifica se os Ids sao iguais
		Assert.assertEquals(idAeroporto, aeroporto.getId());
		
		//Imprime para verificar se o id foi inserido dentro do objeto endereco
		PrintUtils.imprimeNomeMetodoChamadorEClasse(aeroporto);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(AeroportoBC.getInstance().findById(idAeroporto), aeroporto);
	}
	
	/**
	 * Metodo responsavel por atualizar uma aeroporto completa
	 */
	@Test
	public void updateAeroportoCompleto(){
		criarAeroportoCompleto();
		
		//Atualiza aeroporto
		Atualizador.atualizarAeroporto(aeroporto, "UpdFU-");
		
		//Atualiza o BD
		AeroportoBC.getInstance().update(aeroporto);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(AeroportoBC.getInstance().findById(aeroporto.getId()), aeroporto);
	}
	
	/**
	 * Metodo responsavel por deletar uma aeroporto completa
	 */
	@Test
	public void deletarAeroportoCompleto(){
		criarAeroportoCompleto();

		//Imprime para verificar se o id foi inserido dentro do objeto
		PrintUtils.imprimeNomeMetodoChamadorEClasse(aeroporto);
		
		AeroportoBC.getInstance().delete(aeroporto);
		Assert.assertNull(AeroportoBC.getInstance().findById(aeroporto.getId()));
		
		//Verifica se o cascade remove foi executado com sucesso
		Assert.assertNull(EnderecoBC.getInstance().findById(aeroporto.getEndereco().getId()));
	}
}