package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Funcionario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TesteFuncionarioLabModel {
	
	//////////////////////////////////////////
	// ATRIBUTOS
	//////////////////////////////////////////
	
	protected Funcionario funcionario;
	protected static Endereco endereco;
	protected static Papel papel;
	
	//////////////////////////////////////////
	// METODO DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Test
	public void criarFuncionarioCompleto(){
		funcionario = novoFuncionario();
		
		//Verifica se o funcionario nao eh nulo
		Assert.assertNotNull(funcionario);
		
		//Verifica se o endereco do funcionario eh igual ao endereco
		Assert.assertEquals(funcionario.getEndereco(), endereco);
		
		//Verifica se o papel do funcionario eh igual ao papel
		Assert.assertEquals(funcionario.getPapel(), papel);
		Assert.assertTrue(papel.getFuncionarios().contains(funcionario));
	}
	
	//////////////////////////////////////////
	// METODOS AUXILIARES
	//////////////////////////////////////////
	
	/**
	 * Metodo responsavel por criar um funcionario
	 */
	public static Funcionario novoFuncionario(){
		endereco = TesteEnderecoLabModel.novoEndereco1();
		papel = TestePapelLabModel.novoPapel1();
		
		//Metodo que cria um novo funcionario
		Funcionario funcionario = new Funcionario(endereco, papel);
		funcionario.setCodigo("AABBCC");
		funcionario.setContaCorrente("12345-6");
		funcionario.setDataNascimento(new Date());
		funcionario.setEmail("func1@ticketaereosbsi.com.br");
		funcionario.setNome("Funcionario 1");
		funcionario.setSenha("abc");
		funcionario.setTelefone("22334455");
		funcionario.setUsuario("func1");
		
		return funcionario;
	}
}
