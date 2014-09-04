package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;

@Entity
@DiscriminatorValue(value="2")

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
