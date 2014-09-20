package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate;

import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.EnderecoEnum.END_AERO_BRASILIA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.EnderecoEnum.END_AERO_CONFINS;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.EnderecoEnum.END_AERO_CURITIBA;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.EnderecoEnum.END_AERO_GUARULHOS;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.EnderecoEnum.END_AERO_PORTO_ALEGRE;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.EnderecoEnum.END_AERO_SANTOS_DUMONT;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.FuncionarioEnum.FUNC_AZUL_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.FuncionarioEnum.FUNC_AZUL_02;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.FuncionarioEnum.FUNC_AZUL_03;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.FuncionarioEnum.FUNC_GOL_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.FuncionarioEnum.FUNC_GOL_02;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.FuncionarioEnum.FUNC_GOL_03;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.FuncionarioEnum.FUNC_TAM_01;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.FuncionarioEnum.FUNC_TAM_02;
import static br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.FuncionarioEnum.FUNC_TAM_03;
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

import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.FuncionarioBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.bc.PapelBC;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Funcionario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.FuncionarioEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate.enums.PapelEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.DateUtils;

/**
 * Essa classe eh um teste JUnit para a disciplina de programacao do curso de
 * BSI da PUCPR
 * 
 * @author Mauda
 * 
 */ 

@RunWith(Parameterized.class)
public class TesteFuncionarioLabPopulate {

	private Funcionario funcionario;

	public TesteFuncionarioLabPopulate(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection objetos() {
		return Arrays.asList(new Object[][] {
				{ novoFuncionario(COMANDANTE_AZUL, FUNC_AZUL_01, END_AERO_BRASILIA.novoEndereco()) },
				{ novoFuncionario(CO_PILOTO_AZUL, FUNC_AZUL_02, END_AERO_CONFINS.novoEndereco()) },
				{ novoFuncionario(COMISSARIO_AZUL, FUNC_AZUL_03, END_AERO_CURITIBA.novoEndereco()) },
				
				{ novoFuncionario(COMANDANTE_GOL, FUNC_GOL_01, END_AERO_GUARULHOS.novoEndereco()) },
				{ novoFuncionario(CO_PILOTO_GOL, FUNC_GOL_02, END_AERO_PORTO_ALEGRE.novoEndereco()) },
				{ novoFuncionario(COMISSARIO_GOL, FUNC_GOL_03, END_AERO_SANTOS_DUMONT.novoEndereco()) },
						
				{ novoFuncionario(COMANDANTE_TAM, FUNC_TAM_01, END_AERO_BRASILIA.novoEndereco()) },
				{ novoFuncionario(CO_PILOTO_TAM, FUNC_TAM_02, END_AERO_CONFINS.novoEndereco()) },
				{ novoFuncionario(COMISSARIO_TAM, FUNC_TAM_03, END_AERO_CURITIBA.novoEndereco()) }
			});
	}
	
	@Test
	public void criar() {
		Long id = FuncionarioBC.getInstance().insert(funcionario);
		
		// Verifica se o id eh maior que zero
		Assert.assertTrue(id > 0);
	}
	
	/**
	 * Metodo para criar uma nova Cia Aerea
	 * @return
	 */
	public static Funcionario novoFuncionario(PapelEnum nomePapel, FuncionarioEnum codigoFunc, Endereco endereco){
		Papel filtroPapel = new Papel(new CiaAerea());
		filtroPapel.setNome(nomePapel.getNome());
		List<Papel> papeis = PapelBC.getInstance().findByFilter(filtroPapel);
		
		Funcionario funcionario = new Funcionario(endereco, papeis.get(0));
		funcionario.setCodigo(codigoFunc.getCodigo());
		funcionario.setContaCorrente(codigoFunc.getContaCorrente());
		funcionario.setDataNascimento(DateUtils.converterDate(codigoFunc.getDataNascimento()));
		funcionario.setEmail(codigoFunc.getEmail());
		funcionario.setNome(codigoFunc.getNome());
		funcionario.setSenha(codigoFunc.getSenha());
		funcionario.setTelefone(codigoFunc.getTelefone());
		funcionario.setUsuario(codigoFunc.getUsuario());
		
		return funcionario;
	}	
}
