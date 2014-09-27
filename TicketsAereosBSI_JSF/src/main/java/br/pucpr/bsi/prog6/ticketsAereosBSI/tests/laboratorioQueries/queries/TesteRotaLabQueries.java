package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.queries;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PapelBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.RotaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AeroportoEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.CiaAereaEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util.Verificador;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

public class TesteRotaLabQueries {

	@Test
	public void testFindAlleFindById(){
		List<Rota> rotas = RotaBC.getInstance().findAll();
		
		//Verifica se a quantidade de rota eh a mesma dos testes de populate
		Assert.assertEquals(rotas.size(), RotaEnum.values().length);
		
		for (Rota rotaFindAll : rotas) {
			Rota rotaFindId = RotaBC.getInstance().findById(rotaFindAll.getId());
			Verificador.verificar(rotaFindAll, rotaFindId);			
		}
		
		//buscando um id inexistente
		Rota rotaIdInvalido = RotaBC.getInstance().findById(100000);
		Assert.assertNull(rotaIdInvalido);
	}
	
	///////////////////////////////////////////////////////////
	// DADOS DA ROTA
	///////////////////////////////////////////////////////////
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterNulo(){
		RotaBC.getInstance().findByFilter(null);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterVazio(){
		Rota filter = new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco()));
		RotaBC.getInstance().findByFilter(filter);
	}		
	
	@Test
	public void testFindByFilterNomeRota(){
		Rota filter = new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco()));
		for (RotaEnum rotaEnum : RotaEnum.values()) {
			filter.setNome(rotaEnum.getNome());
			List<Rota> rotaFilter = RotaBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(rotaFilter.size(), 1);
			
			for (Rota rota : rotaFilter) {
				Assert.assertEquals(rota.getNome(), rotaEnum.getNome());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterDescricaoRota(){
		Rota filter = new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco()));
		for (RotaEnum rotaEnum : RotaEnum.values()) {
			filter.setDescricao(rotaEnum.getDescricao());
			List<Rota> rotaFilter = RotaBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(rotaFilter.size(), 1);
			
			for (Rota rota : rotaFilter) {
				Assert.assertEquals(rota.getDescricao(), rotaEnum.getDescricao());				
			}
		}
	}
	
	///////////////////////////////////////////////////////////
	// DADOS DO CIAAEREA
	///////////////////////////////////////////////////////////
	@Test
	public void testFindByFilterCiaAerea(){
		Rota filter = new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco()));
		for (CiaAereaEnum ciaAereaEnum : CiaAereaEnum.values()) {
			filter.getCiaAerea().setNome(ciaAereaEnum.getNome());
			List<Rota> rotaFilter = RotaBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(rotaFilter.size(), 30);
			
			for (Rota rota : rotaFilter) {
				Assert.assertEquals(rota.getCiaAerea().getNome(), ciaAereaEnum.getNome());				
			}
		}
	}
	
	
	
	///////////////////////////////////////////////////////////
	// DADOS DO AEROPORTO
	///////////////////////////////////////////////////////////
	
	@Test
	public void testFindByFilterNomeOrigem(){
		Rota filter = new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco()));
		for (AeroportoEnum aeroportoEnum : AeroportoEnum.values()) {
			filter.getOrigem().setNome(aeroportoEnum.getNome());
			List<Rota> rotaFilter = RotaBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 15
			Assert.assertEquals(rotaFilter.size(), 15);
			
			for (Rota rota : rotaFilter) {
				Assert.assertEquals(rota.getOrigem().getNome(), aeroportoEnum.getNome());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterCidadeOrigem(){
		Rota filter = new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco()));
		for (AeroportoEnum aeroportoEnum : AeroportoEnum.values()) {
			filter.getOrigem().getEndereco().setCidade(aeroportoEnum.getEnderecoEnum().getCidade());
			List<Rota> rotaFilter = RotaBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 15
			Assert.assertEquals(rotaFilter.size(), 15);
			
			for (Rota rota : rotaFilter) {
				Assert.assertEquals(rota.getOrigem().getEndereco().getCidade(), aeroportoEnum.getEnderecoEnum().getCidade());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterNomeDestino(){
		Rota filter = new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco()));
		for (AeroportoEnum aeroportoEnum : AeroportoEnum.values()) {
			filter.getDestino().setNome(aeroportoEnum.getNome());
			List<Rota> rotaFilter = RotaBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 15
			Assert.assertEquals(rotaFilter.size(), 15);
			
			for (Rota rota : rotaFilter) {
				Assert.assertEquals(rota.getDestino().getNome(), aeroportoEnum.getNome());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterCidadeDestino(){
		Rota filter = new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco()));
		for (AeroportoEnum aeroportoEnum : AeroportoEnum.values()) {
			filter.getDestino().getEndereco().setCidade(aeroportoEnum.getEnderecoEnum().getCidade());
			List<Rota> rotaFilter = RotaBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 15
			Assert.assertEquals(rotaFilter.size(), 15);
			
			for (Rota rota : rotaFilter) {
				Assert.assertEquals(rota.getDestino().getEndereco().getCidade(), aeroportoEnum.getEnderecoEnum().getCidade());				
			}
		}
	}	
}
