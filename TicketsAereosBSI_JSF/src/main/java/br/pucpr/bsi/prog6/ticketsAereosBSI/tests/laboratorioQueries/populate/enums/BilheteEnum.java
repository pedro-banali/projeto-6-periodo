package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum.RESERVADO;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum.VENDIDO;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum.ECONOMICA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum.EXECUTIVA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum.PRIMEIRA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_1_BSB_CNF_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_1_BSB_CNF_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_1_CNF_CWB_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_1_CNF_CWB_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_1_CWB_GRU_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_1_CWB_GRU_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_2_CNF_CWB_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_2_CNF_CWB_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_2_CWB_GRU_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_2_CWB_GRU_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_2_GRU_POA_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_2_GRU_POA_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_3_CWB_GRU_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_3_CWB_GRU_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_3_GRU_POA_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_3_GRU_POA_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_3_POA_SDU_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_3_POA_SDU_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_4_GRU_POA_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_4_GRU_POA_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_4_POA_SDU_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_4_POA_SDU_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_4_SDU_BSB_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_4_SDU_BSB_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_5_BSB_CNF_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_5_BSB_CNF_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_5_POA_SDU_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_5_POA_SDU_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_5_SDU_BSB_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_5_SDU_BSB_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_6_BSB_CNF_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_6_BSB_CNF_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_6_CNF_CWB_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_6_CNF_CWB_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_6_SDU_BSB_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum.HOR_DIA_6_SDU_BSB_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PassageiroEnum.PASSAGEIRO_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PassageiroEnum.PASSAGEIRO_02;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PassageiroEnum.PASSAGEIRO_03;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PassageiroEnum.PASSAGEIRO_04;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PassageiroEnum.PASSAGEIRO_05;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PassageiroEnum.PASSAGEIRO_06;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;


public enum BilheteEnum {
	
	PASSAGEIRO_01_BILHETE_01(PASSAGEIRO_01, HOR_DIA_1_BSB_CNF_AZUL, ECONOMICA, VENDIDO),
	PASSAGEIRO_01_BILHETE_02(PASSAGEIRO_01, HOR_DIA_2_CNF_CWB_AZUL, ECONOMICA, VENDIDO),
	PASSAGEIRO_01_BILHETE_03(PASSAGEIRO_01, HOR_DIA_3_CWB_GRU_AZUL, ECONOMICA, VENDIDO),
	PASSAGEIRO_01_BILHETE_04(PASSAGEIRO_01, HOR_DIA_4_GRU_POA_AZUL, ECONOMICA, RESERVADO),
	PASSAGEIRO_01_BILHETE_05(PASSAGEIRO_01, HOR_DIA_5_POA_SDU_AZUL, ECONOMICA, RESERVADO),
	PASSAGEIRO_01_BILHETE_06(PASSAGEIRO_01, HOR_DIA_6_SDU_BSB_AZUL, ECONOMICA, RESERVADO),
	
	PASSAGEIRO_02_BILHETE_01(PASSAGEIRO_02, HOR_DIA_1_CNF_CWB_AZUL, EXECUTIVA, VENDIDO),
	PASSAGEIRO_02_BILHETE_02(PASSAGEIRO_02, HOR_DIA_2_CWB_GRU_AZUL, EXECUTIVA, VENDIDO),
	PASSAGEIRO_02_BILHETE_03(PASSAGEIRO_02, HOR_DIA_3_GRU_POA_AZUL, EXECUTIVA, VENDIDO),
	PASSAGEIRO_02_BILHETE_04(PASSAGEIRO_02, HOR_DIA_4_POA_SDU_AZUL, EXECUTIVA, RESERVADO),
	PASSAGEIRO_02_BILHETE_05(PASSAGEIRO_02, HOR_DIA_5_SDU_BSB_AZUL, EXECUTIVA, RESERVADO),
	PASSAGEIRO_02_BILHETE_06(PASSAGEIRO_02, HOR_DIA_6_BSB_CNF_AZUL, EXECUTIVA, RESERVADO),

	PASSAGEIRO_03_BILHETE_01(PASSAGEIRO_03, HOR_DIA_1_CWB_GRU_AZUL, PRIMEIRA, VENDIDO),
	PASSAGEIRO_03_BILHETE_02(PASSAGEIRO_03, HOR_DIA_2_GRU_POA_AZUL, PRIMEIRA, VENDIDO),
	PASSAGEIRO_03_BILHETE_03(PASSAGEIRO_03, HOR_DIA_3_POA_SDU_AZUL, PRIMEIRA, VENDIDO),
	PASSAGEIRO_03_BILHETE_04(PASSAGEIRO_03, HOR_DIA_4_SDU_BSB_AZUL, PRIMEIRA, RESERVADO),
	PASSAGEIRO_03_BILHETE_05(PASSAGEIRO_03, HOR_DIA_5_BSB_CNF_AZUL, PRIMEIRA, RESERVADO),
	PASSAGEIRO_03_BILHETE_06(PASSAGEIRO_03, HOR_DIA_6_CNF_CWB_AZUL, PRIMEIRA, RESERVADO),
	
