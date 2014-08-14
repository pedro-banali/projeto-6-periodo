package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TestePassageiroLabModel {
	
	//////////////////////////////////////////
	// ATRIBUTOS
	//////////////////////////////////////////
	
	protected Passageiro passageiro;
	protected static Endereco endereco;
	
	//////////////////////////////////////////
	// METODO DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Test
	public void criarPassageiroCompleto(){
		passageiro = novoPassageiro1();
		
		//Verifica se o passageiro nao eh nulo
		Assert.assertNotNull(passageiro);
		
		//Verifica se o endereco do passageiro eh igual ao endereco
		Assert.assertEquals(passageiro.getEndereco(), endereco);
		
		
		
		passageiro = novoPassageiro2();
		
		//Verifica se o passageiro nao eh nulo
		Assert.assertNotNull(passageiro);
		
		//Verifica se o endereco do passageiro eh igual ao endereco
		Assert.assertEquals(passageiro.getEndereco(), endereco);
		
		
		
		passageiro = novoPassageiro3();
		
		//Verifica se o passageiro nao eh nulo
		Assert.assertNotNull(passageiro);
		
		//Verifica se o endereco do passageiro eh igual ao endereco
		Assert.assertEquals(passageiro.getEndereco(), endereco);
	}
	
	//////////////////////////////////////////
	// METODOS AUXILIARES
	//////////////////////////////////////////
	
	/**
	 * Metodo responsavel por criar um passageiro
	 */
	public static Passageiro novoPassageiro1(){
		endereco = TesteEnderecoLabModel.novoEndereco2();
		
		//Metodo que cria um novo passageiro
		Passageiro passageiro = new Passageiro(endereco);
		passageiro.setDataNascimento(new Date());
		passageiro.setDocumento("AABBCC");
		passageiro.setEmail("pass1@ticketaereosbsi.com.br");
		passageiro.setNome("Passageiro 1");
		passageiro.setNumeroCartao("12345-6");
		passageiro.setSenha("abc");
		passageiro.setTelefone("22334455");
		passageiro.setUsuario("pass1");
		
		return passageiro;
	}
	
	/**
	 * Metodo responsavel por criar um passageiro
	 */
	public static Passageiro novoPassageiro2(){
		endereco = TesteEnderecoLabModel.novoEndereco3();
		
		//Metodo que cria um novo passageiro
		Passageiro passageiro = new Passageiro(endereco);
		passageiro.setDataNascimento(new Date());
		passageiro.setDocumento("AABBCC");
		passageiro.setEmail("pass2@ticketaereosbsi.com.br");
		passageiro.setNome("Passageiro 2");
		passageiro.setNumeroCartao("12345-6");
		passageiro.setSenha("abc");
		passageiro.setTelefone("22334455");
		passageiro.setUsuario("pass2");
		
		return passageiro;
	}
	
	/**
	 * Metodo responsavel por criar um passageiro
	 */
	public static Passageiro novoPassageiro3(){
		endereco = TesteEnderecoLabModel.novoEndereco1();
		
		//Metodo que cria um novo passageiro
		Passageiro passageiro = new Passageiro(endereco);
		passageiro.setDataNascimento(new Date());
		passageiro.setDocumento("AABBCC");
		passageiro.setEmail("pass3@ticketaereosbsi.com.br");
		passageiro.setNome("Passageiro 3");
		passageiro.setNumeroCartao("12345-6");
		passageiro.setSenha("abc");
		passageiro.setTelefone("22334455");
		passageiro.setUsuario("pass3");
		
		return passageiro;
	}
	
}
