package de.escasia.testApplication.Dto;

import de.escasia.testApplication.Entity.UserRoleEnum;

public class UserDto {

	private final String username;
	private final String email;
	private final String Sprache;
	private final UserRoleEnum role;
	
	public UserDto(String username, String email, String sprache, UserRoleEnum role) {
		this.username = username;
		this.email = email;
		this.Sprache = sprache;
		this.role = role;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getSprache() {
		return Sprache;
	}
	
	public UserRoleEnum getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "UserDto [username=" + username + ", email=" + email
				+ ", Sprache=" + Sprache + "]";
	}
	
	
}
