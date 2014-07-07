package de.escasia.testApplication.login;

import de.escasia.testApplication.Entity.User;
import de.escasia.testApplication.Service.DatabaseEnviromentHello;

public class LoginService {
	
	private final DatabaseEnviromentHello env1 = new DatabaseEnviromentHello();

	public User getUser(String username, String password) {
		return env1.getUserDAO().findByUsernameAndPassword(username, password);
	}
	
	public User getUser(String username) {
		return env1.getUserDAO().findByUsername(username);
	}
}
