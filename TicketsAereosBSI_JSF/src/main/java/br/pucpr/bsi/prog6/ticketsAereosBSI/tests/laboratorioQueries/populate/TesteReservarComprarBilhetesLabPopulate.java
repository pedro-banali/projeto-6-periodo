package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum.*;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_01_BILHETE_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_01_BILHETE_02;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_01_BILHETE_03;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_01_BILHETE_04;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_01_BILHETE_05;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_01_BILHETE_06;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_02_BILHETE_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_02_BILHETE_02;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_02_BILHETE_03;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_02_BILHETE_04;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_02_BILHETE_05;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_02_BILHETE_06;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_03_BILHETE_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_03_BILHETE_02;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_03_BILHETE_03;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_03_BILHETE_04;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_03_BILHETE_05;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_03_BILHETE_06;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_04_BILHETE_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_04_BILHETE_02;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_04_BILHETE_03;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_04_BILHETE_04;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_04_BILHETE_05;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_04_BILHETE_06;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_05_BILHETE_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_05_BILHETE_02;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_05_BILHETE_03;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_05_BILHETE_04;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_05_BILHETE_05;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_05_BILHETE_06;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_06_BILHETE_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_06_BILHETE_02;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_06_BILHETE_03;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_06_BILHETE_04;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_06_BILHETE_05;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum.PASSAGEIRO_06_BILHETE_06;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.BilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.DateUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

@RunWith(Parameterized.class)
public class TesteReservarComprarBilhetesLabPopulate {

	private BilheteEnum bilheteEnum;
	
	public TesteReservarComprarBilhetesLabPopulate(BilheteEnum bilheteEnum) {
		this.bilheteEnum = bilheteEnum;
	}

	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] {
				
				{PASSAGEIRO_01_BILHETE_01},
				{PASSAGEIRO_01_BILHETE_02},
				{PASSAGEIRO_01_BILHETE_03},
				{PASSAGEIRO_01_BILHETE_04},
				{PASSAGEIRO_01_BILHETE_05},
				{PASSAGEIRO_01_BILHETE_06},
				
				{PASSAGEIRO_02_BILHETE_01},
				{PASSAGEIRO_02_BILHETE_02},
				{PASSAGEIRO_02_BILHETE_03},
				{PASSAGEIRO_02_BILHETE_04},
				{PASSAGEIRO_02_BILHETE_05},
				{PASSAGEIRO_02_BILHETE_06},
				
				{PASSAGEIRO_03_BILHETE_01},
				{PASSAGEIRO_03_BILHETE_02},
				{PASSAGEIRO_03_BILHETE_03},
				{PASSAGEIRO_03_BILHETE_04},
				{PASSAGEIRO_03_BILHETE_05},
				{PASSAGEIRO_03_BILHETE_06},
				
				{PASSAGEIRO_04_BILHETE_01},
				{PASSAGEIRO_04_BILHETE_02},
				{PASSAGEIRO_04_BILHETE_03},
				{PASSAGEIRO_04_BILHETE_04},
				{PASSAGEIRO_04_BILHETE_05},
				{PASSAGEIRO_04_BILHETE_06},
				
				{PASSAGEIRO_05_BILHETE_01},
				{PASSAGEIRO_05_BILHETE_02},
				{PASSAGEIRO_05_BILHETE_03},
				{PASSAGEIRO_05_BILHETE_04},
				{PASSAGEIRO_05_BILHETE_05},
				{PASSAGEIRO_05_BILHETE_06},
				
				{PASSAGEIRO_06_BILHETE_01},
				{PASSAGEIRO_06_BILHETE_02},
				{PASSAGEIRO_06_BILHETE_03},
				{PASSAGEIRO_06_BILHETE_04},
				{PASSAGEIRO_06_BILHETE_05},
				{PASSAGEIRO_06_BILHETE_06}
				
			});
	}

	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void criar() {

		Passageiro filtroPassageiro = new Passageiro(new Endereco());
		filtroPassageiro.setNome(bilheteEnum.getPassageiroEnum().getNome());
		filtroPassageiro.setDocumento(bilheteEnum.getPassageiroEnum().getDocumento());
		List<Passageiro> passageiros = PassageiroBC.getInstance().findByFilter(filtroPassageiro);
		
		Bilhete filtroBilhete = BilheteFactory.getInstance(bilheteEnum.getTipoBilheteEnum(), new Horario(new Rota(new CiaAerea(),new Aeroporto(new Endereco()), new Aeroporto(new Endereco())),new Aviao(new CiaAerea())));
		filtroBilhete.getHorario().setPartida(DateUtils.minimizeDate(bilheteEnum.getHorarioEnum().getDataPartida()));
		filtroBilhete.setSituacaoEnum(DISPONIVEL);
		filtroBilhete.getHorario().getRota().getCiaAerea().setNome(bilheteEnum.getHorarioEnum().getRota().getCiaAerea().getNome());
		filtroBilhete.getHorario().getRota().getOrigem().setCodigo(bilheteEnum.getHorarioEnum().getRota().getOrigem().getCodigo());
		filtroBilhete.getHorario().getRota().getDestino().setCodigo(bilheteEnum.getHorarioEnum().getRota().getDestino().getCodigo());
		BilheteBC<Bilhete> bilheteBC = BilheteBCFactory.getInstanceBC(bilheteEnum.getTipoBilheteEnum());
		List bilhetes = bilheteBC.findByFilter(filtroBilhete);
		
		if(bilhetes.isEmpty()){
			Assert.fail();
		}
		
		//Nao ocorrera erro aqui, pois a lista retornada realmente possui instancias de BilheteDTO
		BilheteDTO bilheteDTO = (BilheteDTO) bilhetes.get(0);
		
		bilheteBC.reservarBilhete(bilheteDTO.getIdBilhete(), passageiros.get(0), bilheteBC.findAssentosDisponiveis(bilheteDTO.getIdHorario()).get(0));
		if(VENDIDO.equals(bilheteEnum.getSituacaoEnum())){
			bilheteBC.comprarBilhete(bilheteDTO.getIdBilhete());
		}
	}	
}
