package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Executiva;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Horario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TesteExecutivaLabModel {
	
	//////////////////////////////////////////
	// ATRIBUTOS
	//////////////////////////////////////////
	
	protected Executiva bilhete;
	protected static Passageiro passageiro;
	protected static Horario horario;
	
	//////////////////////////////////////////
	// METODO DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Test
	public void criarExecutivaCompleta(){
		bilhete = novaExecutiva1();
		Assert.assertNotNull(bilhete);
		Assert.assertEquals(bilhete.getPassageiro(), passageiro);
		Assert.assertTrue(passageiro.getBilhetes().contains(bilhete));
		Assert.assertEquals(bilhete.getHorario(), horario);
		Assert.assertTrue(horario.getExecutivas().contains(bilhete));
		Assert.assertTrue(TipoBilheteEnum.EXECUTIVA.equals(bilhete.getTipoBilheteEnum()));

		bilhete = novaExecutiva2();
		Assert.assertNotNull(bilhete);
		Assert.assertEquals(bilhete.getPassageiro(), passageiro);
		Assert.assertTrue(passageiro.getBilhetes().contains(bilhete));
		Assert.assertEquals(bilhete.getHorario(), horario);
		Assert.assertTrue(horario.getExecutivas().contains(bilhete));
		Assert.assertTrue(TipoBilheteEnum.EXECUTIVA.equals(bilhete.getTipoBilheteEnum()));
		
		bilhete = novaExecutiva3();
		Assert.assertNotNull(bilhete);
		Assert.assertEquals(bilhete.getPassageiro(), passageiro);
		Assert.assertTrue(passageiro.getBilhetes().contains(bilhete));
		Assert.assertEquals(bilhete.getHorario(), horario);
		Assert.assertTrue(horario.getExecutivas().contains(bilhete));
		Assert.assertTrue(TipoBilheteEnum.EXECUTIVA.equals(bilhete.getTipoBilheteEnum()));
		
	}
	
	//////////////////////////////////////////
	// METODOS AUXILIARES
	//////////////////////////////////////////
	
	/**
	 * Metodo responsavel por criar um bilhete
	 */
	public static Executiva novaExecutiva1(){
		passageiro = TestePassageiroLabModel.novoPassageiro1();
		horario = TesteHorarioLabModel.novoHorario1();
		
		//Metodo que cria um novo rota
		Executiva bilhete = new Executiva(horario, passageiro);
		bilhete.setAssento("EX-1");
		bilhete.setNumero(1);
		bilhete.setSituacaoEnum(SituacaoBilheteEnum.DISPONIVEL);
		
		return bilhete;
	}
	
	/**
	 * Metodo responsavel por criar um bilhete
	 */
	public static Executiva novaExecutiva2(){
		passageiro = TestePassageiroLabModel.novoPassageiro2();
		horario = TesteHorarioLabModel.novoHorario2();
		
		//Metodo que cria um novo rota
		Executiva bilhete = new Executiva(horario, passageiro);
		bilhete.setAssento("EX-1");
		bilhete.setNumero(1);
		bilhete.setSituacaoEnum(SituacaoBilheteEnum.RESERVADO);
		
		return bilhete;
	}
	
	/**
	 * Metodo responsavel por criar um bilhete
	 */
	public static Executiva novaExecutiva3(){
		passageiro = TestePassageiroLabModel.novoPassageiro3();
		horario = TesteHorarioLabModel.novoHorario3();
		
		//Metodo que cria um novo rota
		Executiva bilhete = new Executiva(horario, passageiro);
		bilhete.setAssento("EX-1");
		bilhete.setNumero(1);
		bilhete.setSituacaoEnum(SituacaoBilheteEnum.VENDIDO);
		
		return bilhete;
	}
	
}

