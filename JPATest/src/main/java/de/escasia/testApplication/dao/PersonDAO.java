package de.escasia.testApplication.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import de.escasia.testApplication.Entity.Person;

public class PersonDAO extends BaseDAO<Person>{
	
	public PersonDAO(EntityManagerFactory emf, String dbName){
		super(emf.createEntityManager(),dbName);		
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getAllPerson(){
		this.getEm().getTransaction().begin();
		Query query = this.getEm().createQuery("from Person p ");
		List<Person> persons = query.getResultList();
		this.getEm().getTransaction().commit();
		return persons;
	}
}
