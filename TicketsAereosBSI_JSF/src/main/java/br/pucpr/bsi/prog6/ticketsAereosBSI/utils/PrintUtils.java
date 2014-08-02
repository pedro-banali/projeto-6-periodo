package br.pucpr.bsi.prog6.ticketsAereosBSI.utils;

/**
 * Classe Utilitaria para a impressao de informacoes sobre um determinado objeto
 * @author Mauda
 *
 */

public class PrintUtils {
	
	public static void imprimeNomeMetodoChamadorEClasse(Object object){
		System.out.println("\n\n\n////////////////////////////////////////////////////");
		System.out.println("Metodo: " + Thread.currentThread().getStackTrace()[2].getMethodName());
		System.out.println("Objeto: " + object);
		System.out.println("////////////////////////////////////////////////////");		
	}
}
