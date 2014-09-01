package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioDAO;

import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AviaoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.HorarioBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.RotaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC.TesteHorarioLabBC;
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

public class TesteHorarioLabDAO extends TesteHorarioLabBC {
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	/**
	 * Valida o horario completo
	 */
	@Test
	@Override
	public void criarHorarioCompleto(){
		
		//Para nao ocorrer problemas na base de dados de constraint violation
		CiaAereaBC.getInstance().insert(horario.getRota().getCiaAerea());
		AeroportoBC.getInstance().insert(horario.getRota().getOrigem());
		AeroportoBC.getInstance().insert(horario.getRota().getDestino());
		RotaBC.getInstance().insert(horario.getRota());
		AviaoBC.getInstance().insert(horario.getAviao());
		
		////////////////////////
		// INSERT
		////////////////////////
		PrintUtils.imprimeNomeMetodoChamadorEClasse(horario);		
		Long idHorario = HorarioBC.getInstance().insert(horario);

		//Verifica se o id eh maior que zero
		Assert.assertTrue(idHorario > 0);
		//Verifica se os Ids sao iguais
		Assert.assertEquals(idHorario, horario.getId());
		
		//Imprime para verificar se o id foi inserido dentro do objeto horario
		PrintUtils.imprimeNomeMetodoChamadorEClasse(horario);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(HorarioBC.getInstance().findById(idHorario), horario);		
	}
	
	/**
	 * Valida o atributo Rota como se esta com FecthType Lazy
	 */
	@Test(expected = LazyInitializationException.class)
	public void validarHorarioLazy(){
		criarHorarioCompleto();
		
		//Obtem o objeto do BD para as comparacoes basicas
		Rota rotaBD = RotaBC.getInstance().findById(horario.getRota().getId());
		
		//Exception de Lazy
		rotaBD.getHorarios().get(0);
	}
	
	
	/**
	 * Valida o horario completo
	 */
	@Test
	public void updateHorarioCompleto(){
		criarHorarioCompleto();
		
		//Atualiza objeto
		Atualizador.atualizarHorario(horario, "UHO");
		
		//Atualiza o BD
		HorarioBC.getInstance().update(horario);
		
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(HorarioBC.getInstance().findById(horario.getId()), horario);		
	}
	
	/**
	 * Valida o horario completo
	 */
	@Test
	public void deleteHorarioCompleto(){
		criarHorarioCompleto();

		//Imprime para verificar se o horario foi atualizado
		PrintUtils.imprimeNomeMetodoChamadorEClasse(horario);
		
		//Deleta o horario do BD
		HorarioBC.getInstance().delete(horario);
		Assert.assertNull(HorarioBC.getInstance().findById(horario.getId()));
	}
}
