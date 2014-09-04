package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;

@Entity
@DiscriminatorValue(value="1")

public class Economica extends Bilhete {

	/**
	 * 
	 */
	private static final long serialVersionUID = -910293633584037805L;
	
	public Economica(Horario horario, Passageiro passageiro)
	{
		super(horario, passageiro);
		setTipoBilheteEnum(TipoBilheteEnum.ECONOMICA);
	}
	
}
