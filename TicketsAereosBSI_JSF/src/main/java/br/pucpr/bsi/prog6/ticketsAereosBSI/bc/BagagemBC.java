package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.BagagemDAO;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.SituacaoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBagagemEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.enums.TipoBilheteEnum;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bagagem;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Bilhete;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Economica;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Executiva;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Primeira;

public class BagagemBC extends PatternBC<Bagagem> {

	private static BagagemBC instance;

	private BagagemBC() {

	}

	public static BagagemBC getInstance() {
		if (instance == null)
			instance = new BagagemBC();
		return instance;
	}

	@Override
	public Bagagem findById(long id) {
		// TODO Auto-generated method stub
		return BagagemDAO.getInstance().findById(id);
	}

	@Override
	public List<Bagagem> findByFilter(Bagagem filter) {
		// TODO Auto-generated method stub
		if (!this.validateForFindData(filter)) {
			throw new TicketsAereosBSIException("ER0001");
		}

		return BagagemDAO.getInstance().findByFilter(filter);
	}

	@Override
	public List<Bagagem> findAll() {
		// TODO Auto-generated method stub
		return BagagemDAO.getInstance().findAll();
	}

	@Override
	public long insert(Bagagem object) {

		BagagemDAO bagagem = BagagemDAO.getInstance();

		this.validateForDataModification(object);

		return bagagem.insert(object);
	}

	@Override
	public boolean update(Bagagem object) {

		BagagemDAO bagagem = BagagemDAO.getInstance();

		this.validateForDataModification(object);

		return bagagem.update(object);
	}

	@Override
	public boolean delete(Bagagem object) {

		BagagemDAO bagagem = BagagemDAO.getInstance();

		this.validateForDataModification(object);

		return bagagem.delete(object);
	}

	@Override
	protected void validateForDataModification(Bagagem object) {
		// TODO Auto-generated method stub
		if (object == null)
			throw new TicketsAereosBSIException("ER0030");
		else if (object.getPeso() == 0)
			throw new TicketsAereosBSIException("ER0031");
		else if (object.getPeso() < 0)
			throw new TicketsAereosBSIException("ER0032");
		else if (object.getTipoBagagemEnum() == null)
			throw new TicketsAereosBSIException("ER0033");
		else if (object.getBilhete() == null)
			throw new TicketsAereosBSIException("ER0034");
	}

	@Override
	protected boolean validateForFindData(Bagagem object) {
		// TODO Auto-generated method stub
		if (object == null && (object.getPeso() <= 0)
				&& (object.getTipoBagagemEnum() == null)
				&& (object.getBilhete().getHorario().getPartida() == null)) {
			return false;
		}

		return true;
	}

	public void realizarCheckIn(Long idBilhete, TipoBilheteEnum tipoBilhete,
			TipoBagagemEnum tipoBagagemEnum, Double peso) {
		// TODO Auto-generated method stub
		Bilhete bilhete;
		Bagagem bagagem;

		if (idBilhete != null) {
			if (tipoBilhete == TipoBilheteEnum.PRIMEIRA)
				bilhete = PrimeiraBC.getInstance().findById(idBilhete);
			else if (tipoBilhete == TipoBilheteEnum.EXECUTIVA)
				bilhete = ExecutivaBC.getInstance().findById(idBilhete);
			else
				bilhete = EconomicaBC.getInstance().findById(idBilhete);

		} else
			throw new TicketsAereosBSIException("ER0150");

		if (bilhete.getPassageiro() == null)
			throw new TicketsAereosBSIException("ER0151");
		else if (bilhete.getSituacaoEnum() != SituacaoBilheteEnum.VENDIDO)
			throw new TicketsAereosBSIException("ER0152");
		else if (bilhete.getBagagens().size() + 1 > bilhete.getMaxBagagens())
			throw new TicketsAereosBSIException("ER0153");

		bagagem = new Bagagem(tipoBagagemEnum, bilhete);
		bagagem.setPeso(peso);
		bilhete.getBagagens().add(bagagem);

		BagagemBC.getInstance().insert(bagagem);

		if (tipoBilhete == TipoBilheteEnum.PRIMEIRA)
			PrimeiraBC.getInstance().update((Primeira) bilhete);
		else if (tipoBilhete == TipoBilheteEnum.EXECUTIVA)
			ExecutivaBC.getInstance().update((Executiva) bilhete);
		else
			EconomicaBC.getInstance().update((Economica) bilhete);

	}
}
