package de.escasia.testApplication.login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import de.escasia.testApplication.Entity.User;
import de.escasia.testApplication.Entity.UserRoleEnum;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	LoginService loginService = new LoginService();
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		try {
			User user = loginService.getUser(username);
			boolean enabled = true;  
	        boolean accountNonExpired = true;  
	        boolean credentialsNonExpired = true;  
	        boolean accountNonLocked = true;  
			return new org.springframework.security.core.userdetails.User(  
	        		user.getUsername(),   
	                user.getPassword(),   
	                enabled,   
	                accountNonExpired,   
	                credentialsNonExpired,   
	                accountNonLocked,  
	                getAuthorities(user.getRole())
	        );  
		}catch (Exception e) {
			return null;
		}
	}
	
	public Collection<GrantedAuthority> getAuthorities(UserRoleEnum userRole) {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if(userRole.getLabel() == UserRoleEnum.ShopBesitzer.getLabel() || userRole.getLabel() == UserRoleEnum.Manager.getLabel()) {
			authorities.add(new SimpleGrantedAuthority(UserRoleEnum.ShopBesitzer.getLabel()));
			authorities.add(new SimpleGrantedAuthority(UserRoleEnum.Manager.getLabel()));
			authorities.add(new SimpleGrantedAuthority(UserRoleEnum.Mitarbeiter.getLabel()));
		} else {
			authorities.add(new SimpleGrantedAuthority(UserRoleEnum.Mitarbeiter.getLabel()));
		}
		return authorities;		
	}

}
