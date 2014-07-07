package de.escasia.testApplication.dao;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;

import de.escasia.testApplication.exception.DatabaseException;
import de.escasia.testApplication.exception.TechnicException;

public class BaseDAO<T> {
	
//	@PersistenceContext
	private final EntityManager em;
	private final String dbName;
	
	public BaseDAO(EntityManager em, String dbName){
		this.em = em;
		this.dbName = dbName;
	}

	public void create(T entity) throws DatabaseException, TechnicException{
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch(Exception e) {
			if(e instanceof EntityExistsException) {
				throw new DatabaseException(dbName, "MySQL", "Entity is already existed");
			} else if(e instanceof TransactionRequiredException) {
				throw new DatabaseException(dbName, "MySQL", "Transaction fehlt");
			} else {
				throw new TechnicException();
			}
		}
	}
	
	public void update(T entity) throws DatabaseException, TechnicException{
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if(e instanceof TransactionRequiredException) {
				throw new DatabaseException(dbName, "MySQL", "Transaction fehlt");
			} else {
				throw new TechnicException();
			}
		}
	}
	
	public void delete(T entity) throws DatabaseException, TechnicException{
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if(e instanceof TransactionRequiredException) {
				throw new DatabaseException(dbName, "MySQL", "Transaction fehlt");
			} else {
				throw new TechnicException();
			}
		}
	}
	
	public EntityManager getEm(){
		return em;
	}
}
