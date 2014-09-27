package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.queries;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PapelBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PassageiroBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.EnderecoEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PassageiroEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util.Verificador;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.DateUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

public class TestePassageiroLabQueries {

	@Test
	public void testFindAlleFindById(){
		List<Passageiro> passageiros = PassageiroBC.getInstance().findAll();
		
		//Verifica se a quantidade de cias Aereas a mesma dos testes de populate
		Assert.assertEquals(passageiros.size(), PassageiroEnum.values().length);
		
		for (Passageiro passageiroFindAll : passageiros) {
			Passageiro passageiroFindId = PassageiroBC.getInstance().findById(passageiroFindAll.getId());
			Verificador.verificar(passageiroFindAll, passageiroFindId);			
		}
		
		//buscando um id inexistente
		Passageiro passageiroIdInvalido = PassageiroBC.getInstance().findById(100000);
		Assert.assertNull(passageiroIdInvalido);
	}
	
	///////////////////////////////////////////////////////////
	// DADOS DO PAPEL
	///////////////////////////////////////////////////////////
		
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterNulo(){
		PassageiroBC.getInstance().findByFilter(null);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterVazio(){
		Passageiro filter = new Passageiro(new Endereco());
		PassageiroBC.getInstance().findByFilter(filter);
	}	
	
	@Test
	public void testFindByFilterDataNascimentoPassageiro(){
		Passageiro filter = new Passageiro(new Endereco());
		for (PassageiroEnum passageiroEnum : PassageiroEnum.values()) {
			filter.setDataNascimento(DateUtils.converterDate(passageiroEnum.getDataNascimento()));
			List<Passageiro> passageiroFilter = PassageiroBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(passageiroFilter.size(), 1);
			
			for (Passageiro passageiro : passageiroFilter) {
				Assert.assertEquals(DateUtils.minimizeDate(passageiro.getDataNascimento()),
						DateUtils.minimizeDate(DateUtils.converterDate(passageiroEnum.getDataNascimento())));				
			}
		}
	}
	
	@Test
	public void testFindByFilterDocumentoPassageiro(){
		Passageiro filter = new Passageiro(new Endereco());
		for (PassageiroEnum passageiroEnum : PassageiroEnum.values()) {
			filter.setDocumento(passageiroEnum.getDocumento());
			List<Passageiro> passageiroFilter = PassageiroBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(passageiroFilter.size(), 1);
			
			for (Passageiro passageiro : passageiroFilter) {
				Assert.assertEquals(passageiro.getDocumento(), passageiroEnum.getDocumento());				
			}
		}
	}
	
	@Test
	public void testFindByFilterEmailPassageiro(){
		Passageiro filter = new Passageiro(new Endereco());
		for (PassageiroEnum passageiroEnum : PassageiroEnum.values()) {
			filter.setEmail(passageiroEnum.getEmail());
			List<Passageiro> passageiroFilter = PassageiroBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(passageiroFilter.size(), 1);
			
			for (Passageiro passageiro : passageiroFilter) {
				Assert.assertEquals(passageiro.getEmail(), passageiroEnum.getEmail());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterNomePassageiro(){
		Passageiro filter = new Passageiro(new Endereco());
		for (PassageiroEnum passageiroEnum : PassageiroEnum.values()) {
			filter.setNome(passageiroEnum.getNome());
			List<Passageiro> passageiroFilter = PassageiroBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(passageiroFilter.size(), 1);
			
			for (Passageiro passageiro : passageiroFilter) {
				Assert.assertEquals(passageiro.getNome(), passageiroEnum.getNome());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterNumeroCartaoPassageiro(){
		Passageiro filter = new Passageiro(new Endereco());
		for (PassageiroEnum passageiroEnum : PassageiroEnum.values()) {
			filter.setNumeroCartao(passageiroEnum.getNumeroCartao());
			List<Passageiro> passageiroFilter = PassageiroBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(passageiroFilter.size(), 1);
			
			for (Passageiro passageiro : passageiroFilter) {
				Assert.assertEquals(passageiro.getNumeroCartao(), passageiroEnum.getNumeroCartao());				
			}
		}
	}
		
	@Test
	public void testFindByFilterTelefonePassageiro(){
		Passageiro filter = new Passageiro(new Endereco());
		for (PassageiroEnum passageiroEnum : PassageiroEnum.values()) {
			filter.setTelefone(passageiroEnum.getTelefone());
			List<Passageiro> passageiroFilter = PassageiroBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(passageiroFilter.size(), 1);
			
			for (Passageiro passageiro : passageiroFilter) {
				Assert.assertEquals(passageiro.getTelefone(), passageiroEnum.getTelefone());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterUsuarioPassageiro(){
		Passageiro filter = new Passageiro(new Endereco());
		for (PassageiroEnum passageiroEnum : PassageiroEnum.values()) {
			filter.setUsuario(passageiroEnum.getUsuario());
			List<Passageiro> passageiroFilter = PassageiroBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(passageiroFilter.size(), 1);
			
			for (Passageiro passageiro : passageiroFilter) {
				Assert.assertEquals(passageiro.getUsuario(), passageiroEnum.getUsuario());				
			}
		}
	}	
	
	///////////////////////////////////////////////////////////
	// DADOS DO ENDERECO
	///////////////////////////////////////////////////////////
	
	@Test
	public void testFindByFilterRuaEndereco(){
		Passageiro filter = new Passageiro(new Endereco());
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setRua(enderecoEnum.getRua());
			List<Passageiro> passageiroFilter = PassageiroBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(passageiroFilter.size(), 1);
			
			for (Passageiro passageiro : passageiroFilter) {
				Assert.assertEquals(passageiro.getEndereco().getRua(), enderecoEnum.getRua());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterNumeroEndereco(){
		Passageiro filter = new Passageiro(new Endereco());
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setNumero(enderecoEnum.getNumero());
			List<Passageiro> passageiroFilter = PassageiroBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 6
			Assert.assertEquals(passageiroFilter.size(), 6);
			
			for (Passageiro passageiro : passageiroFilter) {
				Assert.assertEquals(passageiro.getEndereco().getNumero(), enderecoEnum.getNumero());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterComplementoEndereco(){
		Passageiro filter = new Passageiro(new Endereco());
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setComplemento(enderecoEnum.getComplemento());
			List<Passageiro> passageiroFilter = PassageiroBC.getInstance().findByFilter(filter);
			
			for (Passageiro passageiro : passageiroFilter) {
				Assert.assertEquals(passageiro.getEndereco().getComplemento(), enderecoEnum.getComplemento());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterBairroEndereco(){
		Passageiro filter = new Passageiro(new Endereco());
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setBairro(enderecoEnum.getBairro());
			List<Passageiro> passageiroFilter = PassageiroBC.getInstance().findByFilter(filter);
			
			for (Passageiro passageiro : passageiroFilter) {
				Assert.assertEquals(passageiro.getEndereco().getBairro(), enderecoEnum.getBairro());				
			}
		}
	}
	
	@Test
	public void testFindByFilterCidadeEndereco(){
		Passageiro filter = new Passageiro(new Endereco());
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setCidade(enderecoEnum.getCidade());
			List<Passageiro> passageiroFilter = PassageiroBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(passageiroFilter.size(), 1);
			
			for (Passageiro passageiro : passageiroFilter) {
				Assert.assertEquals(passageiro.getEndereco().getCidade(), enderecoEnum.getCidade());				
			}
		}
	}
	
	@Test
	public void testFindByFilterEstadoEndereco(){
		Passageiro filter = new Passageiro(new Endereco());
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setEstado(enderecoEnum.getEstado());
			List<Passageiro> passageiroFilter = PassageiroBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(passageiroFilter.size(), 1);
			
			for (Passageiro passageiro : passageiroFilter) {
				Assert.assertEquals(passageiro.getEndereco().getEstado(), enderecoEnum.getEstado());				
			}
		}
	}
	
	@Test
	public void testFindByFilterPaisEndereco(){
		Passageiro filter = new Passageiro(new Endereco());
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setPais(enderecoEnum.getPais());
			List<Passageiro> passageiroFilter = PassageiroBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(passageiroFilter.size(), 6);
			
			for (Passageiro passageiro : passageiroFilter) {
				Assert.assertEquals(passageiro.getEndereco().getPais(), enderecoEnum.getPais());				
			}
		}
	}
}
