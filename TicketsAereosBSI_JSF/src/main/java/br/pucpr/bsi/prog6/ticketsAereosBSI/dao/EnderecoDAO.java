package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Endereco;

public class EnderecoDAO extends PatternDAO<Endereco> {

	private static final long serialVersionUID = 1L;
	private final static EnderecoDAO instance = new EnderecoDAO();

	public EnderecoDAO() {
		super(Endereco.class);
	}

	public static EnderecoDAO getInstance() {
		return instance;
	}

	@Override
	public List<Endereco> findByFilter(Endereco filter) {
		
			return null;
		
	}
}
