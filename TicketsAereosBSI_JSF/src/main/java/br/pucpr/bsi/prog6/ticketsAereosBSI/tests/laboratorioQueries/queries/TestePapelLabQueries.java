package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.queries;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PapelBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.CiaAereaEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PapelEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util.Verificador;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

public class TestePapelLabQueries {

	@Test
	public void testFindAlleFindById(){
		List<Papel> papeis = PapelBC.getInstance().findAll();
		
		//Verifica se a quantidade de cias Aereas a mesma dos testes de populate
		Assert.assertEquals(papeis.size(), PapelEnum.values().length);
		
		for (Papel papelFindAll : papeis) {
			Papel papelFindId = PapelBC.getInstance().findById(papelFindAll.getId());
			Verificador.verificar(papelFindAll, papelFindId);			
		}
		
		//buscando um id inexistente
		Papel papelIdInvalido = PapelBC.getInstance().findById(100000);
		Assert.assertNull(papelIdInvalido);
	}
	
	///////////////////////////////////////////////////////////
	// DADOS DO PAPEL
	///////////////////////////////////////////////////////////
		
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterNulo(){
		PapelBC.getInstance().findByFilter(null);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterVazio(){
		Papel filter = new Papel(new CiaAerea());
		PapelBC.getInstance().findByFilter(filter);
	}	
	
	@Test
	public void testFindByFilterNome(){
		Papel filter = new Papel(new CiaAerea());
		for (PapelEnum papelEnum : PapelEnum.values()) {
			filter.setNome(papelEnum.getNome());
			List<Papel> papelFilter = PapelBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(papelFilter.size(), 1);
			
			for (Papel papel : papelFilter) {
				Assert.assertEquals(papel.getNome(), papelEnum.getNome());				
			}
		}
	}
	
	@Test
	public void testFindByFilterDescricao(){
		Papel filter = new Papel(new CiaAerea());
		for (PapelEnum papelEnum : PapelEnum.values()) {
			filter.setDescricao(papelEnum.getDescricao());
			List<Papel> papelFilter = PapelBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(papelFilter.size(), 1);
			
			for (Papel papel : papelFilter) {
				Assert.assertEquals(papel.getDescricao(), papelEnum.getDescricao());
			}
		}
	}
	
	@Test
	public void testFindByFilterNomeCiaAerea(){
		Papel filter = new Papel(new CiaAerea());
		for (CiaAereaEnum ciaAereaEnum : CiaAereaEnum.values()) {
			filter.getCiaAerea().setNome(ciaAereaEnum.getNome());
			List<Papel> papelFilter = PapelBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 3
			Assert.assertEquals(papelFilter.size(), 3);
			
			for (Papel papel : papelFilter) {
				Assert.assertEquals(papel.getCiaAerea().getNome(), ciaAereaEnum.getNome());
			}
		}
	}
}
