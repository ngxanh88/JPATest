package de.escasia.testApplication.Service;

import java.util.ArrayList;
import java.util.List;

import de.escasia.testApplication.Dto.PersonDto;
import de.escasia.testApplication.Entity.Person;
import de.escasia.testApplication.exception.BussinessException;
import de.escasia.testApplication.exception.DatabaseException;
import de.escasia.testApplication.exception.TechnicException;

public class FilterService {
	
	private final DatabaseEnviromentHello env1 = new DatabaseEnviromentHello();
	
	public List<PersonDto> filter(){

		return convertToDto(env1.getPersionDAO().getAllPerson());
		
	}
	
	public void addPerson(Person p) throws BussinessException {
		try {
			env1.getPersionDAO().create(p);
		} catch (DatabaseException e) {
			throw new BussinessException();
		} catch (TechnicException e) {
			throw new BussinessException();
		}
	}
	
	private List<PersonDto>  convertToDto(List<Person> personEntities){
		List<PersonDto> personDtos = new ArrayList<PersonDto>();
		for(Person p : personEntities){
			p.getId();
			PersonDto personDto = new PersonDto("", "laster", "username");
			personDtos.add(personDto);
		}
		return personDtos;
	}
}
