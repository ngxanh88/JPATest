package de.escasia.testApplication.Service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import de.escasia.testApplication.dao.AktikelsDAO;
import de.escasia.testApplication.dao.PersonDAO;
import de.escasia.testApplication.dao.UserDAO;

public class DatabaseEnviromentHello implements DatabaseService{	

	@PersistenceUnit(unitName="fuckyou")
	private final EntityManagerFactory emf;	
	public DatabaseEnviromentHello(){
		this.emf = Persistence.createEntityManagerFactory("fuckyou");
	}

	public PersonDAO getPersionDAO() {
		return new PersonDAO(emf, "fuckyou");
	}

	public AktikelsDAO getAktikelsDAO() {
		return new AktikelsDAO(emf, "fuckyou");
	}

	public UserDAO getUserDAO() {
		return new UserDAO(emf, "fuckyou");
	}

}
