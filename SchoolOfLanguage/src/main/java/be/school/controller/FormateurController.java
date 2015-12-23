package be.school.controller;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.school.model.Formateur;
import be.school.model.Formation;
import be.school.repository.FormateurRepository;
import be.school.repository.FormationRepository;
import be.school.util.NotificationUtil;
import be.school.util.SecurityUtils;

/**
 * FormateurController controller class
 * 
 * @author P. Mutanda
 *
 */
@Controller
public class FormateurController {

	@Autowired
	private FormateurRepository formateurRepositoryJpa;

	@Autowired
	private FormationRepository formationRepositoryJpa;

	@InitBinder
	protected void RegisterFormation(HttpServletRequest request,
			ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Formation.class,
				new PropertyEditorSupport() {
					public void setAsText(String text) {
						Formation formation = formationRepositoryJpa
								.findById(Long.parseLong(text));
						setValue(formation);
					}
				});
	}

	/**
	 * 
	 * @param id
	 *            id du formateur
	 * @return une vue pour enregistrer un formateur
	 */
	@RequestMapping(value = "/formateurregister", method = RequestMethod.GET)
	public ModelAndView formateurRegister(
			@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mv = new ModelAndView("formateurregister");
		Formateur formateur = null;
		if (id == null)
			formateur = new Formateur();
		else
			formateur = formateurRepositoryJpa.findById(id);
		mv.addObject("formateur", formateur);
		return mv;
	}

	/**
	 * 
	 * @param formateur
	 *            données du formateur
	 * @param errors
	 *            message d'erreur à envoyer en cas de failure
	 * @return retourne soit une success vue ou le formulaire en cas de failure
	 */
	@RequestMapping(value = "/formateursubmit", method = RequestMethod.POST)
	public ModelAndView formateurSubmit(
			@Valid @ModelAttribute Formateur formateur, Errors errors) {
		ModelAndView mv = new ModelAndView();
		if (errors.hasErrors()) {
			mv.addObject("formateur", formateur);
			mv.setViewName("formateurregister");
		} else {
			mv.setViewName("redirect:formateurlist");
			formateur.setPassword(SecurityUtils.md5Encode(formateur
					.getPassword()));
			mv.addObject("listFormateur", formateurRepositoryJpa.findAll());
			formateurRepositoryJpa.save(formateur);
			NotificationUtil.addNotificationMessage(formateur.getNom()
					+ "  est enregistré avec succès");

		}
		return mv;
	}

	/**
	 * 
	 * @return retourne la liste des formateurs
	 */
	@RequestMapping(value = "/formateurlist", method = RequestMethod.GET)
	public ModelAndView formateurDisplay() {
		ModelAndView mv = new ModelAndView("formateurlist");
		List<Formateur> formateurlist = formateurRepositoryJpa.findAll();
		mv.addObject("formateurlist", formateurlist);
		return mv;
	}

	/**
	 * 
	 * @return retourne la page updateFormateur
	 */
	@RequestMapping(value = "/updateFormateur", method = RequestMethod.GET)
	public String updateFormateurDisplay() {

		return "updateFormateur";
	}

	/**
	 * 
	 * @param id
	 *            id du formateur
	 * @param oldpassword
	 *            ancien mot de passe
	 * @param noupassword
	 *            nouveau mot de passe
	 * @param confpassword
	 *            nouveau mot de passe
	 * @return retourne le formulaire en cas de failure ou home page en cas de
	 *         success
	 */
	@RequestMapping(value = "/updateformateursubmit", method = RequestMethod.POST)
	public ModelAndView updateFormateurSubmit(@RequestParam("id") Long id,
			@RequestParam(value = "oldpassword") String oldpassword,
			@RequestParam("nouvpassword") String noupassword,
			@RequestParam("confpassword") String confpassword) {
		ModelAndView mv = new ModelAndView("updateFormateur");
		/*
		 * Cette méthode traite de la modification du password
		 */
		Formateur formateur = formateurRepositoryJpa.findById(id);
		String motdepasse = SecurityUtils.md5Encode(oldpassword);
		if (!motdepasse.equals(formateur.getPassword())) {
			mv.addObject("messageError", "L'ancien password n'est pas correct");
			return mv;
		}
		if (!noupassword.equals(confpassword)) {
			mv.addObject("messageError",
					"Saisir le même password de confirmation");
			return mv;
		}
		formateur.setPassword(SecurityUtils.md5Encode(noupassword));
		formateurRepositoryJpa.save(formateur);
		NotificationUtil
				.addNotificationMessage("La modification   est  enregistrée avec succès");
		mv.setViewName("redirect:home");
		return mv;
	}
}
