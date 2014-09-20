package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.CiaAereaEnum.AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.CiaAereaEnum.GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.CiaAereaEnum.TAM;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.CiaAereaEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util.Verificador;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

@RunWith(Parameterized.class)
public class TesteCiaAereaLabPopulate {

	private CiaAerea ciaAerea;

	public TesteCiaAereaLabPopulate(CiaAerea ciaAerea) {
		this.ciaAerea = ciaAerea;
	}

	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] {
				{ novaCiaAerea(AZUL) },
				{ novaCiaAerea(GOL) },
				{ novaCiaAerea(TAM) }
		});
	}

	@Test
	public void criar() {
		Long id = CiaAereaBC.getInstance().insert(ciaAerea);
		
		//Verifica se o id eh maior que zero
		Assert.assertTrue(id > 0);
		//Verifica se os Ids sao iguais
		Assert.assertEquals(id, ciaAerea.getId());
		//Obtem o objeto do BD para as comparacoes basicas
		Verificador.verificar(CiaAereaBC.getInstance().findById(id), ciaAerea);		
	}
	
	/**
	 * Metodo para criar uma nova Cia Aerea
	 * @return
	 */
	public static CiaAerea novaCiaAerea(CiaAereaEnum ciaAereaEnum){
		CiaAerea ciaAerea = new CiaAerea();
		ciaAerea.setNome(ciaAereaEnum.getNome());
		return ciaAerea;
	}
}
