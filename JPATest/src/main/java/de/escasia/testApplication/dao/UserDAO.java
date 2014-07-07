package de.escasia.testApplication.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import de.escasia.testApplication.Entity.User;
import de.escasia.testApplication.exception.DatabaseException;
import de.escasia.testApplication.exception.TechnicException;


public class UserDAO extends BaseDAO<User>{

//	private final EntityManagerFactory emf;
	
	public UserDAO(EntityManagerFactory emf, String dbName) {
		super(emf.createEntityManager(), dbName);
//		this.emf = emf;
	}

	@SuppressWarnings("unchecked")
	
	public List<User> getAllUser() throws DatabaseException, TechnicException {
		Query query = this.getEm().createQuery("from User u");
		List<User> users = query.getResultList();
		return users;
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		Query query = this.getEm().createQuery("from User u where u.username like :username and u.password like :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		return (User) query.getSingleResult();
	}
	
	public User findByUsername(String username) {
		Query query = this.getEm().createQuery("from User u where u.username like :username",User.class);
		query.setParameter("username", username);
		return (User) query.getSingleResult();
	}
}
