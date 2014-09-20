package br.pucpr.bsi.prog6.ticketsAereosBSI.bc;

import java.util.List;

import br.pucpr.bsi.prog6.ticketsAereosBSI.model.IdentifierInterface;

public abstract class PatternBC<T extends IdentifierInterface>{
	
	///////////////////////////////////////////////////////////////////
	// METODOS DE BUSCA
	///////////////////////////////////////////////////////////////////
	
	/**
	 * Utilizado para verificar se o id passado nao eh nulo e chamar o metodo
	 * de busca correspondente da classe DAO
	 * 
	 * Devera verificar se o id eh negativo ou null
	 * @param id
	 * @return
	 */
	public abstract T findById(long id);
	
	/**
	 * Utilizado para buscas com o filtro da entidade, onde este contera as
	 * informacoes relacionadas com a filtragem de dados
	 * @param filter
	 * @return
	 */
	public abstract List<T> findByFilter(T filter);
	
	/**
	 * Utilizado para retornar todas as instancias de uma determinada classe,
	 * atraves do metodo de busca correspondente da classe DAO
	 * @return
	 */
	public abstract List<T> findAll();	
	
	///////////////////////////////////////////////////////////////////
	// METODOS DE MODIFICACAO
	///////////////////////////////////////////////////////////////////
	
	/**
	 * Utilizado para realizar a validacao do object e a chamada do metodo de
	 * armazenamento correspondente da classe DAO
	 * 
	 * Devera verificar se o objeto esta de acordo com as regras de negocio
	 * para ser atualizado na base de dados.
	 * @param object
	 * @return
	 */
	public abstract long insert(T object);
	
	/**
	 * Utilizado para realizar a validacao do object e a chamada do metodo de
	 * atualizacao correspondente na classe DAO.
	 * 
	 * Devera verificar se o objeto esta de acordo com as regras de negocio
	 * para ser atualizado na base de dados.
	 * @param object
	 * @return
	 */
	public abstract boolean update(T object);
	
	/**
	 * Utilizado para chamar um metodo de delecao correspondente na classe DAO.
	 * 
	 * Devera verificar se o objeto passado nao eh null
	 * @param object
	 * @return
	 */
	public abstract boolean delete(T object);
	
	///////////////////////////////////////////////////////////////////
	// METODOS DE VALIDACAO
	///////////////////////////////////////////////////////////////////	
	
	/**
	 * Realiza a validacao de um objeto para a insercao ou atualizacao correspondente
	 * da classe DAO
	 * 
	 * As validacoes de regras de negocio deverao ser realizadas nesse metodo
	 * @param object
	 */
	protected abstract void validateForDataModification(T object);
	
	/**
	 * Realiza a validacao de um objeto para a busca de informacoes quando este 
	 * eh um filtro da tela
	 * 
	 * As validacoes de regras de negocio deverao ser realizadas nesse metodo
	 * @param object
	 * @return TODO
	 */
	protected abstract boolean validateForFindData(T object); 	
}
