package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Pessoa;

public abstract class PessoaBC<T extends Pessoa> extends PatternBC<T> {

	protected PessoaBC() {

	}

	@Override
	protected void validateForDataModification(T object) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String nameMask = "[a-zA-Z]+[a-zA-Z0-9]*([\\.|\\-|_][a-zA-Z0-9]+)*";
		String domainMask = "[a-zA-Z]+[a-zA-Z0-9]*([\\.|\\-|_][a-zA-Z0-9]+)+";
		String at = "@";
		String emailMask = nameMask + at + domainMask;
		Pattern pattern;
		Matcher matcher;

		if (object == null)
			throw new TicketsAereosBSIException("ER0110");
		else if (object.getDataNascimento() == null)
			throw new TicketsAereosBSIException("ER0111");
		else if (object.getDataNascimento().after(new Date()))
			throw new TicketsAereosBSIException("ER0112");
		else if (object.getEmail() == null)
			throw new TicketsAereosBSIException("ER0113");
		else {
			pattern = Pattern.compile(emailMask);
			matcher = pattern.matcher(object.getEmail());
			if (!matcher.matches())
				throw new TicketsAereosBSIException("ER0114");
			else if (object.getNome() == null)
				throw new TicketsAereosBSIException("ER0115");
			else if (object.getSenha() == null)
				throw new TicketsAereosBSIException("ER0116");
			else if (object.getTelefone() == null)
				throw new TicketsAereosBSIException("ER0117");
			else if (object.getUsuario() == null)
				throw new TicketsAereosBSIException("ER0118");
		}

	}

	@Override
	protected boolean validateForFindData(T object) {
		// TODO Auto-generated method stub
		if (object != null) {
			if (StringUtils.isBlank(object.getNome())
					&& StringUtils.isBlank(object.getEmail())
					&& StringUtils.isBlank(object.getTelefone())
					&& StringUtils.isBlank(object.getUsuario())
					&& object.getDataNascimento() == null
					&& !EnderecoBC.getInstance().validateForFindData(
							object.getEndereco())) {

				return false;
			} else
				return true;
		} else {
			return false;
		}
	}
}
