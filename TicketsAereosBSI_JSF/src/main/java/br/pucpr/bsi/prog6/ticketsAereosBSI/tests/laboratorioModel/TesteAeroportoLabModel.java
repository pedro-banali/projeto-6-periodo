package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TesteAeroportoLabModel {
	
	//////////////////////////////////////////
	// ATRIBUTOS
	//////////////////////////////////////////
	
	protected Aeroporto aeroporto;
	protected static Endereco endereco;
	
	//////////////////////////////////////////
	// METODO DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Test
	public void criarAeroportoCompleto(){
		aeroporto = novoAeroporto1();
		
		//Verifica se o aeroporto nao eh nulo
		Assert.assertNotNull(aeroporto);
		
		//Verifica se o endereco do aeroporto eh igual ao endereco
		Assert.assertEquals(aeroporto.getEndereco(), endereco);
		
		
		aeroporto = novoAeroporto2();
		
		//Verifica se o aeroporto nao eh nulo
		Assert.assertNotNull(aeroporto);
		
		//Verifica se o endereco do aeroporto eh igual ao endereco
		Assert.assertEquals(aeroporto.getEndereco(), endereco);
		
		
		aeroporto = novoAeroporto3();
		
		//Verifica se o aeroporto nao eh nulo
		Assert.assertNotNull(aeroporto);
		
		//Verifica se o endereco do aeroporto eh igual ao endereco
		Assert.assertEquals(aeroporto.getEndereco(), endereco);
		
	}
	
	//////////////////////////////////////////
	// METODOS AUXILIARES
	//////////////////////////////////////////
	
	public static Aeroporto novoAeroporto1(){
		endereco = TesteEnderecoLabModel.novoEndereco1();
		
		//Metodo que cria um novo aeroporto
		Aeroporto aeroporto = new Aeroporto(endereco);
		aeroporto.setCodigo("CGH");
		aeroporto.setNome("Congonhas");
		
		return aeroporto;
	}
	
	public static Aeroporto novoAeroporto2(){
		endereco = TesteEnderecoLabModel.novoEndereco2();
		
		//Metodo que cria um novo aeroporto
		Aeroporto aeroporto = new Aeroporto(endereco);
		aeroporto.setCodigo("CWB");
		aeroporto.setNome("Curitiba");
		
		return aeroporto;
	}
	
	public static Aeroporto novoAeroporto3(){
		endereco = TesteEnderecoLabModel.novoEndereco3();
		
		//Metodo que cria um novo aeroporto
		Aeroporto aeroporto = new Aeroporto(endereco);
		aeroporto.setCodigo("BSB");
		aeroporto.setNome("Brasilia");
		
		return aeroporto;
	}
}
