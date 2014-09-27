package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.queries;

import java.util.Date;

import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.BilheteFactory;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Economica;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Horario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AeroportoEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.DateUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

public class TesteEconomicaLabQueries extends TesteBilheteLabQueries<Economica> {
	
	/**
	 * Metodo a ser implementado nos testes das filhas
	 * @return
	 */
	public TipoBilheteEnum getTipoBilheteEnum(){
		return TipoBilheteEnum.ECONOMICA;
	}
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterNulo(){
		bilheteBC.findByFilter(null);
	}	

	
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterVazio(){
		Economica filter = (Economica) BilheteFactory.getInstance(getTipoBilheteEnum(), new Horario(new Rota(new CiaAerea(),new Aeroporto(new Endereco()), new Aeroporto(new Endereco())),new Aviao(new CiaAerea())));
		bilheteBC.findByFilter(filter);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterSoComSituacao(){
		Economica filter = (Economica) BilheteFactory.getInstance(getTipoBilheteEnum(), new Horario(new Rota(new CiaAerea(),new Aeroporto(new Endereco()), new Aeroporto(new Endereco())),new Aviao(new CiaAerea())));
		filter.setSituacaoEnum(SituacaoBilheteEnum.DISPONIVEL);
		bilheteBC.findByFilter(filter);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterSoComSituacaoPartida(){
		Economica filter = (Economica) BilheteFactory.getInstance(getTipoBilheteEnum(), new Horario(new Rota(new CiaAerea(),new Aeroporto(new Endereco()), new Aeroporto(new Endereco())),new Aviao(new CiaAerea())));
		filter.setSituacaoEnum(SituacaoBilheteEnum.DISPONIVEL);
		filter.getHorario().setPartida(DateUtils.minimizeDate(new Date()));
		bilheteBC.findByFilter(filter);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterSoComSituacaoPartidaCodigoOrigem(){
		Economica filter = (Economica) BilheteFactory.getInstance(getTipoBilheteEnum(), new Horario(new Rota(new CiaAerea(),new Aeroporto(new Endereco()), new Aeroporto(new Endereco())),new Aviao(new CiaAerea())));
		filter.setSituacaoEnum(SituacaoBilheteEnum.DISPONIVEL);
		filter.getHorario().setPartida(DateUtils.minimizeDate(new Date()));
		filter.getHorario().getRota().getOrigem().setCodigo(AeroportoEnum.AERO_BRASILIA.getCodigo());
		bilheteBC.findByFilter(filter);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterSoComSituacaoPartidaCidadeOrigem(){
		Economica filter = (Economica) BilheteFactory.getInstance(getTipoBilheteEnum(), new Horario(new Rota(new CiaAerea(),new Aeroporto(new Endereco()), new Aeroporto(new Endereco())),new Aviao(new CiaAerea())));
		filter.setSituacaoEnum(SituacaoBilheteEnum.DISPONIVEL);
		filter.getHorario().setPartida(DateUtils.minimizeDate(new Date()));
		filter.getHorario().getRota().getOrigem().getEndereco().setCidade(AeroportoEnum.AERO_BRASILIA.getEnderecoEnum().getCidade());
		bilheteBC.findByFilter(filter);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterSoComSituacaoPartidaCodigoDestino(){
		Economica filter = (Economica) BilheteFactory.getInstance(getTipoBilheteEnum(), new Horario(new Rota(new CiaAerea(),new Aeroporto(new Endereco()), new Aeroporto(new Endereco())),new Aviao(new CiaAerea())));
		filter.setSituacaoEnum(SituacaoBilheteEnum.DISPONIVEL);
		filter.getHorario().setPartida(DateUtils.minimizeDate(new Date()));
		filter.getHorario().getRota().getDestino().setCodigo(AeroportoEnum.AERO_BRASILIA.getCodigo());
		bilheteBC.findByFilter(filter);
	}	
	
	@Test(expected = TicketsAereosBSIException.class)
	public void testFindByFilterSoComSituacaoPartidaCidadeDestino(){
		Economica filter = (Economica) BilheteFactory.getInstance(getTipoBilheteEnum(), new Horario(new Rota(new CiaAerea(),new Aeroporto(new Endereco()), new Aeroporto(new Endereco())),new Aviao(new CiaAerea())));
		filter.setSituacaoEnum(SituacaoBilheteEnum.DISPONIVEL);
		filter.getHorario().setPartida(DateUtils.minimizeDate(new Date()));
		filter.getHorario().getRota().getDestino().getEndereco().setCidade(AeroportoEnum.AERO_BRASILIA.getEnderecoEnum().getCidade());
		bilheteBC.findByFilter(filter);
	}	
}
