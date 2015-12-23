package be.school.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.school.exception.ObjectNotFoundException;
import be.school.model.Employe;
import be.school.model.Formateur;
import be.school.service.LoginService;
import be.school.util.NotificationUtil;

/**
 * LoginController Class
 * 
 * @author P. Mutanda
 *
 */
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	/**
	 * 
	 * @return retourne la page login
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	/**
	 * 
	 * @param login
	 *            login de user
	 * @param password
	 *            mot de passe de user
	 * @param request
	 *            requête
	 * @return retourne ModelAndView
	 */
	@RequestMapping(value = "/loginsubmit", method = RequestMethod.POST)
	public ModelAndView loginSubmit(
			@RequestParam(value = "login") String login,
			@RequestParam("password") String password,
			HttpServletRequest request) {
		String secr = "";
		if (request.getParameter("admin") == null)
			secr = null;

		ModelAndView mv = new ModelAndView("login");
		if (login == null) {
			mv.addObject("messageError", "Saisir le login");
			return mv;
		}
		if (password == null) {
			mv.addObject("messsageError", "Saisir le mot de passe");
			return mv;
		}
		/*
		 * Si secr vaut null traitement pour connection formateur sinon
		 * traitement pour le secrétatiat
		 */
		if (secr == null) {
			try {
				Formateur formateur = loginService.loginFormateur(login,
						password);
				HttpSession sessionFormateur = request.getSession();
				String mySession = formateur.getId() + formateur.getNom();
				sessionFormateur.setAttribute("mySession", mySession);
				sessionFormateur.setAttribute("formateur", formateur);
				NotificationUtil.addNotificationMessage("Welcome "
						+ formateur.getNom());
			} catch (ObjectNotFoundException e) {
				mv.addObject("messageError", "Login ou mot de passe incorrect");
				return mv;
			}
		} else {
			try {

				Employe employe = loginService.loginEmploye(login, password);
				HttpSession sessionEmploye = request.getSession();
				sessionEmploye.setAttribute("employe", employe);
				NotificationUtil.addNotificationMessage("Welcome "
						+ employe.getNom());
			} catch (ObjectNotFoundException e) {
				mv.addObject("messageError", "Login ou mot de passe incorrect");
				return mv;
			}
		}
		mv.setViewName("home");
		return mv;
	}
}
