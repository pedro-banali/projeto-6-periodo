package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBagagemEnum.MAO;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBagagemEnum.NACIONAL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_01_BILHETE_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_02_BILHETE_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_03_BILHETE_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_04_BILHETE_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_05_BILHETE_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_06_BILHETE_01;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBagagemEnum;


public enum BagagemEnum {
	
	PASSAGEIRO_01_B_01_BAGAGEM_01(PASSAGEIRO_01_BILHETE_01, MAO, 4.3),
	
	PASSAGEIRO_02_B_01_BAGAGEM_01(PASSAGEIRO_02_BILHETE_01, MAO, 4.5),
	PASSAGEIRO_02_B_01_BAGAGEM_02(PASSAGEIRO_02_BILHETE_01, NACIONAL, 20.0),
	
	PASSAGEIRO_03_B_01_BAGAGEM_01(PASSAGEIRO_03_BILHETE_01, MAO, 3.2),
	PASSAGEIRO_03_B_01_BAGAGEM_02(PASSAGEIRO_03_BILHETE_01, NACIONAL, 18.2),
	PASSAGEIRO_03_B_01_BAGAGEM_03(PASSAGEIRO_03_BILHETE_01, NACIONAL, 15.4),

	PASSAGEIRO_04_B_01_BAGAGEM_01(PASSAGEIRO_04_BILHETE_01, MAO, 3.1),
	
	PASSAGEIRO_05_B_01_BAGAGEM_01(PASSAGEIRO_05_BILHETE_01, MAO, 2.2),
	PASSAGEIRO_05_B_01_BAGAGEM_02(PASSAGEIRO_05_BILHETE_01, NACIONAL, 12.3),
	
	PASSAGEIRO_06_B_01_BAGAGEM_01(PASSAGEIRO_06_BILHETE_01, MAO, 3.6),
	PASSAGEIRO_06_B_01_BAGAGEM_02(PASSAGEIRO_06_BILHETE_01, NACIONAL, 16.8),
	PASSAGEIRO_06_B_01_BAGAGEM_03(PASSAGEIRO_06_BILHETE_01, NACIONAL, 13.4);

	private BilheteEnum bilheteEnum;
	private TipoBagagemEnum tipoBagagemEnum;
	private double peso;
	
	private BagagemEnum(BilheteEnum bilheteEnum, TipoBagagemEnum tipoBagagemEnum, double peso) {
		this.bilheteEnum = bilheteEnum;
		this.tipoBagagemEnum = tipoBagagemEnum;
		this.peso = peso;
	}
	
	public BilheteEnum getBilheteEnum() {
		return bilheteEnum;
	}
	
	public TipoBagagemEnum getTipoBagagemEnum() {
		return tipoBagagemEnum;
	}
	
	public double getPeso() {
		return peso;
	}
}
