package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_BSB_CNF_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_BSB_CNF_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_BSB_CNF_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_BSB_CWB_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_BSB_CWB_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_BSB_CWB_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_BSB_GRU_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_BSB_GRU_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_BSB_GRU_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_BSB_POA_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_BSB_POA_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_BSB_POA_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_BSB_SDU_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_BSB_SDU_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_BSB_SDU_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CNF_BSB_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CNF_BSB_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CNF_BSB_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CNF_CWB_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CNF_CWB_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CNF_CWB_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CNF_GRU_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CNF_GRU_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CNF_GRU_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CNF_POA_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CNF_POA_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CNF_POA_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CNF_SDU_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CNF_SDU_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CNF_SDU_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CWB_BSB_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CWB_BSB_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CWB_BSB_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CWB_CNF_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CWB_CNF_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CWB_CNF_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CWB_GRU_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CWB_GRU_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CWB_GRU_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CWB_POA_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CWB_POA_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CWB_POA_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CWB_SDU_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CWB_SDU_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_CWB_SDU_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_GRU_BSB_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_GRU_BSB_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_GRU_BSB_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_GRU_CNF_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_GRU_CNF_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_GRU_CNF_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_GRU_CWB_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_GRU_CWB_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_GRU_CWB_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_GRU_POA_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_GRU_POA_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_GRU_POA_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_GRU_SDU_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_GRU_SDU_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_GRU_SDU_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_POA_BSB_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_POA_BSB_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_POA_BSB_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_POA_CNF_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_POA_CNF_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_POA_CNF_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_POA_CWB_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_POA_CWB_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_POA_CWB_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_POA_GRU_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_POA_GRU_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_POA_GRU_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_POA_SDU_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_POA_SDU_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_POA_SDU_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_SDU_BSB_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_SDU_BSB_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_SDU_BSB_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_SDU_CNF_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_SDU_CNF_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_SDU_CNF_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_SDU_CWB_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_SDU_CWB_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_SDU_CWB_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_SDU_GRU_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_SDU_GRU_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_SDU_GRU_TAM;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_SDU_POA_AZUL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_SDU_POA_GOL;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum.ROTA_SDU_POA_TAM;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.AeroportoBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.CiaAereaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.RotaBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.RotaEnum;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

@RunWith(Parameterized.class)
public class TesteRotaLabPopulate {

	private Rota rota;

