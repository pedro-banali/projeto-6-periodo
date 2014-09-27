package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.queries;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AviaoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.CiaAereaEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util.Verificador;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

public class TesteAviaoLabQueries {

	@Test
	public void testFindAlleFindById(){
		List<Aviao> avioes = AviaoBC.getInstance().findAll();
		
		//Verifica se a quantidade de cias Aereas a mesma dos testes de populate
		Assert.assertEquals(avioes.size(), AviaoEnum.values().length);
		
		for (Aviao aviaoFindAll : avioes) {
			Aviao aviaoFindId = AviaoBC.getInstance().findById(aviaoFindAll.getId());
			Verificador.verificar(aviaoFindAll, aviaoFindId);			
		}
		
		//buscando um id inexistente
		Aviao aviaoIdInvalido = AviaoBC.getInstance().findById(100000);
		Assert.assertNull(aviaoIdInvalido);
	}
	
	///////////////////////////////////////////////////////////
	// DADOS DO AVIAO
	///////////////////////////////////////////////////////////
		
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterNulo(){
		AviaoBC.getInstance().findByFilter(null);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterVazio(){
		Aviao filter = new Aviao(new CiaAerea());
		AviaoBC.getInstance().findByFilter(filter);
	}
	
	@Test
	public void testFindByFilterCodigo(){
		Aviao filter = new Aviao(new CiaAerea());
		for (AviaoEnum aviaoEnum : AviaoEnum.values()) {
			filter.setCodigo(aviaoEnum.getCodigo());
			List<Aviao> aviaoFilter = AviaoBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(aviaoFilter.size(), 1);
			
			for (Aviao aviao : aviaoFilter) {
				Assert.assertEquals(aviao.getCodigo(), aviaoEnum.getCodigo());				
			}
			
		}
	}
	
	@Test
	public void testFindByFilterCarga(){
		Aviao filter = new Aviao(new CiaAerea());
		for (AviaoEnum aviaoEnum : AviaoEnum.getCargaValues()) {
			filter.setCarga(aviaoEnum.getCarga());
			List<Aviao> aviaoFilter = AviaoBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 30
			Assert.assertEquals(aviaoFilter.size(), 30);
			
			for (Aviao aviao : aviaoFilter) {
				Assert.assertEquals(aviao.getCarga(), aviaoEnum.getCarga(),0);
			}
		}
	}
	
	@Test
	public void testFindByFilterNomeCiaAerea(){
		Aviao filter = new Aviao(new CiaAerea());
		for (CiaAereaEnum ciaAereaEnum : CiaAereaEnum.values()) {
			filter.getCiaAerea().setNome(ciaAereaEnum.getNome());
			List<Aviao> aviaoFilter = AviaoBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 30
			Assert.assertEquals(aviaoFilter.size(), 30);
			
			for (Aviao aviao : aviaoFilter) {
				Assert.assertEquals(aviao.getCiaAerea().getNome(), ciaAereaEnum.getNome());
			}
		}
	}
}