	PASSAGEIRO_04_BILHETE_01(PASSAGEIRO_04, HOR_DIA_1_BSB_CNF_GOL, ECONOMICA, VENDIDO),
	PASSAGEIRO_04_BILHETE_02(PASSAGEIRO_04, HOR_DIA_2_CNF_CWB_GOL, ECONOMICA, VENDIDO),
	PASSAGEIRO_04_BILHETE_03(PASSAGEIRO_04, HOR_DIA_3_CWB_GRU_GOL, ECONOMICA, VENDIDO),
	PASSAGEIRO_04_BILHETE_04(PASSAGEIRO_04, HOR_DIA_4_GRU_POA_GOL, ECONOMICA, RESERVADO),
	PASSAGEIRO_04_BILHETE_05(PASSAGEIRO_04, HOR_DIA_5_POA_SDU_GOL, ECONOMICA, RESERVADO),
	PASSAGEIRO_04_BILHETE_06(PASSAGEIRO_04, HOR_DIA_6_SDU_BSB_GOL, ECONOMICA, RESERVADO),
	
	PASSAGEIRO_05_BILHETE_01(PASSAGEIRO_05, HOR_DIA_1_CNF_CWB_GOL, EXECUTIVA, VENDIDO),
	PASSAGEIRO_05_BILHETE_02(PASSAGEIRO_05, HOR_DIA_2_CWB_GRU_GOL, EXECUTIVA, VENDIDO),
	PASSAGEIRO_05_BILHETE_03(PASSAGEIRO_05, HOR_DIA_3_GRU_POA_GOL, EXECUTIVA, VENDIDO),
	PASSAGEIRO_05_BILHETE_04(PASSAGEIRO_05, HOR_DIA_4_POA_SDU_GOL, EXECUTIVA, RESERVADO),
	PASSAGEIRO_05_BILHETE_05(PASSAGEIRO_05, HOR_DIA_5_SDU_BSB_GOL, EXECUTIVA, RESERVADO),
	PASSAGEIRO_05_BILHETE_06(PASSAGEIRO_05, HOR_DIA_6_BSB_CNF_GOL, EXECUTIVA, RESERVADO),

	PASSAGEIRO_06_BILHETE_01(PASSAGEIRO_06, HOR_DIA_1_CWB_GRU_GOL, PRIMEIRA, VENDIDO),
	PASSAGEIRO_06_BILHETE_02(PASSAGEIRO_06, HOR_DIA_2_GRU_POA_GOL, PRIMEIRA, VENDIDO),
	PASSAGEIRO_06_BILHETE_03(PASSAGEIRO_06, HOR_DIA_3_POA_SDU_GOL, PRIMEIRA, VENDIDO),
	PASSAGEIRO_06_BILHETE_04(PASSAGEIRO_06, HOR_DIA_4_SDU_BSB_GOL, PRIMEIRA, RESERVADO),
	PASSAGEIRO_06_BILHETE_05(PASSAGEIRO_06, HOR_DIA_5_BSB_CNF_GOL, PRIMEIRA, RESERVADO),
	PASSAGEIRO_06_BILHETE_06(PASSAGEIRO_06, HOR_DIA_6_CNF_CWB_GOL, PRIMEIRA, RESERVADO);
	
	private PassageiroEnum passageiroEnum;
	private HorarioEnum horarioEnum;
	private TipoBilheteEnum tipoBilheteEnum;
	private SituacaoBilheteEnum situacaoEnum;
	
	private BilheteEnum(PassageiroEnum passageiroEnum, HorarioEnum horarioEnum, TipoBilheteEnum tipoBilheteEnum, SituacaoBilheteEnum situacaoEnum) {
		this.passageiroEnum = passageiroEnum;
		this.horarioEnum = horarioEnum;
		this.tipoBilheteEnum = tipoBilheteEnum;
		this.situacaoEnum = situacaoEnum;
	}
	
	public PassageiroEnum getPassageiroEnum() {
		return passageiroEnum;
	}
	
	public HorarioEnum getHorarioEnum() {
		return horarioEnum;
	}
	
	public TipoBilheteEnum getTipoBilheteEnum() {
		return tipoBilheteEnum;
	}
	
	public SituacaoBilheteEnum getSituacaoEnum() {
		return situacaoEnum;
	}
}
