package br.pucpr.bsi.prog6.ticketsAereosBSI.dto;

import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.CiaAerea;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;

public class ReservarBilheteFiltroDTO {

		private String assento;
		private CiaAerea ciaAerea;
		private Aeroporto origem;
		private Aeroporto destino;
		private TipoBilheteEnum tipoBilheteEnum;
		private Passageiro passageiro;
		
		public ReservarBilheteFiltroDTO(String assento, CiaAerea ciaAerea, Aeroporto origem, Aeroporto destino, TipoBilheteEnum tipoBilheteEnum, Passageiro passageiro)
		{
			this.assento = assento;
			this.ciaAerea = ciaAerea;
			this.origem = origem;
			this.destino = destino;
			this.tipoBilheteEnum = tipoBilheteEnum;
			this.passageiro = passageiro;
		}
		
		
		public String getAssento() {
			return assento;
		}
		public void setAssento(String assento) {
			this.assento = assento;
		}
		public CiaAerea getCiaAerea() {
			return ciaAerea;
		}
		public void setCiaAerea(CiaAerea ciaAerea) {
			this.ciaAerea = ciaAerea;
		}
		public Aeroporto getOrigem() {
			return origem;
		}
		public void setOrigem(Aeroporto origem) {
			this.origem = origem;
		}
		public Aeroporto getDestino() {
			return destino;
		}
		public void setDestino(Aeroporto destino) {
			this.destino = destino;
		}
		public TipoBilheteEnum getTipoBilheteEnum() {
			return tipoBilheteEnum;
		}
		public void setTipoBilheteEnum(TipoBilheteEnum tipoBilheteEnum) {
			this.tipoBilheteEnum = tipoBilheteEnum;
		}
		public Passageiro getPassageiro() {
			return passageiro;
		}
		public void setPassageiro(Passageiro passageiro) {
			this.passageiro = passageiro;
		}	
		
}
