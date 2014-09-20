package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.*;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.utils.DateUtils.datePlusHours;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AviaoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.HorarioBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.RotaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Economica;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Executiva;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Horario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Primeira;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

@RunWith(Parameterized.class)
public class TesteHorarioLabPopulate {

	private Horario horario;

	public TesteHorarioLabPopulate(Horario horario) {
		this.horario = horario;
	}

	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] {
				
				/////////////////////////////////////////
				// BRASILIA - AZUL
				/////////////////////////////////////////
				
				{ novoHorario(HOR_DIA_1_BSB_CNF_AZUL)},
				{ novoHorario(HOR_DIA_2_BSB_CNF_AZUL)},
				{ novoHorario(HOR_DIA_3_BSB_CNF_AZUL)},
				{ novoHorario(HOR_DIA_4_BSB_CNF_AZUL)},
				{ novoHorario(HOR_DIA_5_BSB_CNF_AZUL)},
				{ novoHorario(HOR_DIA_6_BSB_CNF_AZUL)},
				
				{ novoHorario(HOR_DIA_1_BSB_CWB_AZUL)},
				{ novoHorario(HOR_DIA_2_BSB_CWB_AZUL)},
				{ novoHorario(HOR_DIA_3_BSB_CWB_AZUL)},
				{ novoHorario(HOR_DIA_4_BSB_CWB_AZUL)},
				{ novoHorario(HOR_DIA_5_BSB_CWB_AZUL)},
				{ novoHorario(HOR_DIA_6_BSB_CWB_AZUL)},
				
				{ novoHorario(HOR_DIA_1_BSB_GRU_AZUL)},
				{ novoHorario(HOR_DIA_2_BSB_GRU_AZUL)},
				{ novoHorario(HOR_DIA_3_BSB_GRU_AZUL)},
				{ novoHorario(HOR_DIA_4_BSB_GRU_AZUL)},
				{ novoHorario(HOR_DIA_5_BSB_GRU_AZUL)},
				{ novoHorario(HOR_DIA_6_BSB_GRU_AZUL)},
				
				{ novoHorario(HOR_DIA_1_BSB_POA_AZUL)},
				{ novoHorario(HOR_DIA_2_BSB_POA_AZUL)},
				{ novoHorario(HOR_DIA_3_BSB_POA_AZUL)},
				{ novoHorario(HOR_DIA_4_BSB_POA_AZUL)},
				{ novoHorario(HOR_DIA_5_BSB_POA_AZUL)},
				{ novoHorario(HOR_DIA_6_BSB_POA_AZUL)},
				
				{ novoHorario(HOR_DIA_1_BSB_SDU_AZUL)},
				{ novoHorario(HOR_DIA_2_BSB_SDU_AZUL)},
				{ novoHorario(HOR_DIA_3_BSB_SDU_AZUL)},
				{ novoHorario(HOR_DIA_4_BSB_SDU_AZUL)},
				{ novoHorario(HOR_DIA_5_BSB_SDU_AZUL)},
				{ novoHorario(HOR_DIA_6_BSB_SDU_AZUL)},
			
				/////////////////////////////////////////
				// BELO HORIZONTE - AZUL
				/////////////////////////////////////////
					
				{ novoHorario(HOR_DIA_1_CNF_BSB_AZUL)},
				{ novoHorario(HOR_DIA_2_CNF_BSB_AZUL)},
				{ novoHorario(HOR_DIA_3_CNF_BSB_AZUL)},
				{ novoHorario(HOR_DIA_4_CNF_BSB_AZUL)},
				{ novoHorario(HOR_DIA_5_CNF_BSB_AZUL)},
				{ novoHorario(HOR_DIA_6_CNF_BSB_AZUL)},
				
				{ novoHorario(HOR_DIA_1_CNF_CWB_AZUL)},
				{ novoHorario(HOR_DIA_2_CNF_CWB_AZUL)},
				{ novoHorario(HOR_DIA_3_CNF_CWB_AZUL)},
				{ novoHorario(HOR_DIA_4_CNF_CWB_AZUL)},
				{ novoHorario(HOR_DIA_5_CNF_CWB_AZUL)},
				{ novoHorario(HOR_DIA_6_CNF_CWB_AZUL)},
				
				{ novoHorario(HOR_DIA_1_CNF_GRU_AZUL)},
				{ novoHorario(HOR_DIA_2_CNF_GRU_AZUL)},
				{ novoHorario(HOR_DIA_3_CNF_GRU_AZUL)},
				{ novoHorario(HOR_DIA_4_CNF_GRU_AZUL)},
				{ novoHorario(HOR_DIA_5_CNF_GRU_AZUL)},
				{ novoHorario(HOR_DIA_6_CNF_GRU_AZUL)},
								
				{ novoHorario(HOR_DIA_1_CNF_POA_AZUL)},
				{ novoHorario(HOR_DIA_2_CNF_POA_AZUL)},
				{ novoHorario(HOR_DIA_3_CNF_POA_AZUL)},
				{ novoHorario(HOR_DIA_4_CNF_POA_AZUL)},
				{ novoHorario(HOR_DIA_5_CNF_POA_AZUL)},
				{ novoHorario(HOR_DIA_6_CNF_POA_AZUL)},

				{ novoHorario(HOR_DIA_1_CNF_SDU_AZUL)},
				{ novoHorario(HOR_DIA_2_CNF_SDU_AZUL)},
				{ novoHorario(HOR_DIA_3_CNF_SDU_AZUL)},
				{ novoHorario(HOR_DIA_4_CNF_SDU_AZUL)},
				{ novoHorario(HOR_DIA_5_CNF_SDU_AZUL)},
				{ novoHorario(HOR_DIA_6_CNF_SDU_AZUL)},
				
				/////////////////////////////////////////
				// CURITIBA - AZUL
				/////////////////////////////////////////
				
				{ novoHorario(HOR_DIA_1_CWB_BSB_AZUL)},
				{ novoHorario(HOR_DIA_2_CWB_BSB_AZUL)},
				{ novoHorario(HOR_DIA_3_CWB_BSB_AZUL)},
				{ novoHorario(HOR_DIA_4_CWB_BSB_AZUL)},
				{ novoHorario(HOR_DIA_5_CWB_BSB_AZUL)},
				{ novoHorario(HOR_DIA_6_CWB_BSB_AZUL)},
					
				{ novoHorario(HOR_DIA_1_CWB_CNF_AZUL)},
				{ novoHorario(HOR_DIA_2_CWB_CNF_AZUL)},
				{ novoHorario(HOR_DIA_3_CWB_CNF_AZUL)},
				{ novoHorario(HOR_DIA_4_CWB_CNF_AZUL)},
				{ novoHorario(HOR_DIA_5_CWB_CNF_AZUL)},
				{ novoHorario(HOR_DIA_6_CWB_CNF_AZUL)},
					
				{ novoHorario(HOR_DIA_1_CWB_GRU_AZUL)},
				{ novoHorario(HOR_DIA_2_CWB_GRU_AZUL)},
				{ novoHorario(HOR_DIA_3_CWB_GRU_AZUL)},
				{ novoHorario(HOR_DIA_4_CWB_GRU_AZUL)},
				{ novoHorario(HOR_DIA_5_CWB_GRU_AZUL)},
				{ novoHorario(HOR_DIA_6_CWB_GRU_AZUL)},
				
				{ novoHorario(HOR_DIA_1_CWB_POA_AZUL)},
				{ novoHorario(HOR_DIA_2_CWB_POA_AZUL)},
				{ novoHorario(HOR_DIA_3_CWB_POA_AZUL)},
				{ novoHorario(HOR_DIA_4_CWB_POA_AZUL)},
				{ novoHorario(HOR_DIA_5_CWB_POA_AZUL)},
				{ novoHorario(HOR_DIA_6_CWB_POA_AZUL)},
				
				{ novoHorario(HOR_DIA_1_CWB_SDU_AZUL)},
				{ novoHorario(HOR_DIA_2_CWB_SDU_AZUL)},
				{ novoHorario(HOR_DIA_3_CWB_SDU_AZUL)},
				{ novoHorario(HOR_DIA_4_CWB_SDU_AZUL)},
				{ novoHorario(HOR_DIA_5_CWB_SDU_AZUL)},
				{ novoHorario(HOR_DIA_6_CWB_SDU_AZUL)},
				
				/////////////////////////////////////////
				// GUARULHOS - AZUL
				/////////////////////////////////////////
					
				{ novoHorario(HOR_DIA_1_GRU_BSB_AZUL)},
				{ novoHorario(HOR_DIA_2_GRU_BSB_AZUL)},
				{ novoHorario(HOR_DIA_3_GRU_BSB_AZUL)},
				{ novoHorario(HOR_DIA_4_GRU_BSB_AZUL)},
				{ novoHorario(HOR_DIA_5_GRU_BSB_AZUL)},
				{ novoHorario(HOR_DIA_6_GRU_BSB_AZUL)},
				
				{ novoHorario(HOR_DIA_1_GRU_CNF_AZUL)},
				{ novoHorario(HOR_DIA_2_GRU_CNF_AZUL)},
				{ novoHorario(HOR_DIA_3_GRU_CNF_AZUL)},
				{ novoHorario(HOR_DIA_4_GRU_CNF_AZUL)},
				{ novoHorario(HOR_DIA_5_GRU_CNF_AZUL)},
				{ novoHorario(HOR_DIA_6_GRU_CNF_AZUL)},
								
				{ novoHorario(HOR_DIA_1_GRU_CWB_AZUL)},
				{ novoHorario(HOR_DIA_2_GRU_CWB_AZUL)},
				{ novoHorario(HOR_DIA_3_GRU_CWB_AZUL)},
				{ novoHorario(HOR_DIA_4_GRU_CWB_AZUL)},
				{ novoHorario(HOR_DIA_5_GRU_CWB_AZUL)},
				{ novoHorario(HOR_DIA_6_GRU_CWB_AZUL)},
				
				{ novoHorario(HOR_DIA_1_GRU_POA_AZUL)},
				{ novoHorario(HOR_DIA_2_GRU_POA_AZUL)},
				{ novoHorario(HOR_DIA_3_GRU_POA_AZUL)},
				{ novoHorario(HOR_DIA_4_GRU_POA_AZUL)},
				{ novoHorario(HOR_DIA_5_GRU_POA_AZUL)},
				{ novoHorario(HOR_DIA_6_GRU_POA_AZUL)},
				
				{ novoHorario(HOR_DIA_1_GRU_SDU_AZUL)},
				{ novoHorario(HOR_DIA_2_GRU_SDU_AZUL)},
				{ novoHorario(HOR_DIA_3_GRU_SDU_AZUL)},
				{ novoHorario(HOR_DIA_4_GRU_SDU_AZUL)},
				{ novoHorario(HOR_DIA_5_GRU_SDU_AZUL)},
				{ novoHorario(HOR_DIA_6_GRU_SDU_AZUL)},
					
				/////////////////////////////////////////
				// PORTO ALEGRE - AZUL
				/////////////////////////////////////////
				
				{ novoHorario(HOR_DIA_1_POA_BSB_AZUL)},
				{ novoHorario(HOR_DIA_2_POA_BSB_AZUL)},
				{ novoHorario(HOR_DIA_3_POA_BSB_AZUL)},
				{ novoHorario(HOR_DIA_4_POA_BSB_AZUL)},
				{ novoHorario(HOR_DIA_5_POA_BSB_AZUL)},
				{ novoHorario(HOR_DIA_6_POA_BSB_AZUL)},
					
				{ novoHorario(HOR_DIA_1_POA_CNF_AZUL)},
				{ novoHorario(HOR_DIA_2_POA_CNF_AZUL)},
				{ novoHorario(HOR_DIA_3_POA_CNF_AZUL)},
				{ novoHorario(HOR_DIA_4_POA_CNF_AZUL)},
				{ novoHorario(HOR_DIA_5_POA_CNF_AZUL)},
				{ novoHorario(HOR_DIA_6_POA_CNF_AZUL)},
				
				{ novoHorario(HOR_DIA_1_POA_CWB_AZUL)},
				{ novoHorario(HOR_DIA_2_POA_CWB_AZUL)},
				{ novoHorario(HOR_DIA_3_POA_CWB_AZUL)},
				{ novoHorario(HOR_DIA_4_POA_CWB_AZUL)},
				{ novoHorario(HOR_DIA_5_POA_CWB_AZUL)},
				{ novoHorario(HOR_DIA_6_POA_CWB_AZUL)},
				
				{ novoHorario(HOR_DIA_1_POA_GRU_AZUL)},
				{ novoHorario(HOR_DIA_2_POA_GRU_AZUL)},
				{ novoHorario(HOR_DIA_3_POA_GRU_AZUL)},
				{ novoHorario(HOR_DIA_4_POA_GRU_AZUL)},
				{ novoHorario(HOR_DIA_5_POA_GRU_AZUL)},
				{ novoHorario(HOR_DIA_6_POA_GRU_AZUL)},
				
				{ novoHorario(HOR_DIA_1_POA_SDU_AZUL)},
				{ novoHorario(HOR_DIA_2_POA_SDU_AZUL)},
				{ novoHorario(HOR_DIA_3_POA_SDU_AZUL)},
				{ novoHorario(HOR_DIA_4_POA_SDU_AZUL)},
				{ novoHorario(HOR_DIA_5_POA_SDU_AZUL)},
				{ novoHorario(HOR_DIA_6_POA_SDU_AZUL)},

				/////////////////////////////////////////
				// RIO DE JANEIRO - AZUL
				/////////////////////////////////////////
				
				{ novoHorario(HOR_DIA_1_SDU_BSB_AZUL)},
				{ novoHorario(HOR_DIA_2_SDU_BSB_AZUL)},
				{ novoHorario(HOR_DIA_3_SDU_BSB_AZUL)},
				{ novoHorario(HOR_DIA_4_SDU_BSB_AZUL)},
				{ novoHorario(HOR_DIA_5_SDU_BSB_AZUL)},
				{ novoHorario(HOR_DIA_6_SDU_BSB_AZUL)},
				
				{ novoHorario(HOR_DIA_1_SDU_CNF_AZUL)},
				{ novoHorario(HOR_DIA_2_SDU_CNF_AZUL)},
				{ novoHorario(HOR_DIA_3_SDU_CNF_AZUL)},
				{ novoHorario(HOR_DIA_4_SDU_CNF_AZUL)},
				{ novoHorario(HOR_DIA_5_SDU_CNF_AZUL)},
				{ novoHorario(HOR_DIA_6_SDU_CNF_AZUL)},
				
				{ novoHorario(HOR_DIA_1_SDU_CWB_AZUL)},
				{ novoHorario(HOR_DIA_2_SDU_CWB_AZUL)},
				{ novoHorario(HOR_DIA_3_SDU_CWB_AZUL)},
				{ novoHorario(HOR_DIA_4_SDU_CWB_AZUL)},
				{ novoHorario(HOR_DIA_5_SDU_CWB_AZUL)},
				{ novoHorario(HOR_DIA_6_SDU_CWB_AZUL)},
				
				{ novoHorario(HOR_DIA_1_SDU_GRU_AZUL)},
				{ novoHorario(HOR_DIA_2_SDU_GRU_AZUL)},
				{ novoHorario(HOR_DIA_3_SDU_GRU_AZUL)},
				{ novoHorario(HOR_DIA_4_SDU_GRU_AZUL)},
				{ novoHorario(HOR_DIA_5_SDU_GRU_AZUL)},
				{ novoHorario(HOR_DIA_6_SDU_GRU_AZUL)},
				
				{ novoHorario(HOR_DIA_1_SDU_POA_AZUL)},
				{ novoHorario(HOR_DIA_2_SDU_POA_AZUL)},
				{ novoHorario(HOR_DIA_3_SDU_POA_AZUL)},
				{ novoHorario(HOR_DIA_4_SDU_POA_AZUL)},
				{ novoHorario(HOR_DIA_5_SDU_POA_AZUL)},
				{ novoHorario(HOR_DIA_6_SDU_POA_AZUL)},
				
				
				
				
				/////////////////////////////////////////
				// BRASILIA - GOL
				/////////////////////////////////////////
				
				{ novoHorario(HOR_DIA_1_BSB_CNF_GOL)},
				{ novoHorario(HOR_DIA_2_BSB_CNF_GOL)},
				{ novoHorario(HOR_DIA_3_BSB_CNF_GOL)},
				{ novoHorario(HOR_DIA_4_BSB_CNF_GOL)},
				{ novoHorario(HOR_DIA_5_BSB_CNF_GOL)},
				{ novoHorario(HOR_DIA_6_BSB_CNF_GOL)},
				
				{ novoHorario(HOR_DIA_1_BSB_CWB_GOL)},
				{ novoHorario(HOR_DIA_2_BSB_CWB_GOL)},
				{ novoHorario(HOR_DIA_3_BSB_CWB_GOL)},
				{ novoHorario(HOR_DIA_4_BSB_CWB_GOL)},
				{ novoHorario(HOR_DIA_5_BSB_CWB_GOL)},
				{ novoHorario(HOR_DIA_6_BSB_CWB_GOL)},
				
				{ novoHorario(HOR_DIA_1_BSB_GRU_GOL)},
				{ novoHorario(HOR_DIA_2_BSB_GRU_GOL)},
				{ novoHorario(HOR_DIA_3_BSB_GRU_GOL)},
				{ novoHorario(HOR_DIA_4_BSB_GRU_GOL)},
				{ novoHorario(HOR_DIA_5_BSB_GRU_GOL)},
				{ novoHorario(HOR_DIA_6_BSB_GRU_GOL)},
				
				{ novoHorario(HOR_DIA_1_BSB_POA_GOL)},
				{ novoHorario(HOR_DIA_2_BSB_POA_GOL)},
				{ novoHorario(HOR_DIA_3_BSB_POA_GOL)},
				{ novoHorario(HOR_DIA_4_BSB_POA_GOL)},
				{ novoHorario(HOR_DIA_5_BSB_POA_GOL)},
				{ novoHorario(HOR_DIA_6_BSB_POA_GOL)},
				
				{ novoHorario(HOR_DIA_1_BSB_SDU_GOL)},
				{ novoHorario(HOR_DIA_2_BSB_SDU_GOL)},
				{ novoHorario(HOR_DIA_3_BSB_SDU_GOL)},
				{ novoHorario(HOR_DIA_4_BSB_SDU_GOL)},
				{ novoHorario(HOR_DIA_5_BSB_SDU_GOL)},
				{ novoHorario(HOR_DIA_6_BSB_SDU_GOL)},
			
				/////////////////////////////////////////
				// BELO HORIZONTE - GOL
				/////////////////////////////////////////
				
				{ novoHorario(HOR_DIA_1_CNF_BSB_GOL)},
				{ novoHorario(HOR_DIA_2_CNF_BSB_GOL)},
				{ novoHorario(HOR_DIA_3_CNF_BSB_GOL)},
				{ novoHorario(HOR_DIA_4_CNF_BSB_GOL)},
				{ novoHorario(HOR_DIA_5_CNF_BSB_GOL)},
				{ novoHorario(HOR_DIA_6_CNF_BSB_GOL)},
				
				{ novoHorario(HOR_DIA_1_CNF_CWB_GOL)},
				{ novoHorario(HOR_DIA_2_CNF_CWB_GOL)},
				{ novoHorario(HOR_DIA_3_CNF_CWB_GOL)},
				{ novoHorario(HOR_DIA_4_CNF_CWB_GOL)},
				{ novoHorario(HOR_DIA_5_CNF_CWB_GOL)},
				{ novoHorario(HOR_DIA_6_CNF_CWB_GOL)},
				
				{ novoHorario(HOR_DIA_1_CNF_GRU_GOL)},
				{ novoHorario(HOR_DIA_2_CNF_GRU_GOL)},
				{ novoHorario(HOR_DIA_3_CNF_GRU_GOL)},
				{ novoHorario(HOR_DIA_4_CNF_GRU_GOL)},
				{ novoHorario(HOR_DIA_5_CNF_GRU_GOL)},
				{ novoHorario(HOR_DIA_6_CNF_GRU_GOL)},
								
				{ novoHorario(HOR_DIA_1_CNF_POA_GOL)},
				{ novoHorario(HOR_DIA_2_CNF_POA_GOL)},
				{ novoHorario(HOR_DIA_3_CNF_POA_GOL)},
				{ novoHorario(HOR_DIA_4_CNF_POA_GOL)},
				{ novoHorario(HOR_DIA_5_CNF_POA_GOL)},
				{ novoHorario(HOR_DIA_6_CNF_POA_GOL)},

				{ novoHorario(HOR_DIA_1_CNF_SDU_GOL)},
				{ novoHorario(HOR_DIA_2_CNF_SDU_GOL)},
				{ novoHorario(HOR_DIA_3_CNF_SDU_GOL)},
				{ novoHorario(HOR_DIA_4_CNF_SDU_GOL)},
				{ novoHorario(HOR_DIA_5_CNF_SDU_GOL)},
				{ novoHorario(HOR_DIA_6_CNF_SDU_GOL)},
				
				/////////////////////////////////////////
				// CURITIBA - GOL
				/////////////////////////////////////////
					
				{ novoHorario(HOR_DIA_1_CWB_BSB_GOL)},
				{ novoHorario(HOR_DIA_2_CWB_BSB_GOL)},
				{ novoHorario(HOR_DIA_3_CWB_BSB_GOL)},
				{ novoHorario(HOR_DIA_4_CWB_BSB_GOL)},
				{ novoHorario(HOR_DIA_5_CWB_BSB_GOL)},
				{ novoHorario(HOR_DIA_6_CWB_BSB_GOL)},
					
				{ novoHorario(HOR_DIA_1_CWB_CNF_GOL)},
				{ novoHorario(HOR_DIA_2_CWB_CNF_GOL)},
				{ novoHorario(HOR_DIA_3_CWB_CNF_GOL)},
				{ novoHorario(HOR_DIA_4_CWB_CNF_GOL)},
				{ novoHorario(HOR_DIA_5_CWB_CNF_GOL)},
				{ novoHorario(HOR_DIA_6_CWB_CNF_GOL)},
					
				{ novoHorario(HOR_DIA_1_CWB_GRU_GOL)},
				{ novoHorario(HOR_DIA_2_CWB_GRU_GOL)},
				{ novoHorario(HOR_DIA_3_CWB_GRU_GOL)},
				{ novoHorario(HOR_DIA_4_CWB_GRU_GOL)},
				{ novoHorario(HOR_DIA_5_CWB_GRU_GOL)},
				{ novoHorario(HOR_DIA_6_CWB_GRU_GOL)},
				
				{ novoHorario(HOR_DIA_1_CWB_POA_GOL)},
				{ novoHorario(HOR_DIA_2_CWB_POA_GOL)},
				{ novoHorario(HOR_DIA_3_CWB_POA_GOL)},
				{ novoHorario(HOR_DIA_4_CWB_POA_GOL)},
				{ novoHorario(HOR_DIA_5_CWB_POA_GOL)},
				{ novoHorario(HOR_DIA_6_CWB_POA_GOL)},
				
				{ novoHorario(HOR_DIA_1_CWB_SDU_GOL)},
				{ novoHorario(HOR_DIA_2_CWB_SDU_GOL)},
				{ novoHorario(HOR_DIA_3_CWB_SDU_GOL)},
				{ novoHorario(HOR_DIA_4_CWB_SDU_GOL)},
				{ novoHorario(HOR_DIA_5_CWB_SDU_GOL)},
				{ novoHorario(HOR_DIA_6_CWB_SDU_GOL)},
					
				/////////////////////////////////////////
				// GUARULHOS - GOL
				/////////////////////////////////////////
					
				/////////////////////////////////////////
				// GUARULHOS - GOL
				/////////////////////////////////////////
					
				{ novoHorario(HOR_DIA_1_GRU_BSB_GOL)},
				{ novoHorario(HOR_DIA_2_GRU_BSB_GOL)},
				{ novoHorario(HOR_DIA_3_GRU_BSB_GOL)},
				{ novoHorario(HOR_DIA_4_GRU_BSB_GOL)},
				{ novoHorario(HOR_DIA_5_GRU_BSB_GOL)},
				{ novoHorario(HOR_DIA_6_GRU_BSB_GOL)},
				
				{ novoHorario(HOR_DIA_1_GRU_CNF_GOL)},
				{ novoHorario(HOR_DIA_2_GRU_CNF_GOL)},
				{ novoHorario(HOR_DIA_3_GRU_CNF_GOL)},
				{ novoHorario(HOR_DIA_4_GRU_CNF_GOL)},
				{ novoHorario(HOR_DIA_5_GRU_CNF_GOL)},
				{ novoHorario(HOR_DIA_6_GRU_CNF_GOL)},
								
				{ novoHorario(HOR_DIA_1_GRU_CWB_GOL)},
				{ novoHorario(HOR_DIA_2_GRU_CWB_GOL)},
				{ novoHorario(HOR_DIA_3_GRU_CWB_GOL)},
				{ novoHorario(HOR_DIA_4_GRU_CWB_GOL)},
				{ novoHorario(HOR_DIA_5_GRU_CWB_GOL)},
				{ novoHorario(HOR_DIA_6_GRU_CWB_GOL)},
				
				{ novoHorario(HOR_DIA_1_GRU_POA_GOL)},
				{ novoHorario(HOR_DIA_2_GRU_POA_GOL)},
				{ novoHorario(HOR_DIA_3_GRU_POA_GOL)},
				{ novoHorario(HOR_DIA_4_GRU_POA_GOL)},
				{ novoHorario(HOR_DIA_5_GRU_POA_GOL)},
				{ novoHorario(HOR_DIA_6_GRU_POA_GOL)},
				
				{ novoHorario(HOR_DIA_1_GRU_SDU_GOL)},
				{ novoHorario(HOR_DIA_2_GRU_SDU_GOL)},
				{ novoHorario(HOR_DIA_3_GRU_SDU_GOL)},
				{ novoHorario(HOR_DIA_4_GRU_SDU_GOL)},
				{ novoHorario(HOR_DIA_5_GRU_SDU_GOL)},
				{ novoHorario(HOR_DIA_6_GRU_SDU_GOL)},
					
				/////////////////////////////////////////
				// PORTO ALEGRE - GOL
				/////////////////////////////////////////
				
				{ novoHorario(HOR_DIA_1_POA_BSB_GOL)},
				{ novoHorario(HOR_DIA_2_POA_BSB_GOL)},
				{ novoHorario(HOR_DIA_3_POA_BSB_GOL)},
				{ novoHorario(HOR_DIA_4_POA_BSB_GOL)},
				{ novoHorario(HOR_DIA_5_POA_BSB_GOL)},
				{ novoHorario(HOR_DIA_6_POA_BSB_GOL)},
					
				{ novoHorario(HOR_DIA_1_POA_CNF_GOL)},
				{ novoHorario(HOR_DIA_2_POA_CNF_GOL)},
				{ novoHorario(HOR_DIA_3_POA_CNF_GOL)},
				{ novoHorario(HOR_DIA_4_POA_CNF_GOL)},
				{ novoHorario(HOR_DIA_5_POA_CNF_GOL)},
				{ novoHorario(HOR_DIA_6_POA_CNF_GOL)},
				
				{ novoHorario(HOR_DIA_1_POA_CWB_GOL)},
				{ novoHorario(HOR_DIA_2_POA_CWB_GOL)},
				{ novoHorario(HOR_DIA_3_POA_CWB_GOL)},
				{ novoHorario(HOR_DIA_4_POA_CWB_GOL)},
				{ novoHorario(HOR_DIA_5_POA_CWB_GOL)},
				{ novoHorario(HOR_DIA_6_POA_CWB_GOL)},
				
				{ novoHorario(HOR_DIA_1_POA_GRU_GOL)},
				{ novoHorario(HOR_DIA_2_POA_GRU_GOL)},
				{ novoHorario(HOR_DIA_3_POA_GRU_GOL)},
				{ novoHorario(HOR_DIA_4_POA_GRU_GOL)},
				{ novoHorario(HOR_DIA_5_POA_GRU_GOL)},
				{ novoHorario(HOR_DIA_6_POA_GRU_GOL)},
				
				{ novoHorario(HOR_DIA_1_POA_SDU_GOL)},
				{ novoHorario(HOR_DIA_2_POA_SDU_GOL)},
				{ novoHorario(HOR_DIA_3_POA_SDU_GOL)},
				{ novoHorario(HOR_DIA_4_POA_SDU_GOL)},
				{ novoHorario(HOR_DIA_5_POA_SDU_GOL)},
				{ novoHorario(HOR_DIA_6_POA_SDU_GOL)},
					
				/////////////////////////////////////////
				// RIO DE JANEIRO - GOL
				/////////////////////////////////////////
				
				{ novoHorario(HOR_DIA_1_SDU_BSB_GOL)},
				{ novoHorario(HOR_DIA_2_SDU_BSB_GOL)},
				{ novoHorario(HOR_DIA_3_SDU_BSB_GOL)},
				{ novoHorario(HOR_DIA_4_SDU_BSB_GOL)},
				{ novoHorario(HOR_DIA_5_SDU_BSB_GOL)},
				{ novoHorario(HOR_DIA_6_SDU_BSB_GOL)},
				
				{ novoHorario(HOR_DIA_1_SDU_CNF_GOL)},
				{ novoHorario(HOR_DIA_2_SDU_CNF_GOL)},
				{ novoHorario(HOR_DIA_3_SDU_CNF_GOL)},
				{ novoHorario(HOR_DIA_4_SDU_CNF_GOL)},
				{ novoHorario(HOR_DIA_5_SDU_CNF_GOL)},
				{ novoHorario(HOR_DIA_6_SDU_CNF_GOL)},
				
				{ novoHorario(HOR_DIA_1_SDU_CWB_GOL)},
				{ novoHorario(HOR_DIA_2_SDU_CWB_GOL)},
				{ novoHorario(HOR_DIA_3_SDU_CWB_GOL)},
				{ novoHorario(HOR_DIA_4_SDU_CWB_GOL)},
				{ novoHorario(HOR_DIA_5_SDU_CWB_GOL)},
				{ novoHorario(HOR_DIA_6_SDU_CWB_GOL)},
				
				{ novoHorario(HOR_DIA_1_SDU_GRU_GOL)},
				{ novoHorario(HOR_DIA_2_SDU_GRU_GOL)},
				{ novoHorario(HOR_DIA_3_SDU_GRU_GOL)},
				{ novoHorario(HOR_DIA_4_SDU_GRU_GOL)},
				{ novoHorario(HOR_DIA_5_SDU_GRU_GOL)},
				{ novoHorario(HOR_DIA_6_SDU_GRU_GOL)},
				
				{ novoHorario(HOR_DIA_1_SDU_POA_GOL)},
				{ novoHorario(HOR_DIA_2_SDU_POA_GOL)},
				{ novoHorario(HOR_DIA_3_SDU_POA_GOL)},
				{ novoHorario(HOR_DIA_4_SDU_POA_GOL)},
				{ novoHorario(HOR_DIA_5_SDU_POA_GOL)},
				{ novoHorario(HOR_DIA_6_SDU_POA_GOL)},

				
				
				
				
				
				/////////////////////////////////////////
				// BRASILIA - TAM
				/////////////////////////////////////////
				
				{ novoHorario(HOR_DIA_1_BSB_CNF_TAM)},
				{ novoHorario(HOR_DIA_2_BSB_CNF_TAM)},
				{ novoHorario(HOR_DIA_3_BSB_CNF_TAM)},
				{ novoHorario(HOR_DIA_4_BSB_CNF_TAM)},
				{ novoHorario(HOR_DIA_5_BSB_CNF_TAM)},
				{ novoHorario(HOR_DIA_6_BSB_CNF_TAM)},
				
				{ novoHorario(HOR_DIA_1_BSB_CWB_TAM)},
				{ novoHorario(HOR_DIA_2_BSB_CWB_TAM)},
				{ novoHorario(HOR_DIA_3_BSB_CWB_TAM)},
				{ novoHorario(HOR_DIA_4_BSB_CWB_TAM)},
				{ novoHorario(HOR_DIA_5_BSB_CWB_TAM)},
				{ novoHorario(HOR_DIA_6_BSB_CWB_TAM)},
				
				{ novoHorario(HOR_DIA_1_BSB_GRU_TAM)},
				{ novoHorario(HOR_DIA_2_BSB_GRU_TAM)},
				{ novoHorario(HOR_DIA_3_BSB_GRU_TAM)},
				{ novoHorario(HOR_DIA_4_BSB_GRU_TAM)},
				{ novoHorario(HOR_DIA_5_BSB_GRU_TAM)},
				{ novoHorario(HOR_DIA_6_BSB_GRU_TAM)},
				
				{ novoHorario(HOR_DIA_1_BSB_POA_TAM)},
				{ novoHorario(HOR_DIA_2_BSB_POA_TAM)},
				{ novoHorario(HOR_DIA_3_BSB_POA_TAM)},
				{ novoHorario(HOR_DIA_4_BSB_POA_TAM)},
				{ novoHorario(HOR_DIA_5_BSB_POA_TAM)},
				{ novoHorario(HOR_DIA_6_BSB_POA_TAM)},
				
				{ novoHorario(HOR_DIA_1_BSB_SDU_TAM)},
				{ novoHorario(HOR_DIA_2_BSB_SDU_TAM)},
				{ novoHorario(HOR_DIA_3_BSB_SDU_TAM)},
				{ novoHorario(HOR_DIA_4_BSB_SDU_TAM)},
				{ novoHorario(HOR_DIA_5_BSB_SDU_TAM)},
				{ novoHorario(HOR_DIA_6_BSB_SDU_TAM)},
			
				/////////////////////////////////////////
				// BELO HORIZONTE - TAM
				/////////////////////////////////////////
					
				{ novoHorario(HOR_DIA_1_CNF_BSB_TAM)},
				{ novoHorario(HOR_DIA_2_CNF_BSB_TAM)},
				{ novoHorario(HOR_DIA_3_CNF_BSB_TAM)},
				{ novoHorario(HOR_DIA_4_CNF_BSB_TAM)},
				{ novoHorario(HOR_DIA_5_CNF_BSB_TAM)},
				{ novoHorario(HOR_DIA_6_CNF_BSB_TAM)},
				
				{ novoHorario(HOR_DIA_1_CNF_CWB_TAM)},
				{ novoHorario(HOR_DIA_2_CNF_CWB_TAM)},
				{ novoHorario(HOR_DIA_3_CNF_CWB_TAM)},
				{ novoHorario(HOR_DIA_4_CNF_CWB_TAM)},
				{ novoHorario(HOR_DIA_5_CNF_CWB_TAM)},
				{ novoHorario(HOR_DIA_6_CNF_CWB_TAM)},
				
				{ novoHorario(HOR_DIA_1_CNF_GRU_TAM)},
				{ novoHorario(HOR_DIA_2_CNF_GRU_TAM)},
				{ novoHorario(HOR_DIA_3_CNF_GRU_TAM)},
				{ novoHorario(HOR_DIA_4_CNF_GRU_TAM)},
				{ novoHorario(HOR_DIA_5_CNF_GRU_TAM)},
				{ novoHorario(HOR_DIA_6_CNF_GRU_TAM)},
								
				{ novoHorario(HOR_DIA_1_CNF_POA_TAM)},
				{ novoHorario(HOR_DIA_2_CNF_POA_TAM)},
				{ novoHorario(HOR_DIA_3_CNF_POA_TAM)},
				{ novoHorario(HOR_DIA_4_CNF_POA_TAM)},
				{ novoHorario(HOR_DIA_5_CNF_POA_TAM)},
				{ novoHorario(HOR_DIA_6_CNF_POA_TAM)},

				{ novoHorario(HOR_DIA_1_CNF_SDU_TAM)},
				{ novoHorario(HOR_DIA_2_CNF_SDU_TAM)},
				{ novoHorario(HOR_DIA_3_CNF_SDU_TAM)},
				{ novoHorario(HOR_DIA_4_CNF_SDU_TAM)},
				{ novoHorario(HOR_DIA_5_CNF_SDU_TAM)},
				{ novoHorario(HOR_DIA_6_CNF_SDU_TAM)},
					
				/////////////////////////////////////////
				// CURITIBA - TAM
				/////////////////////////////////////////
					
				{ novoHorario(HOR_DIA_1_CWB_BSB_TAM)},
				{ novoHorario(HOR_DIA_2_CWB_BSB_TAM)},
				{ novoHorario(HOR_DIA_3_CWB_BSB_TAM)},
				{ novoHorario(HOR_DIA_4_CWB_BSB_TAM)},
				{ novoHorario(HOR_DIA_5_CWB_BSB_TAM)},
				{ novoHorario(HOR_DIA_6_CWB_BSB_TAM)},
					
				{ novoHorario(HOR_DIA_1_CWB_CNF_TAM)},
				{ novoHorario(HOR_DIA_2_CWB_CNF_TAM)},
				{ novoHorario(HOR_DIA_3_CWB_CNF_TAM)},
				{ novoHorario(HOR_DIA_4_CWB_CNF_TAM)},
				{ novoHorario(HOR_DIA_5_CWB_CNF_TAM)},
				{ novoHorario(HOR_DIA_6_CWB_CNF_TAM)},
					
				{ novoHorario(HOR_DIA_1_CWB_GRU_TAM)},
				{ novoHorario(HOR_DIA_2_CWB_GRU_TAM)},
				{ novoHorario(HOR_DIA_3_CWB_GRU_TAM)},
				{ novoHorario(HOR_DIA_4_CWB_GRU_TAM)},
				{ novoHorario(HOR_DIA_5_CWB_GRU_TAM)},
				{ novoHorario(HOR_DIA_6_CWB_GRU_TAM)},
				
				{ novoHorario(HOR_DIA_1_CWB_POA_TAM)},
				{ novoHorario(HOR_DIA_2_CWB_POA_TAM)},
				{ novoHorario(HOR_DIA_3_CWB_POA_TAM)},
				{ novoHorario(HOR_DIA_4_CWB_POA_TAM)},
				{ novoHorario(HOR_DIA_5_CWB_POA_TAM)},
				{ novoHorario(HOR_DIA_6_CWB_POA_TAM)},
				
				{ novoHorario(HOR_DIA_1_CWB_SDU_TAM)},
				{ novoHorario(HOR_DIA_2_CWB_SDU_TAM)},
				{ novoHorario(HOR_DIA_3_CWB_SDU_TAM)},
				{ novoHorario(HOR_DIA_4_CWB_SDU_TAM)},
				{ novoHorario(HOR_DIA_5_CWB_SDU_TAM)},
				{ novoHorario(HOR_DIA_6_CWB_SDU_TAM)},
					
				/////////////////////////////////////////
				// GUARULHOS - TAM
				/////////////////////////////////////////
					
				{ novoHorario(HOR_DIA_1_GRU_BSB_TAM)},
				{ novoHorario(HOR_DIA_2_GRU_BSB_TAM)},
				{ novoHorario(HOR_DIA_3_GRU_BSB_TAM)},
				{ novoHorario(HOR_DIA_4_GRU_BSB_TAM)},
				{ novoHorario(HOR_DIA_5_GRU_BSB_TAM)},
				{ novoHorario(HOR_DIA_6_GRU_BSB_TAM)},
				
				{ novoHorario(HOR_DIA_1_GRU_CNF_TAM)},
				{ novoHorario(HOR_DIA_2_GRU_CNF_TAM)},
				{ novoHorario(HOR_DIA_3_GRU_CNF_TAM)},
				{ novoHorario(HOR_DIA_4_GRU_CNF_TAM)},
				{ novoHorario(HOR_DIA_5_GRU_CNF_TAM)},
				{ novoHorario(HOR_DIA_6_GRU_CNF_TAM)},
								
				{ novoHorario(HOR_DIA_1_GRU_CWB_TAM)},
				{ novoHorario(HOR_DIA_2_GRU_CWB_TAM)},
				{ novoHorario(HOR_DIA_3_GRU_CWB_TAM)},
				{ novoHorario(HOR_DIA_4_GRU_CWB_TAM)},
				{ novoHorario(HOR_DIA_5_GRU_CWB_TAM)},
				{ novoHorario(HOR_DIA_6_GRU_CWB_TAM)},
				
				{ novoHorario(HOR_DIA_1_GRU_POA_TAM)},
				{ novoHorario(HOR_DIA_2_GRU_POA_TAM)},
				{ novoHorario(HOR_DIA_3_GRU_POA_TAM)},
				{ novoHorario(HOR_DIA_4_GRU_POA_TAM)},
				{ novoHorario(HOR_DIA_5_GRU_POA_TAM)},
				{ novoHorario(HOR_DIA_6_GRU_POA_TAM)},
				
				{ novoHorario(HOR_DIA_1_GRU_SDU_TAM)},
				{ novoHorario(HOR_DIA_2_GRU_SDU_TAM)},
				{ novoHorario(HOR_DIA_3_GRU_SDU_TAM)},
				{ novoHorario(HOR_DIA_4_GRU_SDU_TAM)},
				{ novoHorario(HOR_DIA_5_GRU_SDU_TAM)},
				{ novoHorario(HOR_DIA_6_GRU_SDU_TAM)},
					
				/////////////////////////////////////////
				// PORTO ALEGRE - TAM
				/////////////////////////////////////////
				
				{ novoHorario(HOR_DIA_1_POA_BSB_TAM)},
				{ novoHorario(HOR_DIA_2_POA_BSB_TAM)},
				{ novoHorario(HOR_DIA_3_POA_BSB_TAM)},
				{ novoHorario(HOR_DIA_4_POA_BSB_TAM)},
				{ novoHorario(HOR_DIA_5_POA_BSB_TAM)},
				{ novoHorario(HOR_DIA_6_POA_BSB_TAM)},
					
				{ novoHorario(HOR_DIA_1_POA_CNF_TAM)},
				{ novoHorario(HOR_DIA_2_POA_CNF_TAM)},
				{ novoHorario(HOR_DIA_3_POA_CNF_TAM)},
				{ novoHorario(HOR_DIA_4_POA_CNF_TAM)},
				{ novoHorario(HOR_DIA_5_POA_CNF_TAM)},
				{ novoHorario(HOR_DIA_6_POA_CNF_TAM)},
				
				{ novoHorario(HOR_DIA_1_POA_CWB_TAM)},
				{ novoHorario(HOR_DIA_2_POA_CWB_TAM)},
				{ novoHorario(HOR_DIA_3_POA_CWB_TAM)},
				{ novoHorario(HOR_DIA_4_POA_CWB_TAM)},
				{ novoHorario(HOR_DIA_5_POA_CWB_TAM)},
				{ novoHorario(HOR_DIA_6_POA_CWB_TAM)},
				
				{ novoHorario(HOR_DIA_1_POA_GRU_TAM)},
				{ novoHorario(HOR_DIA_2_POA_GRU_TAM)},
				{ novoHorario(HOR_DIA_3_POA_GRU_TAM)},
				{ novoHorario(HOR_DIA_4_POA_GRU_TAM)},
				{ novoHorario(HOR_DIA_5_POA_GRU_TAM)},
				{ novoHorario(HOR_DIA_6_POA_GRU_TAM)},
				
				{ novoHorario(HOR_DIA_1_POA_SDU_TAM)},
				{ novoHorario(HOR_DIA_2_POA_SDU_TAM)},
				{ novoHorario(HOR_DIA_3_POA_SDU_TAM)},
				{ novoHorario(HOR_DIA_4_POA_SDU_TAM)},
				{ novoHorario(HOR_DIA_5_POA_SDU_TAM)},
				{ novoHorario(HOR_DIA_6_POA_SDU_TAM)},
					
				/////////////////////////////////////////
				// RIO DE JANEIRO - TAM
				/////////////////////////////////////////
				
				{ novoHorario(HOR_DIA_1_SDU_BSB_TAM)},
				{ novoHorario(HOR_DIA_2_SDU_BSB_TAM)},
				{ novoHorario(HOR_DIA_3_SDU_BSB_TAM)},
				{ novoHorario(HOR_DIA_4_SDU_BSB_TAM)},
				{ novoHorario(HOR_DIA_5_SDU_BSB_TAM)},
				{ novoHorario(HOR_DIA_6_SDU_BSB_TAM)},
				
				{ novoHorario(HOR_DIA_1_SDU_CNF_TAM)},
				{ novoHorario(HOR_DIA_2_SDU_CNF_TAM)},
				{ novoHorario(HOR_DIA_3_SDU_CNF_TAM)},
				{ novoHorario(HOR_DIA_4_SDU_CNF_TAM)},
				{ novoHorario(HOR_DIA_5_SDU_CNF_TAM)},
				{ novoHorario(HOR_DIA_6_SDU_CNF_TAM)},
				
				{ novoHorario(HOR_DIA_1_SDU_CWB_TAM)},
				{ novoHorario(HOR_DIA_2_SDU_CWB_TAM)},
				{ novoHorario(HOR_DIA_3_SDU_CWB_TAM)},
				{ novoHorario(HOR_DIA_4_SDU_CWB_TAM)},
				{ novoHorario(HOR_DIA_5_SDU_CWB_TAM)},
				{ novoHorario(HOR_DIA_6_SDU_CWB_TAM)},
				
				{ novoHorario(HOR_DIA_1_SDU_GRU_TAM)},
				{ novoHorario(HOR_DIA_2_SDU_GRU_TAM)},
				{ novoHorario(HOR_DIA_3_SDU_GRU_TAM)},
				{ novoHorario(HOR_DIA_4_SDU_GRU_TAM)},
				{ novoHorario(HOR_DIA_5_SDU_GRU_TAM)},
				{ novoHorario(HOR_DIA_6_SDU_GRU_TAM)},
				
				{ novoHorario(HOR_DIA_1_SDU_POA_TAM)},
				{ novoHorario(HOR_DIA_2_SDU_POA_TAM)},
				{ novoHorario(HOR_DIA_3_SDU_POA_TAM)},
				{ novoHorario(HOR_DIA_4_SDU_POA_TAM)},
				{ novoHorario(HOR_DIA_5_SDU_POA_TAM)},
				{ novoHorario(HOR_DIA_6_SDU_POA_TAM)}
			});
	}

	
	
	
	@Test
	public void criar() {
		Long id = HorarioBC.getInstance().insert(horario);
		
		// Verifica se o id eh maior que zero
		Assert.assertTrue(id > 0);
	}
	
	/**
	 * Metodo para criar uma nova Cia Aerea
	 * @return
	 */
	public static Horario novoHorario(HorarioEnum horarioEnum){
		
		Rota filtroRota = new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco()));
		filtroRota.getCiaAerea().setNome(horarioEnum.getRota().getCiaAerea().getNome());
		filtroRota.getOrigem().getEndereco().setCidade(horarioEnum.getRota().getOrigem().getEnderecoEnum().getCidade());
		filtroRota.getDestino().getEndereco().setCidade(horarioEnum.getRota().getDestino().getEnderecoEnum().getCidade());
		List<Rota> rotas = RotaBC.getInstance().findByFilter(filtroRota);
		
		Aviao filtroAviao = new Aviao(new CiaAerea());
		filtroAviao.getCiaAerea().setNome(horarioEnum.getRota().getCiaAerea().getNome());
		filtroAviao.setCodigo(horarioEnum.getAviao().getCodigo());
		List<Aviao> avioes = AviaoBC.getInstance().findByFilter(filtroAviao);
		
		Horario horario = new Horario(rotas.get(0), avioes.get(0));
		horario.setPartida(horarioEnum.getDataPartida());
		horario.setChegada(datePlusHours(horarioEnum.getDataPartida(), horarioEnum.getTempoViagem()));
		horario.setCodigo(horarioEnum.getCodigo());
		horario.setQtdEconomica(horarioEnum.getQtdEconomica());
		horario.setQtdExecutiva(horarioEnum.getQtdExecutiva());
		horario.setQtdPrimeira(horarioEnum.getQtdPrimeira());
		
		//ESSA PARTE SERA ADICIONADA VIA CASCADE. DEVERAO SER REALIZADAS ALGUMAS ALTERACOES NO
		//CODIGO DE ACORDO COM O DOCUMENTO DE CORRECOES DISPONIVEL NO EUREKA
		
		for (int i = 0; i < horario.getQtdEconomica(); i++) {
			new Economica(horario);
		}
		for (int i = 0; i < horario.getQtdExecutiva(); i++) {
			new Executiva(horario);
		}
		for (int i = 0; i < horario.getQtdPrimeira(); i++) {
			new Primeira(horario);
		}
		
		return horario;
	}	
}
