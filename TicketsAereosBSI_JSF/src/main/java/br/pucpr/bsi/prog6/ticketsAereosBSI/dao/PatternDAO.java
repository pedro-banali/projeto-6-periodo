package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.util.HibernateUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.exception.TicketsAereosBSIException;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.IdentifierInterface;

@SuppressWarnings("serial")
public abstract class PatternDAO<T extends IdentifierInterface> implements Serializable {
	protected String entityClassName;
	protected Logger log;
	
	@SuppressWarnings("rawtypes")
	public PatternDAO(Class entityClass) {
		log = Logger.getLogger(entityClass);
		entityClassName = entityClass.getName();
	}
	
	////////////////////////////////////////////////////////////
	// METODOS DML DE RECUPERACAO DE INFORMACAO
	////////////////////////////////////////////////////////////
	
	/**
	 * Metodo que realiza uma busca pelo id na tabela da entidade T
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T findById(long id) {
		Session session = HibernateUtil.getSession();
		try {
			Query byIdQuery = session.createQuery("FROM " + entityClassName + " as c WHERE c.id = :id");
			byIdQuery.setParameter("id", id);
			return (T) byIdQuery.uniqueResult();
		} catch (Exception e) {
			throw new TicketsAereosBSIException(e);
		}
	}
	
	/**
	 * Utilizado para buscas com o filtro da entidade, onde este contera as
	 * informacoes relacionadas com a filtragem de dados
	 * @param filter
	 * @return
	 */
	public abstract List<T> findByFilter(T filter);
	
	/**
	 * Metodo que realiza a busca de todas as entidades da tabela da entidade T
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Session session = HibernateUtil.getSession();
		try {
			Query listQuery = session.createQuery("FROM " + entityClassName + " as c");
			return listQuery.list();
		} catch (Exception e) {
			throw new TicketsAereosBSIException(e);
		}
	}		
	
	/////////////////////////////////////////
	// METODOS DML COM ALTERACAO NA BASE
	/////////////////////////////////////////
	
	/**
	 * Metodo que realiza um insert na tabela da entidade T
	 * @param obj
	 * @return
	 */
	public Long insert(T obj) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(obj);
			tx.commit();
			log.debug("Nova Linha: " + obj + ", foi comitada. ");
			return obj.getId();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new TicketsAereosBSIException(ex);
		} finally {
			session.close();
		}
	}	
	
	/**
	 * Metodo que realiza um update na tabela da entidade T
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean update(T obj) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			obj = (T) session.merge(obj);
			tx.commit();
			log.debug("Linha: " + obj + ", foi atualizada. ");
			return true;
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new TicketsAereosBSIException(ex);
		} finally {
			session.close();
		}
	}	
	
	/**
	 * Metodo que realiza um delete na tabela da entidade T
	 * @param obj
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public boolean delete(T obj) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			obj = (T) session.merge(obj);
			session.delete(obj);
			tx.commit();
			log.debug("Linha: " + obj + ", foi deletada. ");
			return true;
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new TicketsAereosBSIException(ex);
		} finally {
			session.close();
		}
	}	
	
	
}