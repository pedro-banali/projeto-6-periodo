package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum.VENDIDO;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BagagemEnum.PASSAGEIRO_01_B_01_BAGAGEM_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BagagemEnum.PASSAGEIRO_02_B_01_BAGAGEM_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BagagemEnum.PASSAGEIRO_02_B_01_BAGAGEM_02;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BagagemEnum.PASSAGEIRO_03_B_01_BAGAGEM_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BagagemEnum.PASSAGEIRO_03_B_01_BAGAGEM_02;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BagagemEnum.PASSAGEIRO_03_B_01_BAGAGEM_03;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BagagemEnum.PASSAGEIRO_04_B_01_BAGAGEM_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BagagemEnum.PASSAGEIRO_05_B_01_BAGAGEM_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BagagemEnum.PASSAGEIRO_05_B_01_BAGAGEM_02;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BagagemEnum.PASSAGEIRO_06_B_01_BAGAGEM_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BagagemEnum.PASSAGEIRO_06_B_01_BAGAGEM_02;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BagagemEnum.PASSAGEIRO_06_B_01_BAGAGEM_03;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.BagagemBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.BilheteBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.BilheteBCFactory;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PassageiroBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.dto.BilheteDTO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.BilheteFactory;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Horario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BagagemEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.DateUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

@RunWith(Parameterized.class)
public class TesteCheckInLabPopulate {

	private BagagemEnum bagagemEnum;
	
	public TesteCheckInLabPopulate(BagagemEnum bagagemEnum) {
		this.bagagemEnum = bagagemEnum;
	}

	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] {
				
				{PASSAGEIRO_01_B_01_BAGAGEM_01},
				
				{PASSAGEIRO_02_B_01_BAGAGEM_01},
				{PASSAGEIRO_02_B_01_BAGAGEM_02},
				
				{PASSAGEIRO_03_B_01_BAGAGEM_01},
				{PASSAGEIRO_03_B_01_BAGAGEM_02},
				{PASSAGEIRO_03_B_01_BAGAGEM_03},

				{PASSAGEIRO_04_B_01_BAGAGEM_01},
				
				{PASSAGEIRO_05_B_01_BAGAGEM_01},
				{PASSAGEIRO_05_B_01_BAGAGEM_02},
				
				{PASSAGEIRO_06_B_01_BAGAGEM_01},
				{PASSAGEIRO_06_B_01_BAGAGEM_02},
				{PASSAGEIRO_06_B_01_BAGAGEM_03}
				
			});
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void criar() {
		Passageiro filtroPassageiro = new Passageiro(new Endereco());
		filtroPassageiro.setNome(bagagemEnum.getBilheteEnum().getPassageiroEnum().getNome());
		filtroPassageiro.setDocumento(bagagemEnum.getBilheteEnum().getPassageiroEnum().getDocumento());
		List<Passageiro> passageiros = PassageiroBC.getInstance().findByFilter(filtroPassageiro);
		
		Bilhete filtroBilhete = BilheteFactory.getInstance(bagagemEnum.getBilheteEnum().getTipoBilheteEnum(), new Horario(new Rota(new CiaAerea(),new Aeroporto(new Endereco()), new Aeroporto(new Endereco())),new Aviao(new CiaAerea())));
		filtroBilhete.getHorario().setPartida(DateUtils.minimizeDate(bagagemEnum.getBilheteEnum().getHorarioEnum().getDataPartida()));
		filtroBilhete.setSituacaoEnum(VENDIDO);
		filtroBilhete.getHorario().getRota().getCiaAerea().setNome(bagagemEnum.getBilheteEnum().getHorarioEnum().getRota().getCiaAerea().getNome());
		filtroBilhete.getHorario().getRota().getOrigem().setCodigo(bagagemEnum.getBilheteEnum().getHorarioEnum().getRota().getOrigem().getCodigo());
		filtroBilhete.getHorario().getRota().getDestino().setCodigo(bagagemEnum.getBilheteEnum().getHorarioEnum().getRota().getDestino().getCodigo());
		filtroBilhete.setPassageiro(passageiros.get(0));
		BilheteBC<Bilhete> bilheteBC = BilheteBCFactory.getInstanceBC(bagagemEnum.getBilheteEnum().getTipoBilheteEnum());
		List bilhetes = bilheteBC.findByFilter(filtroBilhete);
		
		if(bilhetes.isEmpty()){
			Assert.fail();
		}
		
		//Nao ocorrere erro aqui, pois a lista retornada realmente possui instancias de BilheteDTO
		BilheteDTO bilheteDTO = (BilheteDTO) bilhetes.get(0);
		BagagemBC.getInstance().realizarCheckIn(bilheteDTO.getIdBilhete(),
				bilheteDTO.getTipoBilhete(), bagagemEnum.getTipoBagagemEnum(), bagagemEnum.getPeso());
	}	
}
