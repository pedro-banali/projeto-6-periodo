package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.EnderecoEnum.END_AERO_BRASILIA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.EnderecoEnum.END_AERO_CONFINS;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.EnderecoEnum.END_AERO_CURITIBA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.EnderecoEnum.END_AERO_GUARULHOS;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.EnderecoEnum.END_AERO_PORTO_ALEGRE;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.EnderecoEnum.END_AERO_SANTOS_DUMONT;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PassageiroEnum.PASSAGEIRO_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PassageiroEnum.PASSAGEIRO_02;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PassageiroEnum.PASSAGEIRO_03;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PassageiroEnum.PASSAGEIRO_04;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PassageiroEnum.PASSAGEIRO_05;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PassageiroEnum.PASSAGEIRO_06;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PassageiroBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PassageiroEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.DateUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */ 

@RunWith(Parameterized.class)
public class TestePassageiroLabPopulate {

	private Passageiro passageiro;

	public TestePassageiroLabPopulate(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection objects() {
		return Arrays.asList(new Object[][] {
				{ novoPassageiro(PASSAGEIRO_01, END_AERO_BRASILIA.novoEndereco()) },
				{ novoPassageiro(PASSAGEIRO_02, END_AERO_CONFINS.novoEndereco()) },
				{ novoPassageiro(PASSAGEIRO_03, END_AERO_CURITIBA.novoEndereco()) },
				{ novoPassageiro(PASSAGEIRO_04, END_AERO_GUARULHOS.novoEndereco()) },
				{ novoPassageiro(PASSAGEIRO_05, END_AERO_PORTO_ALEGRE.novoEndereco()) },
				{ novoPassageiro(PASSAGEIRO_06, END_AERO_SANTOS_DUMONT.novoEndereco()) }
			});
	}
	
	
	@Test
	public void criar() {
		Long id = PassageiroBC.getInstance().insert(passageiro);
		
		// Verifica se o id eh maior que zero
		Assert.assertTrue(id > 0);
	}
	
	/**
	 * Metodo para criar um novo passageiro
	 * @return
	 */
	public static Passageiro novoPassageiro(PassageiroEnum passageiroEnum, Endereco endereco){
		Passageiro passageiro = new Passageiro(endereco);
		passageiro.setDataNascimento(DateUtils.converterDate(passageiroEnum.getDataNascimento()));
		passageiro.setDocumento(passageiroEnum.getDocumento());
		passageiro.setEmail(passageiroEnum.getEmail());
		passageiro.setNome(passageiroEnum.getNome());
		passageiro.setNumeroCartao(passageiroEnum.getNumeroCartao());
		passageiro.setSenha(passageiroEnum.getSenha());
		passageiro.setTelefone(passageiroEnum.getTelefone());
		passageiro.setUsuario(passageiroEnum.getUsuario());
		
		return passageiro;
	}	
}
