package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.queries;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.FuncionarioBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Funcionario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.CiaAereaEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.EnderecoEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.FuncionarioEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PapelEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util.Verificador;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.DateUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

public class TesteFuncionarioLabQueries {

	@Test
	public void testFindAlleFindById(){
		List<Funcionario> funcionarios = FuncionarioBC.getInstance().findAll();
		
		//Verifica se a quantidade de cias Aereas a mesma dos testes de populate
		Assert.assertEquals(funcionarios.size(), FuncionarioEnum.values().length);
		
		for (Funcionario funcionarioFindAll : funcionarios) {
			Funcionario funcionarioFindId = FuncionarioBC.getInstance().findById(funcionarioFindAll.getId());
			Verificador.verificar(funcionarioFindAll, funcionarioFindId);			
		}
		
		//buscando um id inexistente
		Funcionario funcionarioIdInvalido = FuncionarioBC.getInstance().findById(100000);
		Assert.assertNull(funcionarioIdInvalido);
	}
	
	///////////////////////////////////////////////////////////
	// DADOS DO FUNCIONARIO
	///////////////////////////////////////////////////////////
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterNulo(){
		FuncionarioBC.getInstance().findByFilter(null);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterVazio(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		FuncionarioBC.getInstance().findByFilter(filter);
	}	
	
	@Test
	public void testFindByFilterCodigoFuncionario(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		for (FuncionarioEnum funcionarioEnum : FuncionarioEnum.values()) {
			filter.setCodigo(funcionarioEnum.getCodigo());
			List<Funcionario> funcionarioFilter = FuncionarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(funcionarioFilter.size(), 1);
			
			for (Funcionario funcionario : funcionarioFilter) {
				Assert.assertEquals(funcionario.getCodigo(), funcionarioEnum.getCodigo());				
			}
		}
	}
	
	@Test
	public void testFindByFilterContaCorrenteFuncionario(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		for (FuncionarioEnum funcionarioEnum : FuncionarioEnum.values()) {
			filter.setContaCorrente(funcionarioEnum.getContaCorrente());
			List<Funcionario> funcionarioFilter = FuncionarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(funcionarioFilter.size(), 1);
			
			for (Funcionario funcionario : funcionarioFilter) {
				Assert.assertEquals(funcionario.getContaCorrente(), funcionarioEnum.getContaCorrente());				
			}
		}
	}
		
	@Test
	public void testFindByFilterDataNascimentoFuncionario(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		for (FuncionarioEnum funcionarioEnum : FuncionarioEnum.values()) {
			filter.setDataNascimento(DateUtils.converterDate(funcionarioEnum.getDataNascimento()));
			List<Funcionario> funcionarioFilter = FuncionarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(funcionarioFilter.size(), 1);
			
			for (Funcionario funcionario : funcionarioFilter) {
				Assert.assertEquals(DateUtils.minimizeDate(funcionario.getDataNascimento()),
						DateUtils.minimizeDate(DateUtils.converterDate(funcionarioEnum.getDataNascimento())));				
			}
		}
	}
	
	@Test
	public void testFindByFilterEmailFuncionario(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		for (FuncionarioEnum funcionarioEnum : FuncionarioEnum.values()) {
			filter.setEmail(funcionarioEnum.getEmail());
			List<Funcionario> funcionarioFilter = FuncionarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(funcionarioFilter.size(), 1);
			
			for (Funcionario funcionario : funcionarioFilter) {
				Assert.assertEquals(funcionario.getEmail(), funcionarioEnum.getEmail());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterNomeFuncionario(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		for (FuncionarioEnum funcionarioEnum : FuncionarioEnum.values()) {
			filter.setNome(funcionarioEnum.getNome());
			List<Funcionario> funcionarioFilter = FuncionarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(funcionarioFilter.size(), 1);
			
			for (Funcionario funcionario : funcionarioFilter) {
				Assert.assertEquals(funcionario.getNome(), funcionarioEnum.getNome());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterTelefoneFuncionario(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		for (FuncionarioEnum funcionarioEnum : FuncionarioEnum.values()) {
			filter.setTelefone(funcionarioEnum.getTelefone());
			List<Funcionario> funcionarioFilter = FuncionarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(funcionarioFilter.size(), 1);
			
			for (Funcionario funcionario : funcionarioFilter) {
				Assert.assertEquals(funcionario.getTelefone(), funcionarioEnum.getTelefone());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterUsuarioFuncionario(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		for (FuncionarioEnum funcionarioEnum : FuncionarioEnum.values()) {
			filter.setUsuario(funcionarioEnum.getUsuario());
			List<Funcionario> funcionarioFilter = FuncionarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(funcionarioFilter.size(), 1);
			
			for (Funcionario funcionario : funcionarioFilter) {
				Assert.assertEquals(funcionario.getUsuario(), funcionarioEnum.getUsuario());				
			}
		}
	}	
	
	///////////////////////////////////////////////////////////
	// DADOS DO PAPEL
	///////////////////////////////////////////////////////////
	
	@Test
	public void testFindByFilterPapel(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		for (PapelEnum papelEnum : PapelEnum.values()) {
			filter.getPapel().setNome(papelEnum.getNome());
			List<Funcionario> funcionarioFilter = FuncionarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(funcionarioFilter.size(), 1);
			
			for (Funcionario funcionario : funcionarioFilter) {
				Assert.assertEquals(funcionario.getPapel().getNome(), papelEnum.getNome());				
			}
		}
	}	
	
	///////////////////////////////////////////////////////////
	// DADOS DA CIA AEREA
	///////////////////////////////////////////////////////////
	
	@Test
	public void testFindByFilterNomeCiaAerea(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		for (CiaAereaEnum ciaAereaEnum : CiaAereaEnum.values()) {
			filter.getPapel().getCiaAerea().setNome(ciaAereaEnum.getNome());
			List<Funcionario> funcionarioFilter = FuncionarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 3
			Assert.assertEquals(funcionarioFilter.size(), 3);
			
			for (Funcionario funcionario : funcionarioFilter) {
				Assert.assertEquals(funcionario.getPapel().getCiaAerea().getNome(), ciaAereaEnum.getNome());				
			}
		}
	}
	
	///////////////////////////////////////////////////////////
	// DADOS DO ENDERECO
	///////////////////////////////////////////////////////////
	
	@Test
	public void testFindByFilterRuaEndereco(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setRua(enderecoEnum.getRua());
			List<Funcionario> funcionarioFilter = FuncionarioBC.getInstance().findByFilter(filter);
			
			for (Funcionario funcionario : funcionarioFilter) {
				Assert.assertEquals(funcionario.getEndereco().getRua(), enderecoEnum.getRua());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterNumeroEndereco(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setNumero(enderecoEnum.getNumero());
			List<Funcionario> funcionarioFilter = FuncionarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(funcionarioFilter.size(), 9);
			
			for (Funcionario funcionario : funcionarioFilter) {
				Assert.assertEquals(funcionario.getEndereco().getNumero(), enderecoEnum.getNumero());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterComplementoEndereco(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setComplemento(enderecoEnum.getComplemento());
			List<Funcionario> funcionarioFilter = FuncionarioBC.getInstance().findByFilter(filter);
			
			for (Funcionario funcionario : funcionarioFilter) {
				Assert.assertEquals(funcionario.getEndereco().getComplemento(), enderecoEnum.getComplemento());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterBairroEndereco(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setBairro(enderecoEnum.getBairro());
			List<Funcionario> funcionarioFilter = FuncionarioBC.getInstance().findByFilter(filter);
			
			for (Funcionario funcionario : funcionarioFilter) {
				Assert.assertEquals(funcionario.getEndereco().getBairro(), enderecoEnum.getBairro());				
			}
		}
	}
	
	@Test
	public void testFindByFilterCidadeEndereco(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setCidade(enderecoEnum.getCidade());
			List<Funcionario> funcionarioFilter = FuncionarioBC.getInstance().findByFilter(filter);
			
			for (Funcionario funcionario : funcionarioFilter) {
				Assert.assertEquals(funcionario.getEndereco().getCidade(), enderecoEnum.getCidade());				
			}
		}
	}
	
	@Test
	public void testFindByFilterEstadoEndereco(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setEstado(enderecoEnum.getEstado());
			List<Funcionario> funcionarioFilter = FuncionarioBC.getInstance().findByFilter(filter);
			
			for (Funcionario funcionario : funcionarioFilter) {
				Assert.assertEquals(funcionario.getEndereco().getEstado(), enderecoEnum.getEstado());				
			}
		}
	}
	
	@Test
	public void testFindByFilterPaisEndereco(){
		Funcionario filter = new Funcionario(new Endereco(), new Papel(new CiaAerea()));
		for (EnderecoEnum enderecoEnum : EnderecoEnum.values()) {
			filter.getEndereco().setPais(enderecoEnum.getPais());
			List<Funcionario> funcionarioFilter = FuncionarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(funcionarioFilter.size(), 9);
			
			for (Funcionario funcionario : funcionarioFilter) {
				Assert.assertEquals(funcionario.getEndereco().getPais(), enderecoEnum.getPais());				
			}
		}
	}
}
