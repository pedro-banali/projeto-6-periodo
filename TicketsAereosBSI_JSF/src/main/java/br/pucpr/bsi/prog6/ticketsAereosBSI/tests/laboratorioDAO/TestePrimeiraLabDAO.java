package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioDAO;

import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AviaoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.HorarioBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PassageiroBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PrimeiraBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.RotaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC.TestePrimeiraLabBC;
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

public class TestePrimeiraLabDAO extends TestePrimeiraLabBC{
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	/**
	 * Valida a bilhete completa
	 */
	@Test
	@Override
	public void criarPrimeiraCompleta(){
		
		//Para nao ocorrer problemas na base de dados de constraint violation
		CiaAereaBC.getInstance().insert(bilhete.getHorario().getRota().getCiaAerea());
		AeroportoBC.getInstance().insert(bilhete.getHorario().getRota().getOrigem());
		AeroportoBC.getInstance().insert(bilhete.getHorario().getRota().getDestino());
		RotaBC.getInstance().insert(bilhete.getHorario().getRota());
		AviaoBC.getInstance().insert(bilhete.getHorario().getAviao());
		PassageiroBC.getInstance().insert(bilhete.getPassageiro());
		HorarioBC.getInstance().insert(bilhete.getHorario());
		
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(bilhete);		
		Long idPrimeira = PrimeiraBC.getInstance().insert(bilhete);

		//Verifica se o id eh maior que zero
		Assert.assertTrue(idPrimeira > 0);
		//Verifica se os Ids sao iguais
		Assert.assertEquals(idPrimeira, bilhete.getId());
		
		//Imprime para verificar se o id foi inserido dentro do objeto bilhete
		PrintUtils.imprimeNomeMetodoChamadorEClasse(bilhete);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(PrimeiraBC.getInstance().findById(idPrimeira), bilhete);		
	}
	
	/**
	 * Valida o atributo Bilhetes como se esta com FecthType Lazy
	 */
	@Test(expected = LazyInitializationException.class)
	public void validarPapelLazy(){
		criarPrimeiraCompleta();
		
		//Obtem o objeto do BD para as comparacoes basicas
		Passageiro passageiroBD = PassageiroBC.getInstance().findById(bilhete.getPassageiro().getId());
		
		//Exception de Lazy
		passageiroBD.getBilhetes().get(0);
	}
	
	
	/**
	 * Valida o bilhete completo
	 */
	@Test
	public void updatePrimeiraCompleto(){
		criarPrimeiraCompleta();
		
		//Atualiza objeto
		Atualizador.atualizarBilhete(bilhete, "UPR");
		
		//Atualiza o BD
		PrimeiraBC.getInstance().update(bilhete);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(PrimeiraBC.getInstance().findById(bilhete.getId()), bilhete);		
	}
	
	/**
	 * Valida o bilhete completo
	 */
	@Test
	public void deletePrimeiraCompleto(){
		criarPrimeiraCompleta();

		//Imprime para verificar se o bilhete foi atualizado
		PrintUtils.imprimeNomeMetodoChamadorEClasse(bilhete);
		
		//Deleta o bilhete do BD
		PrimeiraBC.getInstance().delete(bilhete);
		Assert.assertNull(PrimeiraBC.getInstance().findById(bilhete.getId()));
	}
}
