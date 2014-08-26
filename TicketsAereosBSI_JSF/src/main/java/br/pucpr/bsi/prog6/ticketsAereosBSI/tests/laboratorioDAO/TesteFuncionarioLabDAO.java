package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioDAO;

import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.EnderecoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.FuncionarioBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PapelBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC.TesteFuncionarioLabBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util.Atualizador;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util.Verificador;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.PrintUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TesteFuncionarioLabDAO extends TesteFuncionarioLabBC{
	
	/**
	 * Metodo responsavel por criar uma funcionario completa
	 */
	@Test
	@Override
	public void criarFuncionarioCompleto(){
		
		//Para nao ocorrer problemas na base de dados de constraint violation
		CiaAereaBC.getInstance().insert(funcionario.getPapel().getCiaAerea());
		PapelBC.getInstance().insert(funcionario.getPapel());
		
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);		
		Long idFuncionario = FuncionarioBC.getInstance().insert(funcionario);

		//Verifica se o id eh maior que zero
		Assert.assertTrue(idFuncionario > 0);
		//Verifica se os Ids sao iguais
		Assert.assertEquals(idFuncionario, funcionario.getId());
		
		//Imprime para verificar se o id foi inserido dentro do objeto endereco
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(FuncionarioBC.getInstance().findById(idFuncionario), funcionario);
	}
	
	/**
	 * Valida o atributo Funcionario como se esta com FecthType Lazy
	 */
	@Test(expected = LazyInitializationException.class)
	public void validarPapelLazy(){
		criarFuncionarioCompleto();
		
		//Obtem o objeto do BD para as comparacoes basicas
		Papel papelBD = PapelBC.getInstance().findById(funcionario.getPapel().getId());
		
		//Exception de Lazy
		papelBD.getFuncionarios().get(0);
	}
	
	
	/**
	 * Metodo responsavel por atualizar uma funcionario completa
	 */
	@Test
	public void updateFuncionarioCompleto(){
		criarFuncionarioCompleto();
		
		//Atualiza funcionario
		Atualizador.atualizarFuncionario(funcionario, "UF");
		
		//Atualiza o BD
		FuncionarioBC.getInstance().update(funcionario);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(FuncionarioBC.getInstance().findById(funcionario.getId()), funcionario);
	}
	
	/**
	 * Metodo responsavel por deletar uma funcionario completa
	 */
	@Test
	public void deletarFuncionarioCompleto(){
		criarFuncionarioCompleto();

		//Imprime para verificar se o id foi inserido dentro do objeto
		PrintUtils.imprimeNomeMetodoChamadorEClasse(funcionario);
		
		FuncionarioBC.getInstance().delete(funcionario);
		Assert.assertNull(FuncionarioBC.getInstance().findById(funcionario.getId()));
		
		//Verifica se o cascade remove foi executado com sucesso
		Assert.assertNull(EnderecoBC.getInstance().findById(funcionario.getEndereco().getId()));
	}
}