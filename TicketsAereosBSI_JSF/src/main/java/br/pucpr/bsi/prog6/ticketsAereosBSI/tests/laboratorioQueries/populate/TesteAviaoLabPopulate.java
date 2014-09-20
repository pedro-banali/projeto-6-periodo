package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_10_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_10_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_10_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_11_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_11_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_11_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_12_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_12_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_12_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_13_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_13_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_13_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_14_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_14_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_14_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_15_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_15_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_15_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_16_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_16_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_16_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_17_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_17_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_17_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_18_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_18_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_18_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_19_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_19_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_19_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_1_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_1_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_1_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_20_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_20_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_20_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_21_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_21_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_21_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_22_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_22_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_22_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_23_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_23_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_23_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_24_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_24_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_24_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_25_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_25_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_25_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_26_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_26_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_26_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_27_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_27_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_27_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_28_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_28_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_28_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_29_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_29_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_29_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_2_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_2_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_2_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_30_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_30_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_30_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_3_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_3_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_3_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_4_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_4_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_4_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_5_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_5_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_5_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_6_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_6_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_6_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_7_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_7_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_7_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_8_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_8_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_8_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_9_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.AVIAO_9_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum.*;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.CiaAereaEnum.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AviaoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.CiaAereaEnum;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

@RunWith(Parameterized.class)
public class TesteAviaoLabPopulate {

	private Aviao aviao;

