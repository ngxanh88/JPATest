package de.escasia.testApplication.Service;

import java.util.ArrayList;
import java.util.List;

import de.escasia.testApplication.Dto.UserDto;
import de.escasia.testApplication.Entity.User;
import de.escasia.testApplication.exception.BussinessException;
import de.escasia.testApplication.exception.DatabaseException;
import de.escasia.testApplication.exception.TechnicException;

public class UserService {
	
	private final DatabaseEnviromentHello env1 = new DatabaseEnviromentHello();
	
	public List<UserDto> getAllUser() throws BussinessException  {
		try {
			return convertToDto(env1.getUserDAO().getAllUser());
		} catch (Exception e) {
			if(e instanceof DatabaseException) {
				throw new BussinessException();
			}else if(e instanceof TechnicException) {
				throw new BussinessException();
			}
		}
		return new ArrayList<UserDto>();
	}

	private List<UserDto>  convertToDto(List<User> userEntity){
		List<UserDto> uDtos = new ArrayList<UserDto>();
		for(User u : userEntity) {
			uDtos.add(new UserDto(u.getUsername(),u.getEmail(),u.getSprache(),u.getRole()));
		}
		return uDtos;
	}
	
	public UserDto login() {
		
		return null;
	}
}
