package br.pucpr.bsi.prog6.ticketsAereosBSI.dto;

import java.util.Date;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;

public class BilheteDTO {
	
	private String cidadeOrigem;
	private String cidadeDestino;
	private String aeroportoOrigem;
	private String aeroportoDestino;
	private String ciaAerea;
	private Long idBilhete;
	private Long idHorario;
	private TipoBilheteEnum tipoEnum;
	private SituacaoBilheteEnum situacaoBilheteEnum;
	
	
	public BilheteDTO(String cidadeOrigem, String cidadeDestino, String aeroportoOrigem, String aeroportoDestino,
	String ciaAerea, Long idBilhete, Long idHorario, Date dataPartida, TipoBilheteEnum tipoBilhete, SituacaoBilheteEnum situacaoBilheteEnum)
	{}

	public String getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	public String getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

	public String getAeroportoOrigem() {
		return aeroportoOrigem;
	}

	public void setAeroportoOrigem(String aeroportoOrigem) {
		this.aeroportoOrigem = aeroportoOrigem;
	}

	public String getAeroportoDestino() {
		return aeroportoDestino;
	}

	public void setAeroportoDestino(String aeroportoDestino) {
		this.aeroportoDestino = aeroportoDestino;
	}

	public String getCiaAerea() {
		return ciaAerea;
	}

	public void setCiaAerea(String ciaAerea) {
		this.ciaAerea = ciaAerea;
	}

	public Long getIdBilhete() {
		return idBilhete;
	}

	public void setIdBilhete(Long idBilhete) {
		this.idBilhete = idBilhete;
	}

	public Long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Long idHorario) {
		this.idHorario = idHorario;
	}
	
	
	
}
