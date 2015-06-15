package be.school.controller;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import be.school.util.SecurityUtils;

@Controller
public class FormateurController {

	@Autowired
	private FormateurRepository formateurRepository;

	@Autowired
	private FormationRepository formationRepository;

	@InitBinder
	protected void RegisterFormation(HttpServletRequest request,
			ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Formation.class,
				new PropertyEditorSupport() {
					public void setAsText(String text) {
						Formation formation = formationRepository.findById(Long
								.parseLong(text));
						setValue(formation);
					}
				});
	}

	@RequestMapping(value = "/formateurregister", method = RequestMethod.GET)
	public ModelAndView formateurRegister(
			@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mv = new ModelAndView("formateurregister");
		Formateur formateur = null;
		if (id == null)
			formateur = new Formateur();
		else
			formateur = formateurRepository.findById(id);
		mv.addObject("formateur", formateur);
		return mv;
	}

	@RequestMapping(value = "/formateursubmit", method = RequestMethod.POST)
	public ModelAndView formateurSubmit(
			@Valid @ModelAttribute Formateur formateur, Errors errors) {
		ModelAndView mv = new ModelAndView();
		if (errors.hasErrors()) {
			mv.addObject("formateur", formateur);
			mv.setViewName("formateurregister");
		} else {
			formateur.setPassword(SecurityUtils.md5Encode(formateur
					.getPassword()));
			mv.addObject("messageSuccess",
					" Formateur est  enregistré avec succès");
			mv.addObject("listFormateur", formateurRepository.findAll());
			formateurRepository.save(formateur);
			mv.setViewName("redirect:formateurlist");

		}
		return mv;
	}

	@RequestMapping(value = "/formateurlist", method = RequestMethod.GET)
	public ModelAndView formateurDisplay() {
		ModelAndView mv = new ModelAndView("formateurlist");
		List<Formateur> formateurlist = formateurRepository.findAll();
		mv.addObject("formateurlist", formateurlist);
		return mv;
	}

	@RequestMapping(value = "/updateFormateur", method = RequestMethod.GET)
	public String updateFormateurDisplay() {
		/*
		 * Cette méthode retourne la page updateFormateur
		 */
		return "updateFormateur";
	}

	@RequestMapping(value = "/updateformateursubmit", method = RequestMethod.POST)
	public ModelAndView updateFormateurSubmit(@RequestParam("id") Long id,
			@RequestParam(value = "oldpassword") String oldpassword,
			@RequestParam("nouvpassword") String noupassword,
			@RequestParam("confpassword") String confpassword) {
		ModelAndView mv = new ModelAndView("updateFormateur");
		/*
		 * Cette méthode traite de la modification de password
		 */
		Formateur formateur = formateurRepository.findById(id);
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
		formateurRepository.save(formateur);
		mv.addObject("messageSuccess",
				"La modification   est  enregistrée avec succès");
		mv.setViewName("redirect:home");
		return mv;
	}
}
