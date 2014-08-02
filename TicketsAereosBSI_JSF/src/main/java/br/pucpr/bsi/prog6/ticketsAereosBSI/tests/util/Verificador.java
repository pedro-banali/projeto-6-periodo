package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.util;

import org.junit.Assert;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;

/**
 * Classe responsavel por atualizar informacoes para update e comparacoes
 * @author Mauda
 *
 */
public class Verificador {
	
	public static void verificar(CiaAerea objectBD, CiaAerea object){
		Assert.assertEquals(objectBD.getId(), 			object.getId());
		Assert.assertEquals(objectBD.getNome(), 		object.getNome());
	}
	
}
