package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.FuncionarioBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel.TesteFuncionarioLabModel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.PrintUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TesteFuncionarioLabBC extends TesteFuncionarioLabModel {
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Before
	public void criarFuncionario(){
		funcionario = novoFuncionario();
	}	
	
	/**
	 * Valida o funcionario nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarFuncionarioNulo(){
		funcionario = null;
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);
		FuncionarioBC.getInstance().insert(funcionario);
	}
	
	/**
	 * Valida o funcionario com endereco nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarFuncionarioEnderecoNulo(){
		funcionario.setEndereco(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);		
		FuncionarioBC.getInstance().insert(funcionario);
	}
	
	/**
	 * Valida o funcionario com papel nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarFuncionarioPapelNulo(){
		funcionario.setPapel(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);		
		FuncionarioBC.getInstance().insert(funcionario);
	}
	
	
	/**
	 * Valida o funcionario preenchido com espacos em branco
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarFuncionarioEspacosBranco(){
		funcionario.setCodigo("                               ");
		funcionario.setContaCorrente("                              ");
		funcionario.setEmail("                             ");
		funcionario.setNome("                              ");
		funcionario.setSenha("                             ");
		funcionario.setTelefone("                          ");
		funcionario.setUsuario("                             ");
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);		
		FuncionarioBC.getInstance().insert(funcionario);
	}
	
	/**
	 * Valida o funcionario sem codigo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarFuncionarioSemCodigo(){
		funcionario.setCodigo(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);		
		FuncionarioBC.getInstance().insert(funcionario);
	}
	
	/**
	 * Valida o funcionario sem conta corrente
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarFuncionarioSemContaCorrente(){
		funcionario.setContaCorrente(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);		
		FuncionarioBC.getInstance().insert(funcionario);
	}
	
	/**
	 * Valida o funcionario sem data nascimento
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarFuncionarioSemDataNascimento(){
		funcionario.setDataNascimento(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);		
		FuncionarioBC.getInstance().insert(funcionario);
	}
	
	/**
	 * Valida o funcionario com data nascimento apos a data atual
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarFuncionarioComDataNascimentoAposDataAtual(){
		funcionario.setDataNascimento(new Date(new Date().getTime()+40000000));
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);		
		FuncionarioBC.getInstance().insert(funcionario);
	}
	
	/**
	 * Valida o funcionario sem email
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarFuncionarioSemEmail(){
		funcionario.setEmail(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);		
		FuncionarioBC.getInstance().insert(funcionario);
	}
			
	/**
	 * Valida o funcionario sem @ no email
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarFuncionarioComEmailSemArroba(){
		funcionario.setEmail("func1ticketeventosbsi.com.br");
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);		
		FuncionarioBC.getInstance().insert(funcionario);
	}
	
	/**
	 * Valida o funcionario sem . apos o @ no email
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarFuncionarioComEmailSemPonto(){
		funcionario.setEmail("func.1@ticketeventosbsi");
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);		
		FuncionarioBC.getInstance().insert(funcionario);
	}
	
	/**
	 * Valida o funcionario sem nome
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarFuncionarioSemNome(){
		funcionario.setNome(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);		
		FuncionarioBC.getInstance().insert(funcionario);
	}
	
	/**
	 * Valida o funcionario sem senha
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarFuncionarioSemSenha(){
		funcionario.setSenha(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);		
		FuncionarioBC.getInstance().insert(funcionario);
	}
	
	/**
	 * Valida o funcionario sem telefone
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarFuncionarioSemTelefone(){
		funcionario.setTelefone(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);		
		FuncionarioBC.getInstance().insert(funcionario);
	}	
	
	/**
	 * Valida o funcionario sem user
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarFuncionarioSemUsuario(){
		funcionario.setUsuario(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);		
		FuncionarioBC.getInstance().insert(funcionario);
	}
	
	/**
	 * Metodo responsavel por criar um funcionario completo
	 */
	@Test
	public void criarFuncionarioCompleto(){
		super.criarFuncionarioCompleto();
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);		
		FuncionarioBC.getInstance().insert(funcionario);
	}
}