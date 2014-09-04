package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;


@Entity
@DiscriminatorValue(value="3")
public class Primeira extends Bilhete {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1011263709895674561L;
	
	public Primeira(Horario horario, Passageiro passageiro)
	{
		super(horario, passageiro);
		setTipoBilheteEnum(TipoBilheteEnum.PRIMEIRA);
	}
	
	
}
