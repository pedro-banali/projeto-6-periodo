package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.queries;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.utils.DateUtils.datePlusHours;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.HorarioBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Horario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AeroportoEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.AviaoEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.CiaAereaEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.HorarioEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util.Verificador;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.DateUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */

public class TesteHorarioLabQueries {

	@Test
	public void testFindAlleFindById(){
		List<Horario> horarios = HorarioBC.getInstance().findAll();
		
		//Verifica se a quantidade de horario eh a mesma dos testes de populate
		Assert.assertEquals(horarios.size(), HorarioEnum.values().length);
		
		for (Horario horarioFindAll : horarios) {
			Horario horarioFindId = HorarioBC.getInstance().findById(horarioFindAll.getId());
			Verificador.verificar(horarioFindAll, horarioFindId);			
		}
		
		//buscando um id inexistente
		Horario horarioIdInvalido = HorarioBC.getInstance().findById(100000);
		Assert.assertNull(horarioIdInvalido);
	}
	
	///////////////////////////////////////////////////////////
	// DADOS DO ROTA
	///////////////////////////////////////////////////////////
	
	@Test
	public void testFindByFilterCodigoHorario(){
		Horario filter = new Horario(new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco())), new Aviao(new CiaAerea()));
		for (HorarioEnum horarioEnum : HorarioEnum.values()) {
			filter.setCodigo(horarioEnum.getCodigo());
			List<Horario> horarioFilter = HorarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 1
			Assert.assertEquals(horarioFilter.size(), 1);
			
			for (Horario horario : horarioFilter) {
				Assert.assertEquals(horario.getCodigo(), horarioEnum.getCodigo());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterPartidaHorario(){
		Horario filter = new Horario(new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco())), new Aviao(new CiaAerea()));
		for (HorarioEnum horarioEnum : HorarioEnum.values()) {
			filter.setPartida(horarioEnum.getDataPartida());
			List<Horario> horarioFilter = HorarioBC.getInstance().findByFilter(filter);
			
			for (Horario horario : horarioFilter) {
				Assert.assertEquals(DateUtils.minimizeDate(horario.getPartida()),
						DateUtils.minimizeDate(horarioEnum.getDataPartida()));				
			}
		}
	}
	
	@Test
	public void testFindByFilterChegadaHorario(){
		Horario filter = new Horario(new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco())), new Aviao(new CiaAerea()));
		for (HorarioEnum horarioEnum : HorarioEnum.values()) {
			filter.setChegada(datePlusHours(horarioEnum.getDataPartida(), horarioEnum.getTempoViagem()));
			List<Horario> horarioFilter = HorarioBC.getInstance().findByFilter(filter);
			
			for (Horario horario : horarioFilter) {
				Assert.assertEquals(DateUtils.minimizeDate(horario.getChegada()),
						DateUtils.minimizeDate(datePlusHours(horarioEnum.getDataPartida(), horarioEnum.getTempoViagem())));
			}
		}
	}
	
	///////////////////////////////////////////////////////////
	// DADOS DO AVIAO
	///////////////////////////////////////////////////////////
	
	@Test
	public void testFindByFilterAviao(){
		Horario filter = new Horario(new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco())), new Aviao(new CiaAerea()));
		for (AviaoEnum aviaoEnum : AviaoEnum.values()) {
			filter.getAviao().setCodigo(aviaoEnum.getCodigo());
			List<Horario> horarioFilter = HorarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 6
			Assert.assertEquals(horarioFilter.size(), 6);
			
			for (Horario horario : horarioFilter) {
				Assert.assertEquals(horario.getAviao().getCodigo(), aviaoEnum.getCodigo());				
			}
		}
	}	
	
	
	///////////////////////////////////////////////////////////
	// DADOS DO CIAAEREA
	///////////////////////////////////////////////////////////
	@Test
	public void testFindByFilterCiaAerea(){
		Horario filter = new Horario(new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco())), new Aviao(new CiaAerea()));
		for (CiaAereaEnum ciaAereaEnum : CiaAereaEnum.values()) {
			filter.getRota().getCiaAerea().setNome(ciaAereaEnum.getNome());
			List<Horario> horarioFilter = HorarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 180
			Assert.assertEquals(horarioFilter.size(), 180);
			
			for (Horario horario : horarioFilter) {
				Assert.assertEquals(horario.getRota().getCiaAerea().getNome(), ciaAereaEnum.getNome());				
			}
		}
	}
	
	
	
	///////////////////////////////////////////////////////////
	// DADOS DO AEROPORTO
	///////////////////////////////////////////////////////////
	
	@Test
	public void testFindByFilterNomeOrigem(){
		Horario filter = new Horario(new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco())), new Aviao(new CiaAerea()));
		for (AeroportoEnum aeroportoEnum : AeroportoEnum.values()) {
			filter.getRota().getOrigem().setNome(aeroportoEnum.getNome());
			List<Horario> horarioFilter = HorarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 90
			Assert.assertEquals(horarioFilter.size(), 90);
			
			for (Horario horario : horarioFilter) {
				Assert.assertEquals(horario.getRota().getOrigem().getNome(), aeroportoEnum.getNome());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterCidadeOrigem(){
		Horario filter = new Horario(new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco())), new Aviao(new CiaAerea()));
		for (AeroportoEnum aeroportoEnum : AeroportoEnum.values()) {
			filter.getRota().getOrigem().getEndereco().setCidade(aeroportoEnum.getEnderecoEnum().getCidade());
			List<Horario> horarioFilter = HorarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 90
			Assert.assertEquals(horarioFilter.size(), 90);
			
			for (Horario horario : horarioFilter) {
				Assert.assertEquals(horario.getRota().getOrigem().getEndereco().getCidade(), aeroportoEnum.getEnderecoEnum().getCidade());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterNomeDestino(){
		Horario filter = new Horario(new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco())), new Aviao(new CiaAerea()));
		for (AeroportoEnum aeroportoEnum : AeroportoEnum.values()) {
			filter.getRota().getDestino().setNome(aeroportoEnum.getNome());
			List<Horario> horarioFilter = HorarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 90
			Assert.assertEquals(horarioFilter.size(), 90);
			
			for (Horario horario : horarioFilter) {
				Assert.assertEquals(horario.getRota().getDestino().getNome(), aeroportoEnum.getNome());				
			}
		}
	}	
	
	@Test
	public void testFindByFilterCidadeDestino(){
		Horario filter = new Horario(new Rota(new CiaAerea(), new Aeroporto(new Endereco()), new Aeroporto(new Endereco())), new Aviao(new CiaAerea()));
		for (AeroportoEnum aeroportoEnum : AeroportoEnum.values()) {
			filter.getRota().getDestino().getEndereco().setCidade(aeroportoEnum.getEnderecoEnum().getCidade());
			List<Horario> horarioFilter = HorarioBC.getInstance().findByFilter(filter);
			
			//verifica se o tamanho do filtro eh 90
			Assert.assertEquals(horarioFilter.size(), 90);
			
			for (Horario horario : horarioFilter) {
				Assert.assertEquals(horario.getRota().getDestino().getEndereco().getCidade(), aeroportoEnum.getEnderecoEnum().getCidade());				
			}
		}
	}	
}
