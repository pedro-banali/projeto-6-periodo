package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.util.ArrayList;
import java.util.List;

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
		
		List<Primeira> primeiras;

		primeiras = super.getHorario().getPrimeiras();
		
		if (primeiras == null)
			primeiras = new ArrayList<Primeira>();

		primeiras.add(this);

		this.getHorario().setPrimeiras(primeiras);

		super.setTipoBilheteEnum(TipoBilheteEnum.PRIMEIRA);
		horario.getPrimeiras().add(this);
		
	}

	public Primeira(Horario horario) {
		super(horario);
				
		List<Primeira> primeiras;

		primeiras = super.getHorario().getPrimeiras();
		
		if (primeiras == null)
			primeiras = new ArrayList<Primeira>();

		primeiras.add(this);

		this.getHorario().setPrimeiras(primeiras);

		super.setTipoBilheteEnum(TipoBilheteEnum.PRIMEIRA);
		horario.getPrimeiras().add(this);
	}
	
	@Override
	public int getMaxBagagens() {
		// TODO Auto-generated method stub
		return 3;
	}

}
