package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;

@Entity
@DiscriminatorValue(value = "ECONOMICA")
public class Economica extends Bilhete {

	/**
	 * 
	 */
	private static final long serialVersionUID = -910293633584037805L;

	@SuppressWarnings("unused")
	private Economica() {
		super();
	}

	public Economica(Horario horario, Passageiro passageiro) {
		super(horario, passageiro);

		List<Economica> economicas;

		economicas = super.getHorario().getEconomicas();

		if (economicas == null)
			economicas = new ArrayList<Economica>();

		economicas.add(this);

		this.getHorario().setEconomicas(economicas);

		super.setTipoBilheteEnum(TipoBilheteEnum.PRIMEIRA);
		horario.getEconomicas().add(this);

		setTipoBilheteEnum(TipoBilheteEnum.ECONOMICA);
	}

	public Economica(Horario horario) {
		super(horario);

		List<Economica> economicas;

		economicas = super.getHorario().getEconomicas();

		if (economicas == null)
			economicas = new ArrayList<Economica>();

		economicas.add(this);

		this.getHorario().setEconomicas(economicas);

		horario.getEconomicas().add(this);

		super.setTipoBilheteEnum(TipoBilheteEnum.ECONOMICA);
	}

	@Override
	public int getMaxBagagens() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	

}
