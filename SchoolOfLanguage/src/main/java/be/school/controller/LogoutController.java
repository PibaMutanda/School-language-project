package be.school.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		return "home";
	}

}
