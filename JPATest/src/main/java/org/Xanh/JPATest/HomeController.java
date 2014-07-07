package org.Xanh.JPATest;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.escasia.testApplication.Dto.PersonDto;
import de.escasia.testApplication.Dto.UserDto;
import de.escasia.testApplication.Service.FilterService;
import de.escasia.testApplication.Service.UserService;
import de.escasia.testApplication.exception.BussinessException;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	@Inject
//	private AuthenticationManager authenticationManager;
	private Authentication auth;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		auth = SecurityContextHolder.getContext().getAuthentication();
		
		logger.info("User: "+auth.getName());
		logger.info("Role: "+auth.getAuthorities().size());
		logger.info("Role: "+auth.getAuthorities().toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		String testString = "Hello world";
		
		model.addAttribute("helloWorld", testString );
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
//	/**
//	 * Simply selects the home view to render by returning its name.
//	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model,
						@RequestParam(value = "error", required = false) String error,
						@RequestParam(value = "logout", required = false) String logout) {
		//database  get Person(id)
		
		 auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {

		    /* The user is logged in :) */			
		    return adminPage(model);
		}
		
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		
		return "login";
	}
	
	@RequestMapping("/greeting")
	public @ResponseBody List<PersonDto> filterPerson(
			@RequestParam(value="name", required=false, defaultValue="World") String name) {
		FilterService filterService = new FilterService();

		return filterService.filter();
	}
	
	@RequestMapping("/user")
	public @ResponseBody List<UserDto> allUser() {
		UserService userSer = new UserService();

		try {
			return userSer.getAllUser();
		} catch (BussinessException e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		
		model.addAttribute("title", "Spring Security Custom Login Form");
		model.addAttribute("message", "This is protected page!");
 
		return "admin";
	}
}
