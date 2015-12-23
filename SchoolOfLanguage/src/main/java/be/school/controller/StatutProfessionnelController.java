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
import be.school.repository.StatutProfessionnelRepository;
import be.school.repository.jpa.StatutProfessionelRepositoryJpa;
import be.school.util.NotificationUtil;

/**
 * StatutProfessionnelController class
 * 
 * @author P. Mutanda
 *
 */
@Controller
public class StatutProfessionnelController {

	@Autowired
	private StatutProfessionnelRepository staRepos;

	/**
	 * 
	 * @param staRepos
	 *            statRepos
	 */
	public void setStaRepos(StatutProfessionelRepositoryJpa staRepos) {
		this.staRepos = staRepos;
	}

	/**
	 * 
	 * @param id
	 *            id statutProf
	 * @return retourne la page formulaire
	 */
	@RequestMapping(value = "/statutprofessionnelregister", method = RequestMethod.GET)
	public ModelAndView statutProfessionnelRegister(
			@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mv = new ModelAndView("statutprofessionnelregister");
		StatutProfessionnel statutProfessionnel = null;
		if (id == null) {
			statutProfessionnel = new StatutProfessionnel();
		} else
			statutProfessionnel = staRepos.findById(id);
		mv.addObject("statutProfessionnel", statutProfessionnel);
		return mv;
	}

	/**
	 * 
	 * @param statutProfessionnel
	 *            statutProfessionnel objet
	 * @param errors
	 *            errors l'objet qui gère les erreurs
	 * @return retourne soit le formulaire en cas de failure ou la page home en
	 *         cas de success
	 */
	@RequestMapping(value = "/statutprofessionnelsubmit", method = RequestMethod.POST)
	public ModelAndView statutProfessionnelSubmit(
			@Valid @ModelAttribute StatutProfessionnel statutProfessionnel,
			Errors errors) {
		ModelAndView mv = new ModelAndView();
		if (statutProfessionnel.getPrix() == null) {
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
			// vérification au niveau de la BD si ce statut existe déjà
			if (statutpr == null) {
				mv.setViewName("redirect:home");
				staRepos.save(statutProfessionnel);
				NotificationUtil.addNotificationMessage(statutProfessionnel
						.getStatut() + " est enregistré avec succès");

			} else {
				mv.addObject("messageError", statutProfessionnel.getStatut()
						+ " existe déjà comme statut");
				mv.setViewName("statutprofessionnelregister");
			}

		}
		return mv;
	}

}
// http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html