package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.queries;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.BilheteBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.BilheteBCFactory;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PassageiroBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PassageiroEnum;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

public abstract class TesteBilheteLabQueries<T extends Bilhete> {
	
	@SuppressWarnings("unchecked")
	protected BilheteBC<T> bilheteBC = BilheteBCFactory.getInstanceBC(getTipoBilheteEnum());
	
	/**
	 * Metodo a ser implementado nos testes das filhas
	 * @return
	 */
	public abstract TipoBilheteEnum getTipoBilheteEnum();
	
	@Test
	public void testFindAlleFindById(){
		List<T> bilhetes = bilheteBC.findAll();
		
		//Verifica se a quantidade de bilhetes eh a mesma produzida pelo insert
		Assert.assertEquals(bilhetes.size(), 1980);
		
		//buscando um id inexistente
		Bilhete horarioIdInvalido = bilheteBC.findById(100000);
		Assert.assertNull(horarioIdInvalido);
	}
	
	///////////////////////////////////////////////////////////
	// DADOS DA RESERVA DE BILHETE
	///////////////////////////////////////////////////////////
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testReservarBilheteWithoutIdBilhete(){
		bilheteBC.reservarBilhete(null, null, null);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testReservarBilheteWithoutPassageiro(){
		bilheteBC.reservarBilhete(10L, null, null);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testReservarBilheteWithoutAssento(){
		Passageiro filtroPassageiro = new Passageiro(new Endereco());
		filtroPassageiro.setNome(PassageiroEnum.PASSAGEIRO_01.getNome());
		filtroPassageiro.setDocumento(PassageiroEnum.PASSAGEIRO_01.getDocumento());
		List<Passageiro> passageiros = PassageiroBC.getInstance().findByFilter(filtroPassageiro);
		
		bilheteBC.reservarBilhete(10L, passageiros.get(0), null);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testReservarBilheteComBilheteReservado(){
		//Busca um bilhete com situacao RESERVADO
		Bilhete bilhete = null;
		for(int i = 0; i < 5940; i++){
			bilhete = bilheteBC.findById(i);
			if(bilhete != null && SituacaoBilheteEnum.RESERVADO.equals(bilhete.getSituacaoEnum())){
				break;
			}
		}
		
		Passageiro filtroPassageiro = new Passageiro(new Endereco());
		filtroPassageiro.setNome(PassageiroEnum.PASSAGEIRO_01.getNome());
		filtroPassageiro.setDocumento(PassageiroEnum.PASSAGEIRO_01.getDocumento());
		List<Passageiro> passageiros = PassageiroBC.getInstance().findByFilter(filtroPassageiro);
		
		bilheteBC.reservarBilhete(bilhete.getId(), passageiros.get(0), bilhete.getAssento());
	}	
	
	
	///////////////////////////////////////////////////////////
	// DADOS DA COMPRA DE BILHETE
	///////////////////////////////////////////////////////////
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testComprarBilheteWithoutIdBilhete(){
		bilheteBC.comprarBilhete(null);
	}
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testComprarBilheteComBilheteVendido(){
		//Busca um bilhete com situacao RESERVADO
		Bilhete bilhete = null;
		for(int i = 0; i < 5940; i++){
			bilhete = bilheteBC.findById(i);
			if(bilhete != null && SituacaoBilheteEnum.VENDIDO.equals(bilhete.getSituacaoEnum())){
				break;
			}
		}
		
		bilheteBC.comprarBilhete(bilhete.getId());
	}	
	
	
}
