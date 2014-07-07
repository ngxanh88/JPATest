package de.escasia.testApplication.Service;

import de.escasia.testApplication.dao.AktikelsDAO;
import de.escasia.testApplication.dao.PersonDAO;
import de.escasia.testApplication.dao.UserDAO;



public interface DatabaseService {

	public PersonDAO getPersionDAO();
	
	public AktikelsDAO getAktikelsDAO();
	
	public UserDAO getUserDAO();
}
