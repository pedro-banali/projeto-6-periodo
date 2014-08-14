package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Horario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TesteHorarioLabModel {
	
	//////////////////////////////////////////
	// ATRIBUTOS
	//////////////////////////////////////////
	
	protected Horario horario;
	protected static Rota rota;
	protected static Aviao aviao;
	
	//////////////////////////////////////////
	// METODO DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Test
	public void criarHorarioCompleto(){
		horario = novoHorario1();
		Assert.assertNotNull(horario);
		Assert.assertEquals(horario.getAviao(), aviao);
		Assert.assertEquals(horario.getRota(), rota);
		Assert.assertTrue(rota.getHorarios().contains(horario));
		
		horario = novoHorario2();
		Assert.assertNotNull(horario);
		Assert.assertEquals(horario.getAviao(), aviao);
		Assert.assertEquals(horario.getRota(), rota);
		Assert.assertTrue(rota.getHorarios().contains(horario));
		
		horario = novoHorario3();
		Assert.assertNotNull(horario);
		Assert.assertEquals(horario.getAviao(), aviao);
		Assert.assertEquals(horario.getRota(), rota);
		Assert.assertTrue(rota.getHorarios().contains(horario));
	}
	
	//////////////////////////////////////////
	// METODOS AUXILIARES
	//////////////////////////////////////////
	
	/**
	 * Metodo responsavel por criar um horario
	 */
	public static Horario novoHorario1(){
		rota = TesteRotaLabModel.novaRota1();
		aviao = TesteAviaoLabModel.novoAviao1();
		aviao.setCiaAerea(rota.getCiaAerea());
		
		//Metodo que cria um novo rota
		Horario horario = new Horario(rota, aviao);
		horario.setChegada(new Date(new Date().getTime() + 40000000));
		horario.setCodigo("AAA-111");
		horario.setPartida(new Date(new Date().getTime() + 30000000));
		horario.setQtdEconomica(4);
		horario.setQtdExecutiva(4);
		horario.setQtdPrimeira(4);
		
		return horario;
	}
	
	/**
	 * Metodo responsavel por criar um horario
	 */
	public static Horario novoHorario2(){
		rota = TesteRotaLabModel.novaRota2();
		aviao = TesteAviaoLabModel.novoAviao2();
		aviao.setCiaAerea(rota.getCiaAerea());
		
		//Metodo que cria um novo rota
		Horario horario = new Horario(rota, aviao);
		horario.setChegada(new Date(new Date().getTime() + 60000000));
		horario.setCodigo("BBB-222");
		horario.setPartida(new Date(new Date().getTime() + 50000000));
		horario.setQtdEconomica(5);
		horario.setQtdExecutiva(5);
		horario.setQtdPrimeira(5);
		
		return horario;
	}
	
	/**
	 * Metodo responsavel por criar um horario
	 */
	public static Horario novoHorario3(){
		rota = TesteRotaLabModel.novaRota3();
		aviao = TesteAviaoLabModel.novoAviao3();
		aviao.setCiaAerea(rota.getCiaAerea());
		
		//Metodo que cria um novo rota
		Horario horario = new Horario(rota, aviao);
		horario.setChegada(new Date(new Date().getTime() + 80000000));
		horario.setCodigo("CCC-333");
		horario.setPartida(new Date(new Date().getTime() + 70000000));
		horario.setQtdEconomica(6);
		horario.setQtdExecutiva(6);
		horario.setQtdPrimeira(6);
		
		return horario;
	}
}
