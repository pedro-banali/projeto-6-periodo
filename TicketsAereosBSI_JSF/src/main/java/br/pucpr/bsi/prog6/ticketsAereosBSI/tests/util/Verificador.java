package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util;

import org.junit.Assert;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bagagem;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Funcionario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Horario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Papel;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Pessoa;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Rota;
import br.pucpr.bsi.prog6.ticketsAereosBSI.utils.DateUtils;

/**
 * Classe responsavel por atualizar informacoes para update e comparacoes
 * @author Mauda
 *
 */
public class Verificador {
	
	public static void verificar(Aeroporto objetoBD, Aeroporto objeto){
		Assert.assertEquals(objetoBD.getCodigo(), 			objeto.getCodigo());
		Assert.assertEquals(objetoBD.getId(), 				objeto.getId());
		Assert.assertEquals(objetoBD.getNome(),				objeto.getNome());
		
		//Verifica o endereco
		verificar(objetoBD.getEndereco(), 			objeto.getEndereco());
	}
	
	public static void verificar(Aviao objetoBD, Aviao objeto){
		Assert.assertEquals(objetoBD.getCodigo(), 			objeto.getCodigo());
		Assert.assertEquals(objetoBD.getId(), 				objeto.getId());
		Assert.assertEquals(objetoBD.getCarga(),			objeto.getCarga(), 0);
		
		verificar(objetoBD.getCiaAerea(), objeto.getCiaAerea());
	}
	
	public static void verificar(Bagagem objetoBD, Bagagem objeto){
		Assert.assertEquals(objetoBD.getId(), 				objeto.getId());
		Assert.assertEquals(objetoBD.getPeso(), 			objeto.getPeso(), 0);
		
		verificar(objetoBD.getBilhete(), objeto.getBilhete());
	}
	
	
	public static void verificar(CiaAerea objectBD, CiaAerea object){
		Assert.assertEquals(objectBD.getId(), 			object.getId());
		Assert.assertEquals(objectBD.getNome(), 		object.getNome());
	}
	
	public static void verificar(Bilhete objetoBD, Bilhete objeto){
		Assert.assertEquals(objetoBD.getAssento(), 			objeto.getAssento());
		Assert.assertEquals(objetoBD.getId(), 				objeto.getId());
		Assert.assertEquals(objetoBD.getNumero(), 			objeto.getNumero());
		
		verificar(objetoBD.getHorario(), objeto.getHorario());
		verificar(objetoBD.getPassageiro(), objeto.getPassageiro());
	}
	
	
	public static void verificar(Endereco enderecoBD, Endereco endereco){
		Assert.assertEquals(enderecoBD.getBairro(), 		endereco.getBairro());
		Assert.assertEquals(enderecoBD.getCidade(), 		endereco.getCidade());
		Assert.assertEquals(enderecoBD.getComplemento(), 	endereco.getComplemento());
		Assert.assertEquals(enderecoBD.getEstado(), 		endereco.getEstado());
		Assert.assertEquals(enderecoBD.getId(), 			endereco.getId());
		Assert.assertEquals(enderecoBD.getNumero(),			endereco.getNumero());
		Assert.assertEquals(enderecoBD.getPais(), 			endereco.getPais());
		Assert.assertEquals(enderecoBD.getRua(), 			endereco.getRua());
	}
	
	public static void verificar(Funcionario objetoBD, Funcionario objeto){
		Assert.assertEquals(objetoBD.getCodigo(), 			objeto.getCodigo());
		Assert.assertEquals(objetoBD.getContaCorrente(), 	objeto.getContaCorrente());
		
		verificarPessoa(objetoBD, objeto);
		verificar(objetoBD.getPapel(), objeto.getPapel());
	}
	
	public static void verificar(Horario objetoBD, Horario objeto){
		Assert.assertEquals(objetoBD.getCodigo(), 								objeto.getCodigo());
		Assert.assertEquals(DateUtils.minimizeDate(objetoBD.getChegada()),	 	DateUtils.minimizeDate(objeto.getChegada()));
		Assert.assertEquals(objetoBD.getId(), 									objeto.getId());
		Assert.assertEquals(DateUtils.minimizeDate(objetoBD.getPartida()), 		DateUtils.minimizeDate(objeto.getPartida()));
		Assert.assertEquals(objetoBD.getQtdEconomica(), 						objeto.getQtdEconomica());
		Assert.assertEquals(objetoBD.getQtdExecutiva(), 						objeto.getQtdExecutiva());
		Assert.assertEquals(objetoBD.getQtdPrimeira(), 							objeto.getQtdPrimeira());
		
		verificar(objetoBD.getAviao(), objeto.getAviao());
		verificar(objetoBD.getRota(), objeto.getRota());
	}
	
	public static void verificar(Papel objetoBD, Papel objeto){
		Assert.assertEquals(objetoBD.getId(), 			objeto.getId());
		Assert.assertEquals(objetoBD.getNome(), 		objeto.getNome());
		Assert.assertEquals(objetoBD.getDescricao(), 	objeto.getDescricao());
		
		verificar(objetoBD.getCiaAerea(), objeto.getCiaAerea());
	}
	
	public static void verificar(Passageiro objetoBD, Passageiro objeto){
		Assert.assertEquals(objetoBD.getDocumento(), 		objeto.getDocumento());
		Assert.assertEquals(objetoBD.getNumeroCartao(), 	objeto.getNumeroCartao());
		
		verificarPessoa(objetoBD, objeto);
	}
	
	public static void verificarPessoa(Pessoa objetoBD, Pessoa objeto){
		Assert.assertEquals(DateUtils.minimizeDate(objetoBD.getDataNascimento()), 	DateUtils.minimizeDate(objeto.getDataNascimento()));
		Assert.assertEquals(objetoBD.getEmail(), 			objeto.getEmail());
		Assert.assertEquals(objetoBD.getId(), 				objeto.getId());
		Assert.assertEquals(objetoBD.getNome(),				objeto.getNome());
		Assert.assertEquals(objetoBD.getSenha(), 			objeto.getSenha());
		Assert.assertEquals(objetoBD.getTelefone(), 		objeto.getTelefone());
		Assert.assertEquals(objetoBD.getUsuario(), 			objeto.getUsuario());
		
		//Verifica o endereco
		verificar(objetoBD.getEndereco(), 			objeto.getEndereco());
	}
	
	public static void verificar(Rota objetoBD, Rota objeto){
		Assert.assertEquals(objetoBD.getId(), 			objeto.getId());
		Assert.assertEquals(objetoBD.getNome(), 		objeto.getNome());
		Assert.assertEquals(objetoBD.getDescricao(), 	objeto.getDescricao());
		
		verificar(objetoBD.getCiaAerea(), objeto.getCiaAerea());
		verificar(objetoBD.getOrigem(), objeto.getOrigem());
		verificar(objetoBD.getDestino(), objeto.getDestino());
	}
	
}
