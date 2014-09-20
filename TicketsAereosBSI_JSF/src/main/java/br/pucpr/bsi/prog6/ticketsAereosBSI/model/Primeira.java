package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;

@Entity
@DiscriminatorValue(value = "PRIMEIRA")
public class Primeira extends Bilhete {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1011263709895674561L;

	@SuppressWarnings("unused")
	private Primeira() {
		super();
	}

	public Primeira(Horario horario, Passageiro passageiro) {
		super(horario, passageiro);
		setTipoBilheteEnum(TipoBilheteEnum.PRIMEIRA);
	}

	public Primeira(Horario horario) {
		super(horario);
		super.setTipoBilheteEnum(TipoBilheteEnum.PRIMEIRA);
		horario.getPrimeiras().add(this);
	}
	
	@Override
	public int getMaxBagagens() {
		// TODO Auto-generated method stub
		return 3;
	}

}
