package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.queries;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AeroportoEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.EnderecoEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util.Verificador;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

public class TesteAeroportoLabQueries {

	@Test
	public void testFindAlleFindById(){
		List<Aeroporto> aeroportos = AeroportoBC.getInstance().findAll();
		
		//Verifica se a quantidade de aeroportos a mesma dos testes de populate
		Assert.assertEquals(aeroportos.size(), AeroportoEnum.values().length);
		
		for (Aeroporto aeroportoFindAll : aeroportos) {
			Aeroporto aeroportoFindId = AeroportoBC.getInstance().findById(aeroportoFindAll.getId());
			Verificador.verificar(aeroportoFindAll, aeroportoFindId);			
		}
		
		//buscando um id inexistente
		Aeroporto aeroportoIdInvalido = AeroportoBC.getInstance().findById(100000);
		Assert.assertNull(aeroportoIdInvalido);
	}
	
	///////////////////////////////////////////////////////////
	// DADOS DO AEROPORTO
	///////////////////////////////////////////////////////////
	
	@Test
	public void testFindByFilterCodigoAeroporto(){
		Aeroporto filter = new Aeroporto(new Endereco());
		for (AeroportoEnum aeroportoEnum : AeroportoEnum.values()) {
			filter.setCodigo(aeroportoEnum.getCodigo());
			List<Aeroporto> aeroportoFilter = AeroportoBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(aeroportoFilter.size(), 1);
			
			for (Aeroporto aeroporto : aeroportoFilter) {
				Assert.assertEquals(aeroporto.getCodigo(), aeroportoEnum.getCodigo());				
			}
		}
	}
	
	@Test
	public void testFindByFilterNomeAeroporto(){
		Aeroporto filter = new Aeroporto(new Endereco());
		for (AeroportoEnum aeroportoEnum : AeroportoEnum.values()) {
			filter.setNome(aeroportoEnum.getNome());
			List<Aeroporto> aeroportoFilter = AeroportoBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(aeroportoFilter.size(), 1);
			
			for (Aeroporto aeroporto : aeroportoFilter) {
				Assert.assertEquals(aeroporto.getNome(), aeroportoEnum.getNome());				
			}
		}
	}	
	
	///////////////////////////////////////////////////////////
	// DADOS DO ENDERECO
	///////////////////////////////////////////////////////////
	
	@Test
	public void testFindByFilterRuaEndereco(){
		Aeroporto filter = new Aeroporto(new Endereco());
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setRua(enderecoEnum.getRua());
			List<Aeroporto> aeroportoFilter = AeroportoBC.getInstance().findByFilter(filter);
			
			for (Aeroporto aeroporto : aeroportoFilter) {
				Assert.assertEquals(aeroporto.getEndereco().getRua(), enderecoEnum.getRua());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterNumeroEndereco(){
		Aeroporto filter = new Aeroporto(new Endereco());
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setNumero(enderecoEnum.getNumero());
			List<Aeroporto> aeroportoFilter = AeroportoBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(aeroportoFilter.size(), 6);
			
			for (Aeroporto aeroporto : aeroportoFilter) {
				Assert.assertEquals(aeroporto.getEndereco().getNumero(), enderecoEnum.getNumero());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterComplementoEndereco(){
		Aeroporto filter = new Aeroporto(new Endereco());
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setComplemento(enderecoEnum.getComplemento());
			List<Aeroporto> aeroportoFilter = AeroportoBC.getInstance().findByFilter(filter);
			
			for (Aeroporto aeroporto : aeroportoFilter) {
				Assert.assertEquals(aeroporto.getEndereco().getComplemento(), enderecoEnum.getComplemento());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterBairroEndereco(){
		Aeroporto filter = new Aeroporto(new Endereco());
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setBairro(enderecoEnum.getBairro());
			List<Aeroporto> aeroportoFilter = AeroportoBC.getInstance().findByFilter(filter);
			
			for (Aeroporto aeroporto : aeroportoFilter) {
				Assert.assertEquals(aeroporto.getEndereco().getBairro(), enderecoEnum.getBairro());				
			}
		}
	}
	
	@Test
	public void testFindByFilterCidadeEndereco(){
		Aeroporto filter = new Aeroporto(new Endereco());
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setCidade(enderecoEnum.getCidade());
			List<Aeroporto> aeroportoFilter = AeroportoBC.getInstance().findByFilter(filter);
			
			for (Aeroporto aeroporto : aeroportoFilter) {
				Assert.assertEquals(aeroporto.getEndereco().getCidade(), enderecoEnum.getCidade());				
			}
		}
	}
	
	@Test
	public void testFindByFilterEstadoEndereco(){
		Aeroporto filter = new Aeroporto(new Endereco());
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setEstado(enderecoEnum.getEstado());
			List<Aeroporto> aeroportoFilter = AeroportoBC.getInstance().findByFilter(filter);
			
			for (Aeroporto aeroporto : aeroportoFilter) {
				Assert.assertEquals(aeroporto.getEndereco().getEstado(), enderecoEnum.getEstado());				
			}
		}
	}
	
	@Test
	public void testFindByFilterPaisEndereco(){
		Aeroporto filter = new Aeroporto(new Endereco());
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setPais(enderecoEnum.getPais());
			List<Aeroporto> aeroportoFilter = AeroportoBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(aeroportoFilter.size(), 6);
			
			for (Aeroporto aeroporto : aeroportoFilter) {
				Assert.assertEquals(aeroporto.getEndereco().getPais(), enderecoEnum.getPais());				
			}
		}
	}
}
