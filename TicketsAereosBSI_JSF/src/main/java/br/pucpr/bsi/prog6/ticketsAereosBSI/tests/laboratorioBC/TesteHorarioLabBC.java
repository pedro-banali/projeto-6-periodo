package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioBC;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.HorarioBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioModel.TesteHorarioLabModel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.PrintUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 *
 */

public class TesteHorarioLabBC extends TesteHorarioLabModel {
	
	//////////////////////////////////////////
	// METODOS DE TESTE JUNIT
	//////////////////////////////////////////
	
	@Before
	public void criarHorario(){
		horario = novoHorario1();
	}
	
	/**
	 * Valida o horario nulo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarHorarioNulo(){
		horario = null;
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(horario);		
		HorarioBC.getInstance().insert(horario);
	}
	
	/**
	 * Valida o horario preenchido com espacos em branco
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarHorarioEspacosBranco(){
		horario.setCodigo("                         ");

		PrintUtils.imprimeNomeMetodoChamadorEClasse(horario);		
		HorarioBC.getInstance().insert(horario);
	}	
	
	/**
	 * Valida o horario sem o aviao
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarHorarioSemAviao(){
		horario.setAviao(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(horario);		
		HorarioBC.getInstance().insert(horario);
	}
	
	/**
	 * Valida o horario sem a chegada
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarHorarioSemChegada(){
		horario.setChegada(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(horario);		
		HorarioBC.getInstance().insert(horario);
	}
	
	/**
	 * Valida o horario sem a chegada
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarHorarioChegadaAntesPartida(){
		horario.setChegada((new Date(new Date().getTime()-40000000)));
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(horario);		
		HorarioBC.getInstance().insert(horario);
	}
	
	
	/**
	 * Valida o horario sem o codigo
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarHorarioSemCodigo(){
		horario.setCodigo(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(horario);		
		HorarioBC.getInstance().insert(horario);
	}

	/**
	 * Valida o horario sem a partida
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarHorarioSemPartida(){
		horario.setPartida(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(horario);		
		HorarioBC.getInstance().insert(horario);
	}
	
	/**
	 * Valida o horario sem a partida
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarHorarioPartidaAntesAtual(){
		horario.setPartida((new Date(new Date().getTime()-40000000)));
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(horario);		
		HorarioBC.getInstance().insert(horario);
	}
	
	/**
	 * Valida o horario com a qtd economica negativa
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarHorarioQtdEconomicaNegativa(){
		horario.setQtdEconomica(-20);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(horario);		
		HorarioBC.getInstance().insert(horario);
	}
	
	/**
	 * Valida o horario com a qtd executiva negativa
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarHorarioQtdExecutivaNegativa(){
		horario.setQtdExecutiva(-20);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(horario);		
		HorarioBC.getInstance().insert(horario);
	}

	/**
	 * Valida o horario com a qtd primeira negativa
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarHorarioQtdPrimeiraNegativa(){
		horario.setQtdPrimeira(-20);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(horario);		
		HorarioBC.getInstance().insert(horario);
	}
	
	/**
	 * Valida o horario sem a rota
	 */
	@Test(expected = TicketsAereosBSIException.class)
	public void validarHorarioSemRota(){
		horario.setRota(null);
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(horario);		
		HorarioBC.getInstance().insert(horario);
	}
	
	
	/**
	 * Valida o horario completo
	 */
	@Test
	@Override
	public void criarHorarioCompleto(){
		super.criarHorarioCompleto();
		
		PrintUtils.imprimeNomeMetodoChamadorEClasse(horario);		
		HorarioBC.getInstance().insert(horario);
	}
}
