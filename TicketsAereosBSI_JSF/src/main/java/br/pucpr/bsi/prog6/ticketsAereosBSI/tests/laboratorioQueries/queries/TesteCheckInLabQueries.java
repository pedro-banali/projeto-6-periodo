package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.queries;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.BagagemBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.BilheteBCFactory;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBagagemEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bagagem;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BagagemEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

public class TesteCheckInLabQueries {
	
	@Test
	public void testFindAlleFindById(){
		List<Bagagem> bagagens = BagagemBC.getInstance().findAll();
		
		//Verifica se a quantidade de bilhetes eh a mesma produzida pelo insert
		Assert.assertEquals(bagagens.size(), BagagemEnum.values().length);
		
		//buscando um id inexistente
		Bagagem bagagemIdInvalido = BagagemBC.getInstance().findById(100000);
		Assert.assertNull(bagagemIdInvalido);
	}
	
	///////////////////////////////////////////////////////////
	// DADOS DO CHECKIN
	///////////////////////////////////////////////////////////
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testCheckInWithoutIdBilhete(){
		BagagemBC.getInstance().realizarCheckIn(null, null, null, null);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testCheckInWithoutPassageiro(){
		Bilhete bilhete = null;
		for(int i = 1; i < BilheteEnum.values().length; i++){
			bilhete = (Bilhete) BilheteBCFactory.getInstanceBC(TipoBilheteEnum.ECONOMICA).findById(i);
			if(bilhete != null && bilhete.getPassageiro() == null){
				break;
			}
		}
		BagagemBC.getInstance().realizarCheckIn(bilhete.getId(), bilhete.getTipoBilheteEnum(), TipoBagagemEnum.MAO, 2D);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testCheckInBilheteNaoVendido(){
		Bilhete bilhete = null;
		for(int i = 1; i < BilheteEnum.values().length; i++){
			bilhete = (Bilhete) BilheteBCFactory.getInstanceBC(TipoBilheteEnum.ECONOMICA).findById(i);
			if(bilhete != null && !SituacaoBilheteEnum.VENDIDO.equals(bilhete.getSituacaoEnum())){
				break;
			}
		}
		BagagemBC.getInstance().realizarCheckIn(bilhete.getId(), bilhete.getTipoBilheteEnum(), TipoBagagemEnum.MAO, 2D);
	}	
	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testReservarBilheteComBagagemAcimaPermitido(){
		//Busca um bilhete com situacao RESERVADO
		Bagagem bagagem = null;
		for(int i = 1; i < BilheteEnum.values().length; i++){
			bagagem = BagagemBC.getInstance().findById(i);
			Bilhete bilhete = bagagem.getBilhete();
			if(bilhete != null && bilhete.getBagagens().size() == bilhete.getMaxBagagens()){
				break;
			}
		}
		BagagemBC.getInstance().realizarCheckIn(bagagem.getBilhete().getId(), bagagem.getBilhete().getTipoBilheteEnum(), TipoBagagemEnum.MAO, 2D);
	}	
}
