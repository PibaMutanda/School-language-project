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

import be.school.model.StatutProfessionnel;
import be.school.repository.jpa.StatutProfessionelRepositoryJpa;

@Controller
public class StatutProfessionnelController {

	@Autowired
	private StatutProfessionelRepositoryJpa staRepos;

	public void setStaRepos(StatutProfessionelRepositoryJpa staRepos) {
		this.staRepos = staRepos;
	}

	@RequestMapping(value = "/statutprofessionnelregister", method = RequestMethod.GET)
	public ModelAndView statutProfessionnelRegister(
			@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mv = new ModelAndView("statutprofessionnelregister");
		StatutProfessionnel statutProfessionnel = null;
		if (id == null) {
			statutProfessionnel = new StatutProfessionnel();
		} else 
			statutProfessionnel = staRepos.findById(id);
			mv.addObject("statutProfessionnel",statutProfessionnel);
		return mv;
	}

	@RequestMapping(value = "/statutprofessionnelsubmit", method = RequestMethod.POST)
	public ModelAndView statutProfessionnelSubmit(
			@Valid @ModelAttribute StatutProfessionnel statutProfessionnel,
			Errors errors) {
		ModelAndView mv = new ModelAndView();
        if(statutProfessionnel.getPrix()==null){
        	mv.addObject("messageError", "Saisir le prix");
        	mv.setViewName("statutprofessionnelregister");
        	return mv;
        }
		// Vérification au niveau validation du controller
		if (errors.hasErrors()) {
			mv.addObject("statutProfessionnel", statutProfessionnel);
			mv.setViewName("statutprofessionnelregister");
		} else {
			statutProfessionnel.setStatut(statutProfessionnel.getStatut()
					.toUpperCase());
			StatutProfessionnel statutpr = staRepos
					.findStatutByName(statutProfessionnel.getStatut());
			// vérification au niveau de la BD
			if (statutpr == null) {
				staRepos.save(statutProfessionnel);
			    mv.addObject("messageSuccess","Statut est enregistré avec succès");
				mv.setViewName("redirect:home");
				
			} else {
				mv.addObject("messageError", statutProfessionnel.getStatut()
						+ " existe déjà comme statut");
				mv.setViewName("statutprofessionnelregister");
				//return mv;
			}

		}
		return mv;
	}

}
// http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html