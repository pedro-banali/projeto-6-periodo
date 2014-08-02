package br.pucpr.bsi.prog6.ticketsAereosBSI.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class JpaUtil {
	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static EntityManager getEntityManager() {
		if (emf==null){
			emf = Persistence.
				createEntityManagerFactory("Programacao6BD");
		}
		if (em==null || !em.isOpen()){
			em = emf.createEntityManager();
		}
		return em;
	}
	
	public static Session getSession(){
		if(em == null){
			getEntityManager();
		}
		return (Session) em.getDelegate();
	}
}