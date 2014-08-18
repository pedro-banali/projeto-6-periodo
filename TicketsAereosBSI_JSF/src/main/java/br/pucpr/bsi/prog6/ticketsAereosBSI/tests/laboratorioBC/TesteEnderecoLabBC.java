package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC;

import org.junit.Before;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.EnderecoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel.TesteEnderecoLabModel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.PrintUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TesteEnderecoLabBC extends TesteEnderecoLabModel {
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Before
	public void criarEndereco(){
		endereco = novoEndereco1();
	}
	
	/**
	 * Valida o endereco nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarEnderecoNulo(){
		endereco = null;
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(endereco);		
		EnderecoBC.getInstance().insert(endereco);
	}
	
	/**
	 * Valida o endereco preenchido com espaços em branco
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarEnderecoEspacosBranco(){
		endereco = new Endereco();
		endereco.setBairro("                         ");
		endereco.setCidade("                         ");
		endereco.setComplemento("                    ");
		endereco.setEstado("                         ");
		endereco.setNumero(0);
		endereco.setPais("                           ");
		endereco.setRua("                            ");

		PrintUtils.imprimeNomeMetodoChamadorEClasse(endereco);		
		EnderecoBC.getInstance().insert(endereco);
	}	
	
	/**
	 * Valida o endereco sem o nome da rua
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarEnderecoSemRua(){
		endereco.setRua(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(endereco);		
		EnderecoBC.getInstance().insert(endereco);
	}
	
	/**
	 * Valida o endereco sem o numero
	 * Como aqui numero eh um tipo primitivo sera setado o 0, indicando que
	 * este nao foi modificado
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarEnderecoSemNumero(){
		endereco.setNumero(0);

		PrintUtils.imprimeNomeMetodoChamadorEClasse(endereco);		
		EnderecoBC.getInstance().insert(endereco);
	}
	
	/**
	 * Valida o endereco com o numero negativo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarEnderecoComNumeroNegativo(){
		endereco.setNumero(-200);

		PrintUtils.imprimeNomeMetodoChamadorEClasse(endereco);		
		EnderecoBC.getInstance().insert(endereco);
	}
	
	/**
	 * Valida o endereco sem complemento
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarEnderecoSemComplemento(){
		endereco.setComplemento(null);

		PrintUtils.imprimeNomeMetodoChamadorEClasse(endereco);		
		EnderecoBC.getInstance().insert(endereco);
	}
	
	/**
	 * Valida o endereco sem bairro
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarEnderecoSemBairro(){
		endereco.setBairro(null);

		PrintUtils.imprimeNomeMetodoChamadorEClasse(endereco);		
		EnderecoBC.getInstance().insert(endereco);
	}
	
	/**
	 * Valida o endereco sem cidade
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarEnderecoSemCidade(){
		endereco.setCidade(null);

		PrintUtils.imprimeNomeMetodoChamadorEClasse(endereco);		
		EnderecoBC.getInstance().insert(endereco);
	}
	
	/**
	 * Valida o endereco sem estado
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarEnderecoSemEstado(){
		endereco.setEstado(null);

		PrintUtils.imprimeNomeMetodoChamadorEClasse(endereco);		
		EnderecoBC.getInstance().insert(endereco);
	}
	
	/**
	 * Valida o endereco sem pais
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarEnderecoSemPais(){
		endereco.setPais(null);

		PrintUtils.imprimeNomeMetodoChamadorEClasse(endereco);		
		EnderecoBC.getInstance().insert(endereco);
	}
	
	/**
	 * Valida o endereco completo
	 */
	@Test
	@Override
	public void criarEnderecoCompleto(){
		super.criarEnderecoCompleto();
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(endereco);		
		EnderecoBC.getInstance().insert(endereco);
	}
}
