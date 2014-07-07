package de.escasia.testApplication.Dto;

public class PersonDto {
	private final String firstName;
	private final String lastName;
	private final String userName;
	
	public PersonDto(String firstName, String lastName, String userName){
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public String toString() {
		return "PersonDto [firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + "]";
	}
	
	
	
}
