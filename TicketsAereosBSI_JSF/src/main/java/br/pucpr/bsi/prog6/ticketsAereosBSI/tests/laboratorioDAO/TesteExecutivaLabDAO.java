package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioDAO;

import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AviaoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.ExecutivaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.HorarioBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PassageiroBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.RotaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC.TesteExecutivaLabBC;
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

public class TesteExecutivaLabDAO extends TesteExecutivaLabBC{
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	/**
	 * Valida a bilhete completa
	 */
	@Test
	@Override
	public void criarExecutivaCompleta(){
		
		//Para nao ocorrer problemas na base de dados de constraint violation
		CiaAereaBC.getInstance().insert(bilhete.getHorario().getRota().getCiaAerea());
		AeroportoBC.getInstance().insert(bilhete.getHorario().getRota().getOrigem());
		AeroportoBC.getInstance().insert(bilhete.getHorario().getRota().getDestino());
		RotaBC.getInstance().insert(bilhete.getHorario().getRota());
		AviaoBC.getInstance().insert(bilhete.getHorario().getAviao());
		PassageiroBC.getInstance().insert(bilhete.getPassageiro());
		HorarioBC.getInstance().insert(bilhete.getHorario());
		
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(bilhete);		
		Long idExecutiva = ExecutivaBC.getInstance().insert(bilhete);

		//Verifica se o id eh maior que zero
		Assert.assertTrue(idExecutiva > 0);
		//Verifica se os Ids sao iguais
		Assert.assertEquals(idExecutiva, bilhete.getId());
		
		//Imprime para verificar se o id foi inserido dentro do objeto bilhete
		PrintUtils.imprimeNomeMetodoChamadorEClasse(bilhete);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(ExecutivaBC.getInstance().findById(idExecutiva), bilhete);		
	}
	
	/**
	 * Valida o atributo Bilhetes como se esta com FecthType Lazy
	 */
	@Test(expected = LazyInitializationException.class)
	public void validarBilhetesLazy(){
		criarExecutivaCompleta();
		
		//Obtem o objeto do BD para as comparacoes basicas
		Passageiro passageiroBD = PassageiroBC.getInstance().findById(bilhete.getPassageiro().getId());
		
		//Exception de Lazy
		passageiroBD.getBilhetes().get(0);
	}
	
	/**
	 * Valida o bilhete completo
	 */
	@Test
	public void updateExecutivaCompleto(){
		criarExecutivaCompleta();
		
		//Atualiza objeto
		Atualizador.atualizarBilhete(bilhete, "UEX");
		
		//Atualiza o BD
		ExecutivaBC.getInstance().update(bilhete);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(ExecutivaBC.getInstance().findById(bilhete.getId()), bilhete);		
	}
	
	/**
	 * Valida o bilhete completo
	 */
	@Test
	public void deleteExecutivaCompleto(){
		criarExecutivaCompleta();

		//Imprime para verificar se o bilhete foi atualizado
		PrintUtils.imprimeNomeMetodoChamadorEClasse(bilhete);
		
		//Deleta o bilhete do BD
		ExecutivaBC.getInstance().delete(bilhete);
		Assert.assertNull(ExecutivaBC.getInstance().findById(bilhete.getId()));
	}
}
