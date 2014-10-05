package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.EconomicaDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.ExecutivaDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.PrimeiraDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Economica;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Executiva;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Primeira;

public abstract class BilheteBC<T extends Bilhete> extends PatternBC<T> {

	@Override
	protected void validateForDataModification(Bilhete object) {
		if (object == null) {
			throw new TicketsAereosBSIException("ER0040");
		}
		if (StringUtils.isBlank(object.getAssento())) {
			throw new TicketsAereosBSIException("ER0041");
		}
		if (object.getNumero() == 0) {
			throw new TicketsAereosBSIException("ER0042");
		}
		if (object.getNumero() < 0) {
			throw new TicketsAereosBSIException("ER0043");
		}
		if (object.getHorario() == null) {
			throw new TicketsAereosBSIException("ER0044");
		}
		if (object.getPassageiro() == null) {
			throw new TicketsAereosBSIException("ER0045");
		}
		HorarioBC.getInstance()
				.validateForDataModification(object.getHorario());
		PassageiroBC.getInstance().validateForDataModification(
				object.getPassageiro());
	}

	@Override
	protected boolean validateForFindData(T object) {
		if (object != null) {
			if (object.getSituacaoEnum() != null
					&& object.getHorario().getPartida() != null) {
				if (StringUtils.isNotBlank(object.getHorario().getRota()
						.getOrigem().getCodigo())
						|| StringUtils.isNotBlank(object.getHorario().getRota()
								.getOrigem().getEndereco().getCidade())) {
					if (StringUtils.isNotBlank(object.getHorario().getRota()
							.getDestino().getCodigo())
							|| StringUtils.isNotBlank(object.getHorario()
									.getRota().getDestino().getEndereco()
									.getCidade())) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public abstract List<String> findAssentosDisponiveis(long idHorario);

	public void reservarBilhete(Long idBilhete, Passageiro passageiro,
			String assento) {

		Bilhete bilhete = null;

		PassageiroBC.getInstance().validateForDataModification(passageiro);

		if (idBilhete == null) {
			throw new TicketsAereosBSIException("ER0130");
		}

		if (StringUtils.isEmpty(assento)) {
			throw new TicketsAereosBSIException("ER0131");
		}
		
		if (bilhete == null) {
			bilhete = EconomicaDAO.getInstance().findById(idBilhete);
		}
		if (bilhete == null) {
			bilhete = ExecutivaDAO.getInstance().findById(idBilhete);
		}
		if (bilhete == null) {
			bilhete = PrimeiraDAO.getInstance().findById(idBilhete);
		}
		if (bilhete == null) {
			throw new TicketsAereosBSIException("ER0140"); 
		}
		
		if (bilhete.getSituacaoEnum() != SituacaoBilheteEnum.DISPONIVEL) {
			throw new TicketsAereosBSIException("ER0132");
		}
		bilhete.setPassageiro(passageiro);
		bilhete.setSituacaoEnum(SituacaoBilheteEnum.RESERVADO);
		bilhete.setNumero(bilhete.getId().intValue());
		bilhete.setAssento(assento);

		switch (bilhete.getTipoBilheteEnum()) {
		case ECONOMICA:
			EconomicaDAO.getInstance().update((Economica) bilhete);
			break;
		case EXECUTIVA:
			ExecutivaDAO.getInstance().update((Executiva) bilhete);
			break;
		case PRIMEIRA:
			PrimeiraDAO.getInstance().update((Primeira) bilhete);
			break;
		default:
			break;
		}
	}

	public void comprarBilhete(Long idBilhete) {
		Bilhete bilhete;

		if (idBilhete == null) {
			throw new TicketsAereosBSIException("ER0140"); // Bilhete nulo
		}

		bilhete = EconomicaDAO.getInstance().findById(idBilhete);
		if (bilhete == null) {
			bilhete = ExecutivaDAO.getInstance().findById(idBilhete);
		}
		if (bilhete == null) {
			bilhete = PrimeiraDAO.getInstance().findById(idBilhete);
		}
		if (bilhete == null) {
			throw new TicketsAereosBSIException("ER0140"); // Bilhete nulo
		}

		if (bilhete.getSituacaoEnum() != SituacaoBilheteEnum.RESERVADO) {
			throw new TicketsAereosBSIException("ER0141");
		}

		bilhete.setSituacaoEnum(SituacaoBilheteEnum.VENDIDO);

		switch (bilhete.getTipoBilheteEnum()) {
		case ECONOMICA:
			EconomicaDAO.getInstance().update((Economica) bilhete);
			break;
		case EXECUTIVA:
			ExecutivaDAO.getInstance().update((Executiva) bilhete);
			break;
		case PRIMEIRA:
			PrimeiraDAO.getInstance().update((Primeira) bilhete);
			break;
		default:
			break;
		}
	}
}
