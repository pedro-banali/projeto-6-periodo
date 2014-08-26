package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util;

import java.util.Date;

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

/**
 * Classe responsavel por atualizar informacoes para update e comparacoes
 * @author Mauda
 *
 */
public class Atualizador {
	
	/**
	 * Metodo responsavel por atualizar informacoes do objeto
	 * @param usuario
	 * @param cod
	 */
	public static void atualizarAeroporto(Aeroporto usuario, String cod){
		usuario.setCodigo(cod 		+ usuario.getCodigo());
		usuario.setNome(cod 		+ usuario.getNome());

		//Atualiza o endereco
		atualizarEndereco(usuario.getEndereco(), cod);
	}
	
	/**
	 * Metodo responsavel por atualizar informacoes do objeto
	 * @param usuario
	 * @param cod
	 */
	public static void atualizarAviao(Aviao usuario, String cod){
		usuario.setCodigo(cod 		+ usuario.getCodigo());
		usuario.setCarga(3000 		+ usuario.getCarga());
	}
	
	/**
	 * Metodo responsavel por atualizar informacoes do objeto
	 * @param usuario
	 * @param cod
	 */
	public static void atualizarBilhete(Bilhete usuario, String cod){
		usuario.setAssento(cod 		+ usuario.getAssento());
		usuario.setNumero(3000);
	}
	
	
	/**
	 * Metodo responsavel por atualizar informacoes do objeto
	 * @param ciaAerea
	 * @param cod
	 */
	public static void atualizarCiaAerea(CiaAerea object, String cod){
		object.setNome(cod + object.getNome());
	}
	
	/**
	 * Metodo responsavel por atualizar informacoes do objeto
	 * @param endereco
	 * @param cod
	 */
	public static void atualizarEndereco(Endereco endereco, String cod){
		//Atualiza o endereco
		endereco.setBairro(cod + endereco.getBairro());
		endereco.setCidade(cod + endereco.getCidade());
		endereco.setComplemento(cod + endereco.getComplemento());
		endereco.setEstado(cod + endereco.getEstado());
		endereco.setNumero(100000);
		endereco.setPais(cod + endereco.getPais());
		endereco.setRua(cod + endereco.getRua());
	}
	
	/**
	 * Metodo responsavel por atualizar informacoes do objeto
	 * @param objeto
	 * @param cod
	 */
	public static void atualizarFuncionario(Funcionario objeto, String cod){
		objeto.setCodigo(			cod	+ objeto.getCodigo());
		objeto.setContaCorrente(	cod	+ objeto.getContaCorrente());

		atualizarPessoa(objeto, cod);
	}
	
	/**
	 * Metodo responsavel por atualizar informacoes do objeto
	 * @param objeto
	 * @param cod
	 */
	public static void atualizarHorario(Horario objeto, String cod){
		objeto.setCodigo(cod 		+ objeto.getCodigo());
		
		objeto.setQtdEconomica(objeto.getQtdEconomica() + 10);
		objeto.setQtdExecutiva(objeto.getQtdExecutiva() + 10);
		objeto.setQtdPrimeira(objeto.getQtdPrimeira() + 10);
	}
	
	/**
	 * Metodo responsavel por atualizar informacoes do objeto
	 * @param usuario
	 * @param cod
	 */
	public static void atualizarBagagem(Bagagem usuario, String cod){
		usuario.setPeso(3000);
	}
	
	
	/**
	 * Metodo responsavel por atualizar informacoes do objeto
	 * @param papel
	 * @param cod
	 */
	public static void atualizarPapel(Papel object, String cod){
		object.setDescricao(cod + object.getDescricao());
		object.setNome(cod + object.getNome());
	}
	
	/**
	 * Metodo responsavel por atualizar informacoes do objeto
	 * @param objeto
	 * @param cod
	 */
	public static void atualizarPassageiro(Passageiro objeto, String cod){
		objeto.setDocumento(	cod	+ objeto.getDocumento());
		objeto.setNumeroCartao(	cod	+ objeto.getNumeroCartao());

		atualizarPessoa(objeto, cod);
	}
	
	/**
	 * Metodo responsavel por atualizar informacoes do objeto
	 * @param usuario
	 * @param cod
	 */
	public static void atualizarPessoa(Pessoa usuario, String cod){
		usuario.setDataNascimento(	new Date());
		usuario.setEmail(cod 		+ usuario.getEmail());
		usuario.setNome(cod 		+ usuario.getNome());
		usuario.setSenha(cod 		+ usuario.getSenha());
		usuario.setTelefone(cod 	+ usuario.getTelefone());
		usuario.setUsuario(cod 		+ usuario.getUsuario());

		//Atualiza o endereco
		atualizarEndereco(usuario.getEndereco(), cod);
	}
	
	/**
	 * Metodo responsavel por atualizar informacoes do objeto
	 * @param papel
	 * @param cod
	 */
	public static void atualizarRota(Rota object, String cod){
		object.setDescricao(cod + object.getDescricao());
		object.setNome(cod + object.getNome());
	}
}
