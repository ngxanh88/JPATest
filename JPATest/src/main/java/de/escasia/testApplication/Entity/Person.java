package de.escasia.testApplication.Entity;

import javax.persistence.Entity;

@Entity
public class Person extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Person [getId()=" + getId() + "]";
	}

}
