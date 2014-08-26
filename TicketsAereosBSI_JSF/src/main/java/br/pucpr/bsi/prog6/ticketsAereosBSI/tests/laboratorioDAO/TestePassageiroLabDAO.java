package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioDAO;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.EnderecoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PassageiroBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC.TestePassageiroLabBC;
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

public class TestePassageiroLabDAO extends TestePassageiroLabBC{
	
	/**
	 * Metodo responsavel por criar uma passageiro completa
	 */
	@Test
	@Override
	public void criarPassageiroCompleto(){
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);		
		Long idPassageiro = PassageiroBC.getInstance().insert(passageiro);

		//Verifica se o id eh maior que zero
		Assert.assertTrue(idPassageiro > 0);
		//Verifica se os Ids sao iguais
		Assert.assertEquals(idPassageiro, passageiro.getId());
		
		//Imprime para verificar se o id foi inserido dentro do objeto endereco
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(PassageiroBC.getInstance().findById(idPassageiro), passageiro);
	}
	
	/**
	 * Metodo responsavel por atualizar uma passageiro completa
	 */
	@Test
	public void updatePassageiroCompleto(){
		criarPassageiroCompleto();
		
		//Atualiza passageiro
		Atualizador.atualizarPassageiro(passageiro, "UP");
		
		//Atualiza o BD
		PassageiroBC.getInstance().update(passageiro);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(PassageiroBC.getInstance().findById(passageiro.getId()), passageiro);
	}
	
	/**
	 * Metodo responsavel por deletar uma passageiro completa
	 */
	@Test
	public void deletarPassageiroCompleto(){
		criarPassageiroCompleto();

		//Imprime para verificar se o id foi inserido dentro do objeto
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);
		
		PassageiroBC.getInstance().delete(passageiro);
		Assert.assertNull(PassageiroBC.getInstance().findById(passageiro.getId()));
		
		//Verifica se o cascade remove foi executado com sucesso
		Assert.assertNull(EnderecoBC.getInstance().findById(passageiro.getEndereco().getId()));
	}
}