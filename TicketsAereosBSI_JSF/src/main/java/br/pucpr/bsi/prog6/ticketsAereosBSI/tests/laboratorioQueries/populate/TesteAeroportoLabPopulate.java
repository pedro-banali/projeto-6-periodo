package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AeroportoEnum.AERO_BRASILIA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AeroportoEnum.AERO_CONFINS;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AeroportoEnum.AERO_CURITIBA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AeroportoEnum.AERO_GUARULHOS;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AeroportoEnum.AERO_PORTO_ALEGRE;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AeroportoEnum.AERO_SANTOS_DUMONT;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AeroportoEnum;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

@RunWith(Parameterized.class)
public class TesteAeroportoLabPopulate {

	private Aeroporto aeroporto;

	public TesteAeroportoLabPopulate(Aeroporto aeroporto) {
		this.aeroporto = aeroporto;
	}

	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] {
				{ novoAeroporto(AERO_BRASILIA) },
				{ novoAeroporto(AERO_CONFINS) },
				{ novoAeroporto(AERO_CURITIBA) },
				{ novoAeroporto(AERO_GUARULHOS) },
				{ novoAeroporto(AERO_PORTO_ALEGRE) },
				{ novoAeroporto(AERO_SANTOS_DUMONT) }
			});
	}
	
	@Test
	public void criar() {
		Long id = AeroportoBC.getInstance().insert(aeroporto);
		
		// Verifica se o id eh maior que zero
		Assert.assertTrue(id > 0);
	}
	
	/**
	 * Metodo para criar uma nova Cia Aerea
	 * @return
	 */
	public static Aeroporto novoAeroporto(AeroportoEnum aeroportoEnum){
		Aeroporto aeroporto = new Aeroporto(aeroportoEnum.getEnderecoEnum().novoEndereco());
		aeroporto.setNome(aeroportoEnum.getNome());
		aeroporto.setCodigo(aeroportoEnum.getCodigo());
		return aeroporto;
	}
}