	public TesteAviaoLabPopulate(Aviao aviao) {
		this.aviao = aviao;
	}

	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] {
				{ novoAviao(AZUL, AVIAO_1_AZUL) },
				{ novoAviao(AZUL, AVIAO_2_AZUL) },
				{ novoAviao(AZUL, AVIAO_3_AZUL) },
				{ novoAviao(AZUL, AVIAO_4_AZUL) },
				{ novoAviao(AZUL, AVIAO_5_AZUL) },
				{ novoAviao(AZUL, AVIAO_6_AZUL) },
				{ novoAviao(AZUL, AVIAO_7_AZUL) },
				{ novoAviao(AZUL, AVIAO_8_AZUL) },
				{ novoAviao(AZUL, AVIAO_9_AZUL) },
				{ novoAviao(AZUL, AVIAO_10_AZUL) },
				{ novoAviao(AZUL, AVIAO_11_AZUL) },
				{ novoAviao(AZUL, AVIAO_12_AZUL) },
				{ novoAviao(AZUL, AVIAO_13_AZUL) },
				{ novoAviao(AZUL, AVIAO_14_AZUL) },
				{ novoAviao(AZUL, AVIAO_15_AZUL) },
				{ novoAviao(AZUL, AVIAO_16_AZUL) },
				{ novoAviao(AZUL, AVIAO_17_AZUL) },
				{ novoAviao(AZUL, AVIAO_18_AZUL) },
				{ novoAviao(AZUL, AVIAO_19_AZUL) },
				{ novoAviao(AZUL, AVIAO_20_AZUL) },
				{ novoAviao(AZUL, AVIAO_21_AZUL) },
				{ novoAviao(AZUL, AVIAO_22_AZUL) },
				{ novoAviao(AZUL, AVIAO_23_AZUL) },
				{ novoAviao(AZUL, AVIAO_24_AZUL) },
				{ novoAviao(AZUL, AVIAO_25_AZUL) },
				{ novoAviao(AZUL, AVIAO_26_AZUL) },
				{ novoAviao(AZUL, AVIAO_27_AZUL) },
				{ novoAviao(AZUL, AVIAO_28_AZUL) },
				{ novoAviao(AZUL, AVIAO_29_AZUL) },
				{ novoAviao(AZUL, AVIAO_30_AZUL) },
				
				{ novoAviao(GOL, AVIAO_1_GOL) },
				{ novoAviao(GOL, AVIAO_2_GOL) },
				{ novoAviao(GOL, AVIAO_3_GOL) },
				{ novoAviao(GOL, AVIAO_4_GOL) },
				{ novoAviao(GOL, AVIAO_5_GOL) },
				{ novoAviao(GOL, AVIAO_6_GOL) },
				{ novoAviao(GOL, AVIAO_7_GOL) },
				{ novoAviao(GOL, AVIAO_8_GOL) },
				{ novoAviao(GOL, AVIAO_9_GOL) },
				{ novoAviao(GOL, AVIAO_10_GOL) },
				{ novoAviao(GOL, AVIAO_11_GOL) },
				{ novoAviao(GOL, AVIAO_12_GOL) },
				{ novoAviao(GOL, AVIAO_13_GOL) },
				{ novoAviao(GOL, AVIAO_14_GOL) },
				{ novoAviao(GOL, AVIAO_15_GOL) },
				{ novoAviao(GOL, AVIAO_16_GOL) },
				{ novoAviao(GOL, AVIAO_17_GOL) },
				{ novoAviao(GOL, AVIAO_18_GOL) },
				{ novoAviao(GOL, AVIAO_19_GOL) },
				{ novoAviao(GOL, AVIAO_20_GOL) },
				{ novoAviao(GOL, AVIAO_21_GOL) },
				{ novoAviao(GOL, AVIAO_22_GOL) },
				{ novoAviao(GOL, AVIAO_23_GOL) },
				{ novoAviao(GOL, AVIAO_24_GOL) },
				{ novoAviao(GOL, AVIAO_25_GOL) },
				{ novoAviao(GOL, AVIAO_26_GOL) },
				{ novoAviao(GOL, AVIAO_27_GOL) },
				{ novoAviao(GOL, AVIAO_28_GOL) },
				{ novoAviao(GOL, AVIAO_29_GOL) },
				{ novoAviao(GOL, AVIAO_30_GOL) },
				
				{ novoAviao(TAM, AVIAO_1_TAM) },
				{ novoAviao(TAM, AVIAO_2_TAM) },
				{ novoAviao(TAM, AVIAO_3_TAM) },
				{ novoAviao(TAM, AVIAO_4_TAM) },
				{ novoAviao(TAM, AVIAO_5_TAM) },
				{ novoAviao(TAM, AVIAO_6_TAM) },
				{ novoAviao(TAM, AVIAO_7_TAM) },
				{ novoAviao(TAM, AVIAO_8_TAM) },
				{ novoAviao(TAM, AVIAO_9_TAM) },
				{ novoAviao(TAM, AVIAO_10_TAM) },
				{ novoAviao(TAM, AVIAO_11_TAM) },
				{ novoAviao(TAM, AVIAO_12_TAM) },
				{ novoAviao(TAM, AVIAO_13_TAM) },
				{ novoAviao(TAM, AVIAO_14_TAM) },
				{ novoAviao(TAM, AVIAO_15_TAM) },
				{ novoAviao(TAM, AVIAO_16_TAM) },
				{ novoAviao(TAM, AVIAO_17_TAM) },
				{ novoAviao(TAM, AVIAO_18_TAM) },
				{ novoAviao(TAM, AVIAO_19_TAM) },
				{ novoAviao(TAM, AVIAO_20_TAM) },
				{ novoAviao(TAM, AVIAO_21_TAM) },
				{ novoAviao(TAM, AVIAO_22_TAM) },
				{ novoAviao(TAM, AVIAO_23_TAM) },
				{ novoAviao(TAM, AVIAO_24_TAM) },
				{ novoAviao(TAM, AVIAO_25_TAM) },
				{ novoAviao(TAM, AVIAO_26_TAM) },
				{ novoAviao(TAM, AVIAO_27_TAM) },
				{ novoAviao(TAM, AVIAO_28_TAM) },
				{ novoAviao(TAM, AVIAO_29_TAM) },
				{ novoAviao(TAM, AVIAO_30_TAM) }
			});
	}

	@Test
	public void criar() {
		Long id = AviaoBC.getInstance().insert(aviao);
		
		// Verifica se o id eh maior que zero
		Assert.assertTrue(id > 0);
	}
	
	public static Aviao novoAviao(CiaAereaEnum ciaAereaEnum, AviaoEnum aviaoEnum){
		CiaAerea filtro = new CiaAerea();
		filtro.setNome(ciaAereaEnum.getNome());
		List<CiaAerea> ciaAereas = CiaAereaBC.getInstance().findByFilter(filtro);
		
		Aviao novoAviao = new Aviao(ciaAereas.get(0));
		novoAviao.setCodigo(aviaoEnum.getCodigo());
		novoAviao.setCarga(aviaoEnum.getCarga());
		return novoAviao;
	}	
}
