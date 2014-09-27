package br.pucpr.bsi.prog6.ticketsAereosBSI.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;

@Entity
@Inheritance
@DiscriminatorColumn(name="tipo", discriminatorType= DiscriminatorType.STRING) 
public abstract class Bilhete implements IdentifierInterface, Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1288350832675933793L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private int numero;
	private String assento;
	
	@Column(name="tipo", updatable=false, insertable=false)
	@Enumerated(EnumType.STRING)
	private TipoBilheteEnum tipoBilhete;
	
	@Column(name="situacao")
	@Enumerated(EnumType.STRING)
	private SituacaoBilheteEnum situacaoBilhete;
	
	@ManyToOne
	@JoinColumn(name="id_passageiro")
	private Passageiro passageiro;
	
	@ManyToOne
	@JoinColumn(name="id_horario")
	private Horario horario;
	
	@OneToMany(mappedBy="bilhete",  fetch=FetchType.EAGER)
	private List<Bagagem> bagagens;
	
	public Bilhete(Horario horario, Passageiro passageiro)
	{
				
		this.situacaoBilhete = SituacaoBilheteEnum.DISPONIVEL;
		
	}
	
	public Bilhete(Horario horario)
	{
		this.horario = horario;		
		this.situacaoBilhete = SituacaoBilheteEnum.DISPONIVEL;		
	}
	
	protected Bilhete() {
		// TODO Auto-generated constructor stub
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
		return tipoBilhete;
	}
	public void setTipoBilheteEnum(TipoBilheteEnum tipoBilhete) {
		this.tipoBilhete = tipoBilhete;
	}
	public SituacaoBilheteEnum getSituacaoEnum() {
		return situacaoBilhete;
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
	
	public void setSituacaoEnum(SituacaoBilheteEnum situacaoBilhete) {
		// TODO Auto-generated method stub
		this.situacaoBilhete = situacaoBilhete;
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
				+ "]";
	}
	
	
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bilhete other = (Bilhete) obj;
		if (assento == null) {
			if (other.assento != null)
				return false;
		} else if (!assento.equals(other.assento))
			return false;
		if (bagagens == null) {
			if (other.bagagens != null)
				return false;
		} else if (!bagagens.equals(other.bagagens))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero != other.numero)
			return false;
		if (passageiro == null) {
			if (other.passageiro != null)
				return false;
		} else if (!passageiro.equals(other.passageiro))
			return false;
		if (situacaoBilhete != other.situacaoBilhete)
			return false;
		if (tipoBilhete != other.tipoBilhete)
			return false;
		return true;
	}

	public abstract int getMaxBagagens();
	

}
