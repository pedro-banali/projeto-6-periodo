package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioDAO;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AviaoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.BagagemBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.BilheteBCFactory;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.HorarioBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PassageiroBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.RotaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC.TesteBagagemLabBC;
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

public class TesteBagagemLabDAO extends TesteBagagemLabBC{
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	/**
	 * Valida a bagagem completa
	 */
	@SuppressWarnings("unchecked")
	@Test
	@Override
	public void criarBagagemCompleta(){
		
		//Para nao ocorrer problemas na base de dados de constraint violation
		CiaAereaBC.getInstance().insert(bilhete.getHorario().getRota().getCiaAerea());
		AeroportoBC.getInstance().insert(bilhete.getHorario().getRota().getOrigem());
		AeroportoBC.getInstance().insert(bilhete.getHorario().getRota().getDestino());
		RotaBC.getInstance().insert(bilhete.getHorario().getRota());
		AviaoBC.getInstance().insert(bilhete.getHorario().getAviao());
		PassageiroBC.getInstance().insert(bilhete.getPassageiro());
		HorarioBC.getInstance().insert(bilhete.getHorario());
		BilheteBCFactory.getInstanceBC(bagagem.getBilhete().getTipoBilheteEnum()).insert(bagagem.getBilhete());
		

		PrintUtils.imprimeNomeMetodoChamadorEClasse(bagagem);		
		Long idBagagem = BagagemBC.getInstance().insert(bagagem);

		//Verifica se o id eh maior que zero
		Assert.assertTrue(idBagagem > 0);
		//Verifica se os Ids sao iguais
		Assert.assertEquals(idBagagem, bagagem.getId());
		
		//Imprime para verificar se o id foi inserido dentro do objeto bagagem
		PrintUtils.imprimeNomeMetodoChamadorEClasse(bagagem);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(BagagemBC.getInstance().findById(idBagagem), bagagem);		
	}
	
	/**
	 * Valida o bagagem completo
	 */
	@Test
	public void updateBagagemCompleto(){
		criarBagagemCompleta();
		
		//Atualiza objeto
		Atualizador.atualizarBagagem(bagagem, "Update EN - ");
		
		//Atualiza o BD
		BagagemBC.getInstance().update(bagagem);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(BagagemBC.getInstance().findById(bagagem.getId()), bagagem);		
	}
	
	/**
	 * Valida o bagagem completo
	 */
	@Test
	public void deleteBagagemCompleto(){
		criarBagagemCompleta();

		//Imprime para verificar se o bagagem foi atualizado
		PrintUtils.imprimeNomeMetodoChamadorEClasse(bagagem);
		
		//Deleta o bagagem do BD
		BagagemBC.getInstance().delete(bagagem);
		Assert.assertNull(BagagemBC.getInstance().findById(bagagem.getId()));
	}
}
