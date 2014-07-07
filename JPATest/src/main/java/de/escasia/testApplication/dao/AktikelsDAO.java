package de.escasia.testApplication.dao;

import javax.persistence.EntityManagerFactory;

import de.escasia.testApplication.Entity.Aktikels;

public class AktikelsDAO extends BaseDAO<Aktikels>{

	public AktikelsDAO(EntityManagerFactory emf, String dbName) {
		super(emf.createEntityManager(), dbName);
		
	}

}
