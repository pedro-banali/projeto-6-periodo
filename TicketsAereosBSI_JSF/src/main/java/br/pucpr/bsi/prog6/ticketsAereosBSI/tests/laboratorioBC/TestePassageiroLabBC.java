package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PassageiroBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel.TestePassageiroLabModel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.PrintUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TestePassageiroLabBC extends TestePassageiroLabModel {
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Before
	public void criarPassageiro(){
		passageiro = novoPassageiro1();
	}	
	
	/**
	 * Valida o passageiro nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPassageiroNulo(){
		passageiro = null;
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);
		PassageiroBC.getInstance().insert(passageiro);
	}
	
	/**
	 * Valida o passageiro com endereco nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPassageiroEnderecoNulo(){
		passageiro.setEndereco(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);		
		PassageiroBC.getInstance().insert(passageiro);
	}
	
	/**
	 * Valida o passageiro preenchido com espacos em branco
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPassageiroEspacosBranco(){
		passageiro.setDocumento("                               ");
		passageiro.setNumeroCartao("                              ");
		passageiro.setEmail("                             ");
		passageiro.setNome("                              ");
		passageiro.setSenha("                             ");
		passageiro.setTelefone("                          ");
		passageiro.setUsuario("                             ");
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);		
		PassageiroBC.getInstance().insert(passageiro);
	}
	
	/**
	 * Valida o passageiro sem codigo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPassageiroSemDocumento(){
		passageiro.setDocumento(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);		
		PassageiroBC.getInstance().insert(passageiro);
	}
	
	/**
	 * Valida o passageiro sem numero cartao
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPassageiroSemNumeroCartao(){
		passageiro.setNumeroCartao(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);		
		PassageiroBC.getInstance().insert(passageiro);
	}
	
	/**
	 * Valida o passageiro sem data nascimento
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPassageiroSemDataNascimento(){
		passageiro.setDataNascimento(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);		
		PassageiroBC.getInstance().insert(passageiro);
	}
	
	/**
	 * Valida o passageiro com data nascimento apos a data atual
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPassageiroComDataNascimentoAposDataAtual(){
		passageiro.setDataNascimento(new Date(new Date().getTime()+40000000));
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);		
		PassageiroBC.getInstance().insert(passageiro);
	}
	
	/**
	 * Valida o passageiro sem email
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPassageiroSemEmail(){
		passageiro.setEmail(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);		
		PassageiroBC.getInstance().insert(passageiro);
	}
			
	/**
	 * Valida o passageiro sem @ no email
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPassageiroComEmailSemArroba(){
		passageiro.setEmail("func1ticketeventosbsi.com.br");
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);		
		PassageiroBC.getInstance().insert(passageiro);
	}
	
	/**
	 * Valida o passageiro sem . apos o @ no email
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPassageiroComEmailSemPonto(){
		passageiro.setEmail("func.1@ticketeventosbsi");
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);		
		PassageiroBC.getInstance().insert(passageiro);
	}
	
	/**
	 * Valida o passageiro sem nome
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPassageiroSemNome(){
		passageiro.setNome(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);		
		PassageiroBC.getInstance().insert(passageiro);
	}
	
	/**
	 * Valida o passageiro sem senha
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPassageiroSemSenha(){
		passageiro.setSenha(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);		
		PassageiroBC.getInstance().insert(passageiro);
	}
	
	/**
	 * Valida o passageiro sem telefone
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPassageiroSemTelefone(){
		passageiro.setTelefone(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);		
		PassageiroBC.getInstance().insert(passageiro);
	}	
	
	/**
	 * Valida o passageiro sem user
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarPassageiroSemUsuario(){
		passageiro.setUsuario(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);		
		PassageiroBC.getInstance().insert(passageiro);
	}
	
	/**
	 * Metodo responsavel por criar um passageiro completo
	 */
	@Test
	public void criarPassageiroCompleto(){
		super.criarPassageiroCompleto();
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(passageiro);		
		PassageiroBC.getInstance().insert(passageiro);
	}
}