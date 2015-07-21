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

import be.school.model.Local;
import be.school.repository.jpa.LocalRepositoryJpa;

@Controller
public class LocalController {

	@Autowired
	LocalRepositoryJpa localRepositoryJpa;

	@RequestMapping(value = "/localregister", method = RequestMethod.GET)
	public ModelAndView localRegister(
			@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mv = new ModelAndView("localregister");
		Local local = null;
		if (id == null) {
			local = new Local();
		} else {
			local = localRepositoryJpa.findById(id);
		}
		mv.addObject("local", local);
		return mv;
	}

	@RequestMapping(value = "/localsubmit", method = RequestMethod.POST)
	public ModelAndView localSubmit(@Valid @ModelAttribute Local local,
			Errors errors) {
		ModelAndView mv = new ModelAndView("localregister");
		
		if (errors.hasErrors()) {
			mv.addObject("local", local);
		} else {
			Local local2 = localRepositoryJpa.findByNum(local.getNumLocal());
			if(local2!=null){
				mv.addObject("messageError","Local existe déjà");
				return mv;
			}
			local.getNumLocal().trim();
			localRepositoryJpa.save(local);
			mv.addObject("messageSuccess","Local est enregistré avec succès");
			mv.setViewName("redirect:home");
		}
		return mv;
	}
}
