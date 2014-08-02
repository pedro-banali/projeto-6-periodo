package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;

/**
 * Classe responsavel por atualizar informacoes para update e comparacoes
 * @author Mauda
 *
 */
public class Atualizador {
	
	/**
	 * Metodo responsavel por atualizar informacoes do objeto
	 * @param ciaAerea
	 * @param cod
	 */
	public static void atualizarCiaAerea(CiaAerea object, String cod){
		object.setNome(cod + object.getNome());
	}
	
}
