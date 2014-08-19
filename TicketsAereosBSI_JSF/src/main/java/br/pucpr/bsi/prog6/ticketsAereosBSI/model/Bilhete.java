package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;

public abstract class Bilhete implements IdentifierInterface, Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1288350832675933793L;
	
	private long id;
	private int numero;
	private String assento;
	private TipoBilheteEnum tipoBilheteEnum;
	private SituacaoBilheteEnum situacaoBilheteEnum;
	private Passageiro passageiro;
	private Horario horario;
	private List<Bagagem> bagagens;
	
	public Bilhete(Horario horario, Passageiro passageiro)
	{
		List<Bilhete> bilhetes;
		
		this.passageiro = passageiro;
		this.horario = horario;
		
		bilhetes = this.passageiro.getBilhetes();
		
		if(bilhetes == null)
			bilhetes = new ArrayList<Bilhete>();
		
		bilhetes.add(this);
		
		this.passageiro.setBilhetes(bilhetes);
		
		bilhetes = this.horario.getBilhetes();
		
		if(bilhetes == null)
			bilhetes = new ArrayList<Bilhete>();
		
		bilhetes.add(this);
		
		this.horario.setBilhetes(bilhetes);
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getAssento() {
		return assento;
	}
	public void setAssento(String assento) {
		this.assento = assento;
	}
	public TipoBilheteEnum getTipoBilheteEnum() {
		return tipoBilheteEnum;
	}
	public void setTipoBilheteEnum(TipoBilheteEnum tipoBilheteEnum) {
		this.tipoBilheteEnum = tipoBilheteEnum;
	}
	public SituacaoBilheteEnum getSituacaoBilheteEnum() {
		return situacaoBilheteEnum;
	}
	public void setSituacaoBilheteEnum(SituacaoBilheteEnum situacaoBilheteEnum) {
		this.situacaoBilheteEnum = situacaoBilheteEnum;
	}
	public Passageiro getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	public Horario getHorario() {
		return horario;
	}
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	
	public void setSituacaoEnum(SituacaoBilheteEnum situacao) {
		// TODO Auto-generated method stub
		this.situacaoBilheteEnum = situacao;
	}

	public List<Bagagem> getBagagens() {
		return bagagens;
	}

	public void setBagagens(List<Bagagem> bagagens) {
		this.bagagens = bagagens;
	}

	@Override
	public String toString() {
		return "Bilhete [id="
				+ id
				+ ", numero="
				+ numero
				+ ", "
				+ (assento != null ? "assento=" + assento + ", " : "")
				+ (tipoBilheteEnum != null ? "tipoBilheteEnum="
						+ tipoBilheteEnum + ", " : "")
				+ (situacaoBilheteEnum != null ? "situacaoBilheteEnum="
						+ situacaoBilheteEnum + ", " : "")
				+ (passageiro != null ? "passageiro=" + passageiro + ", " : "")
				+ (horario != null ? "horario=" + horario + ", " : "")
				+ (bagagens != null ? "bagagens=" + bagagens : "") + "]";
	}
	
	

}