	public TesteRotaLabPopulate(Rota rota) {
		this.rota = rota;
	}

	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] {
				{ novaRota(ROTA_BSB_CNF_AZUL) },
				{ novaRota(ROTA_BSB_CWB_AZUL) },
				{ novaRota(ROTA_BSB_GRU_AZUL) },
				{ novaRota(ROTA_BSB_POA_AZUL) },
				{ novaRota(ROTA_BSB_SDU_AZUL) },
				
				{ novaRota(ROTA_CNF_BSB_AZUL) },
				{ novaRota(ROTA_CNF_CWB_AZUL) },
				{ novaRota(ROTA_CNF_GRU_AZUL) },
				{ novaRota(ROTA_CNF_POA_AZUL) },
				{ novaRota(ROTA_CNF_SDU_AZUL) },
				
				{ novaRota(ROTA_CWB_BSB_AZUL) },
				{ novaRota(ROTA_CWB_CNF_AZUL) },
				{ novaRota(ROTA_CWB_GRU_AZUL) },
				{ novaRota(ROTA_CWB_POA_AZUL) },
				{ novaRota(ROTA_CWB_SDU_AZUL) },
				
				{ novaRota(ROTA_GRU_BSB_AZUL) },
				{ novaRota(ROTA_GRU_CNF_AZUL) },
				{ novaRota(ROTA_GRU_CWB_AZUL) },
				{ novaRota(ROTA_GRU_POA_AZUL) },
				{ novaRota(ROTA_GRU_SDU_AZUL) },
				
				{ novaRota(ROTA_POA_BSB_AZUL) },
				{ novaRota(ROTA_POA_CNF_AZUL) },
				{ novaRota(ROTA_POA_CWB_AZUL) },
				{ novaRota(ROTA_POA_GRU_AZUL) },
				{ novaRota(ROTA_POA_SDU_AZUL) },
				
				{ novaRota(ROTA_SDU_BSB_AZUL) },
				{ novaRota(ROTA_SDU_CNF_AZUL) },
				{ novaRota(ROTA_SDU_CWB_AZUL) },
				{ novaRota(ROTA_SDU_GRU_AZUL) },
				{ novaRota(ROTA_SDU_POA_AZUL) },
				
				{ novaRota(ROTA_BSB_CNF_GOL) },
				{ novaRota(ROTA_BSB_CWB_GOL) },
				{ novaRota(ROTA_BSB_GRU_GOL) },
				{ novaRota(ROTA_BSB_POA_GOL) },
				{ novaRota(ROTA_BSB_SDU_GOL) },
				
				{ novaRota(ROTA_CNF_BSB_GOL) },
				{ novaRota(ROTA_CNF_CWB_GOL) },
				{ novaRota(ROTA_CNF_GRU_GOL) },
				{ novaRota(ROTA_CNF_POA_GOL) },
				{ novaRota(ROTA_CNF_SDU_GOL) },
				
				{ novaRota(ROTA_CWB_BSB_GOL) },
				{ novaRota(ROTA_CWB_CNF_GOL) },
				{ novaRota(ROTA_CWB_GRU_GOL) },
				{ novaRota(ROTA_CWB_POA_GOL) },
				{ novaRota(ROTA_CWB_SDU_GOL) },
				
				{ novaRota(ROTA_GRU_BSB_GOL) },
				{ novaRota(ROTA_GRU_CNF_GOL) },
				{ novaRota(ROTA_GRU_CWB_GOL) },
				{ novaRota(ROTA_GRU_POA_GOL) },
				{ novaRota(ROTA_GRU_SDU_GOL) },
				
				{ novaRota(ROTA_POA_BSB_GOL) },
				{ novaRota(ROTA_POA_CNF_GOL) },
				{ novaRota(ROTA_POA_CWB_GOL) },
				{ novaRota(ROTA_POA_GRU_GOL) },
				{ novaRota(ROTA_POA_SDU_GOL) },
				
				{ novaRota(ROTA_SDU_BSB_GOL) },
				{ novaRota(ROTA_SDU_CNF_GOL) },
				{ novaRota(ROTA_SDU_CWB_GOL) },
				{ novaRota(ROTA_SDU_GRU_GOL) },
				{ novaRota(ROTA_SDU_POA_GOL) },
				
				{ novaRota(ROTA_BSB_CNF_TAM) },
				{ novaRota(ROTA_BSB_CWB_TAM) },
				{ novaRota(ROTA_BSB_GRU_TAM) },
				{ novaRota(ROTA_BSB_POA_TAM) },
				{ novaRota(ROTA_BSB_SDU_TAM) },
				
				{ novaRota(ROTA_CNF_BSB_TAM) },
				{ novaRota(ROTA_CNF_CWB_TAM) },
				{ novaRota(ROTA_CNF_GRU_TAM) },
				{ novaRota(ROTA_CNF_POA_TAM) },
				{ novaRota(ROTA_CNF_SDU_TAM) },
				
				{ novaRota(ROTA_CWB_BSB_TAM) },
				{ novaRota(ROTA_CWB_CNF_TAM) },
				{ novaRota(ROTA_CWB_GRU_TAM) },
				{ novaRota(ROTA_CWB_POA_TAM) },
				{ novaRota(ROTA_CWB_SDU_TAM) },
				
				{ novaRota(ROTA_GRU_BSB_TAM) },
				{ novaRota(ROTA_GRU_CNF_TAM) },
				{ novaRota(ROTA_GRU_CWB_TAM) },
				{ novaRota(ROTA_GRU_POA_TAM) },
				{ novaRota(ROTA_GRU_SDU_TAM) },
				
				{ novaRota(ROTA_POA_BSB_TAM) },
				{ novaRota(ROTA_POA_CNF_TAM) },
				{ novaRota(ROTA_POA_CWB_TAM) },
				{ novaRota(ROTA_POA_GRU_TAM) },
				{ novaRota(ROTA_POA_SDU_TAM) },
				
				{ novaRota(ROTA_SDU_BSB_TAM) },
				{ novaRota(ROTA_SDU_CNF_TAM) },
				{ novaRota(ROTA_SDU_CWB_TAM) },
				{ novaRota(ROTA_SDU_GRU_TAM) },
				{ novaRota(ROTA_SDU_POA_TAM) },
			});
	}

	@Test
	public void criar() {
		Long id = RotaBC.getInstance().insert(rota);
		
		// Verifica se o id eh maior que zero
		Assert.assertTrue(id > 0);
	}
	
	/**
	 * Metodo para criar uma nova Cia Aerea
	 * @return
	 */
	public static Rota novaRota(RotaEnum rotaEnum){
		CiaAerea filtroCiaAerea = new CiaAerea();
		filtroCiaAerea.setNome(rotaEnum.getCiaAerea().getNome());
		List<CiaAerea> ciaAerea = CiaAereaBC.getInstance().findByFilter(filtroCiaAerea);
		
		Aeroporto filtroAeroporto = new Aeroporto(new Endereco());
		filtroAeroporto.getEndereco().setCidade(rotaEnum.getOrigem().getEnderecoEnum().getCidade());
		List<Aeroporto> origens = AeroportoBC.getInstance().findByFilter(filtroAeroporto);
		
		filtroAeroporto.getEndereco().setCidade(rotaEnum.getDestino().getEnderecoEnum().getCidade());
		List<Aeroporto> destinos = AeroportoBC.getInstance().findByFilter(filtroAeroporto);
		
		Rota rota = new Rota(ciaAerea.get(0), origens.get(0), destinos.get(0));
		rota.setNome(rotaEnum.getNome());
		rota.setDescricao(rotaEnum.getDescricao());
		
		return rota;
	}	
}
