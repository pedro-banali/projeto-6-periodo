package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;


public class Executiva extends Bilhete {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6323444088358135086L;
	
	public Executiva(Horario horario, Passageiro passageiro)
	{
		super(horario, passageiro);
		setTipoBilheteEnum(TipoBilheteEnum.EXECUTIVA);
	}



}
