package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.CiaAereaEnum.AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.CiaAereaEnum.GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.CiaAereaEnum.TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PapelEnum.COMANDANTE_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PapelEnum.COMANDANTE_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PapelEnum.COMANDANTE_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PapelEnum.COMISSARIO_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PapelEnum.COMISSARIO_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PapelEnum.COMISSARIO_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PapelEnum.CO_PILOTO_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PapelEnum.CO_PILOTO_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PapelEnum.CO_PILOTO_TAM;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PapelBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.CiaAereaEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PapelEnum;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

@RunWith(Parameterized.class)
public class TestePapelLabPopulate {

	private Papel papel;

	public TestePapelLabPopulate(Papel papel) {
		this.papel = papel;
	}

	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection objetos() {
		return Arrays.asList(new Object[][] {
				{ novoPapel(AZUL, COMANDANTE_AZUL) },
				{ novoPapel(AZUL, CO_PILOTO_AZUL) },
				{ novoPapel(AZUL, COMISSARIO_AZUL) },
				
				{ novoPapel(GOL, COMANDANTE_GOL) },
				{ novoPapel(GOL, CO_PILOTO_GOL) },
				{ novoPapel(GOL, COMISSARIO_GOL) },
				
				{ novoPapel(TAM, COMANDANTE_TAM) },
				{ novoPapel(TAM, CO_PILOTO_TAM) },
				{ novoPapel(TAM, COMISSARIO_TAM) }
			});
	}

	@Test
	public void criar() {
		Long id = PapelBC.getInstance().insert(papel);
		
		// Verifica se o id eh maior que zero
		Assert.assertTrue(id > 0);
	}
	
	public static Papel novoPapel(CiaAereaEnum ciaAereaEnum, PapelEnum papelEnum){
		CiaAerea filtro = new CiaAerea();
		filtro.setNome(ciaAereaEnum.getNome());
		List<CiaAerea> ciaAerea = CiaAereaBC.getInstance().findByFilter(filtro);
		
		Papel papel = new Papel(ciaAerea.get(0));
		papel.setNome(papelEnum.getNome());
		papel.setDescricao(papelEnum.getDescricao());
		return papel;
	}	
}
