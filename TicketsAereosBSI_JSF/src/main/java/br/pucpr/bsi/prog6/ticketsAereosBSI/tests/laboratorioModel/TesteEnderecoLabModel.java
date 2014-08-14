package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */
public class TesteEnderecoLabModel {
	
	//////////////////////////////////////////
	// ATRIBUTOS
	//////////////////////////////////////////
	protected Endereco endereco; 
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Test
	public void criarEnderecoCompleto(){
		//Cria um novo endereco
		endereco = novoEndereco1();
		//Verifica se o endereco nao eh nulo
		Assert.assertNotNull(endereco);
		
		//Cria um novo endereco
		endereco = novoEndereco2();
		//Verifica se o endereco nao eh nulo
		Assert.assertNotNull(endereco);
		
		//Cria um novo endereco
		endereco = novoEndereco3();
		//Verifica se o endereco nao eh nulo
		Assert.assertNotNull(endereco);
	}
	
	//////////////////////////////////////////
	// METODOS AUXILIARES
	//////////////////////////////////////////
	
	/**
	 * Metodo para criar um novo endereco
	 * @return
	 */
	public static Endereco novoEndereco1(){
		Endereco endereco = new Endereco();
		endereco.setBairro("Afonso Pena");
		endereco.setCidade("Sao Jose dos Pinhais");
		endereco.setComplemento("Casa 10");
		endereco.setEstado("Parana");
		endereco.setNumero(200);
		endereco.setPais("Brasil");
		endereco.setRua("Afonso Pereira");
		return endereco;
	}
	
	/**
	 * Metodo para criar no novo endereco
	 * @return
	 */
	public static Endereco novoEndereco2(){
		Endereco endereco = new Endereco();
		endereco.setBairro("Cabral");
		endereco.setCidade("Curitiba");
		endereco.setComplemento("Casa 10");
		endereco.setEstado("Parana");
		endereco.setNumero(340);
		endereco.setPais("Brasil");
		endereco.setRua("Alberto Ferreira");
		return endereco;
	}
	
	/**
	 * Metodo para criar no novo endereco
	 * @return
	 */
	public static Endereco novoEndereco3(){
		Endereco endereco = new Endereco();
		endereco.setBairro("Batel");
		endereco.setCidade("Curitiba");
		endereco.setComplemento("Casa 10");
		endereco.setEstado("Parana");
		endereco.setNumero(345);
		endereco.setPais("Brasil");
		endereco.setRua("Rua do Batel");
		return endereco;
	}
}
