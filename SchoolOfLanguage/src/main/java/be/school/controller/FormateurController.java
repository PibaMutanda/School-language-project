package be.school.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.school.model.Formateur;
import be.school.repository.FormateurRepository;
import be.school.util.SecurityUtils;

@Controller
public class FormateurController {

	@Autowired
	private FormateurRepository formateurRepository;

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
			mv.addObject("messageSuccess"," Formateur est  enregistré avec succès");
			formateurRepository.save(formateur);
			mv.setViewName("redirect:home");
		}
		return mv;
	}
}
