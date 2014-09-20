package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;

public class BilheteFactory {

	public static Bilhete getInstance(TipoBilheteEnum tipo, Horario horario) {
		switch (tipo) {
		case ECONOMICA:
			return new Economica(horario);
		case EXECUTIVA:
			return new Executiva(horario);
		case PRIMEIRA:
			return new Primeira(horario);
		}
		return null;
	}
	
}