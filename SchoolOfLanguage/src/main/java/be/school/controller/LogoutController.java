package be.school.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * LogoutController Class
 * 
 * @author P. Mutanda
 *
 */
@Controller
public class LogoutController {

	/**
	 * 
	 * @param request
	 *            requête
	 * @return retourne la home page
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "home";
	}

}
