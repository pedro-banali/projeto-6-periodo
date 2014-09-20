package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;

@Entity
@DiscriminatorValue(value="EXECUTIVA")
public class Executiva extends Bilhete {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6323444088358135086L;
	
	@SuppressWarnings("unused")
	private Executiva() {
		super();
	}
	
	public Executiva(Horario horario, Passageiro passageiro)
	{
		super(horario, passageiro);
		setTipoBilheteEnum(TipoBilheteEnum.EXECUTIVA);
	}
	
	
	public Executiva(Horario horario)
	{
		super(horario);
		super.setTipoBilheteEnum(TipoBilheteEnum.EXECUTIVA);
	}
	
	@Override
	public int getMaxBagagens() {
		// TODO Auto-generated method stub
		return 2;
	}

}
