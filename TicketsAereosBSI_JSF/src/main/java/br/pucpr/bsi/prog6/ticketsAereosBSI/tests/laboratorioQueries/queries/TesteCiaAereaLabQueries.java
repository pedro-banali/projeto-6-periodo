package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.queries;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AviaoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.CiaAereaEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util.Verificador;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

public class TesteCiaAereaLabQueries {

	@Test
	public void testFindAlleFindById(){
		List<CiaAerea> cias = CiaAereaBC.getInstance().findAll();
		
		//Verifica se a quantidade de cias Aereas a mesma dos testes de populate
		Assert.assertEquals(cias.size(), CiaAereaEnum.values().length);
		
		for (CiaAerea ciaAereaFindAll : cias) {
			CiaAerea ciaAereaFindId = CiaAereaBC.getInstance().findById(ciaAereaFindAll.getId());
			Verificador.verificar(ciaAereaFindAll, ciaAereaFindId);
		}
		
		//buscando um id inexistente
		CiaAerea ciaAereaIdInvalido = CiaAereaBC.getInstance().findById(100000);
		Assert.assertNull(ciaAereaIdInvalido);
	}
	
	///////////////////////////////////////////////////////////
	// DADOS DA CIAAEREA
	///////////////////////////////////////////////////////////
		
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterNulo(){
		CiaAereaBC.getInstance().findByFilter(null);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterVazio(){
		CiaAerea filter = new CiaAerea();
		CiaAereaBC.getInstance().findByFilter(filter);
	}	
	
	@Test
	public void testFindByFilterNome(){
		CiaAerea filter = new CiaAerea();
		for (CiaAereaEnum ciaAereaEnum : CiaAereaEnum.values()) {
			filter.setNome(ciaAereaEnum.getNome());
			List<CiaAerea> ciasFilter = CiaAereaBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(ciasFilter.size(), 1);
			
			//Nomes sao iguais
			Assert.assertEquals(ciasFilter.get(0).getNome(), ciaAereaEnum.getNome());
		}
	}
	
}
