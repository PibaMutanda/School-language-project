package be.school.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.school.exception.ObjectAlreadyExistsException;
import be.school.model.Formation;
import be.school.repository.FormationRepository;
import be.school.service.FormationService;
import be.school.util.NotificationUtil;
import be.school.util.SecurityUtils;

/**
 * FormationController class
 * 
 * @author P. Mutanda
 *
 */
@Controller
public class FormationController {

	@Autowired
	FormationService formationService;
	@Autowired
	FormationRepository formationRepositoryJpa;

	/**
	 * 
	 * @param id
	 *            id formation
	 * @return retourne la page formulaire pour enregistrer une formation
	 */
	@RequestMapping(value = "/formationregister", method = RequestMethod.GET)
	public ModelAndView formationRegister(
			@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mv = new ModelAndView("formationregister");
		Formation formation = null;
		if (id == null)
			formation = new Formation();
		else
			formation = formationRepositoryJpa.findById(id);
		mv.addObject("formation", formation);
		return mv;
	}

	/**
	 * 
	 * @param formation
	 *            formation à en registrer
	 * @param errors
	 *            erreurs lors d'encodage
	 * @return retourne soit une page formulaire en cas de failure ou la page
	 *         liste de formations
	 */
	@RequestMapping(value = "/formationsubmit", method = RequestMethod.POST)
	public ModelAndView formationSubmit(
			@Valid @ModelAttribute Formation formation, Errors errors) {

		/*
		 * cette partie de code pour que le système génére lui même le code de
		 * la formation. l'utilisateur ne le gére pas
		 */
		ModelAndView mv = new ModelAndView("formationregister");
		char[] formCode = new char[2];
		try {
			formCode = formation.getTitre().substring(0, 3).toCharArray();
		} catch (Exception e) {
			mv.addObject("messageError", "Saisir le titre de la formation");
			return mv;
		}

		String codeForm = String.valueOf(formCode)
				+ SecurityUtils.generateRandomNumber(4);
		formation.setCodeFormation(codeForm);

		if (errors.hasErrors()) {
			mv.addObject("formation", formation);

		} else {
			try {
				Formation formation1 = formationService.registerFormation(
						formation.getCodeFormation(), formation.getTitre());

				if (formation1 != null) {
					// mv.addObject("id",formation1.getId());
					NotificationUtil.addNotificationMessage(formation1
							.getTitre() + " est enregistrée avec succès");
					mv.setViewName("redirect:formationlist");
				}

			} catch (ObjectAlreadyExistsException e) {
				mv.addObject("messageError",
						"Impossible d'ajouter la formation " + e.getMessage());
				mv.setViewName("formationregister");
				return mv;
			}
		}

		return mv;
	}

	/**
	 * 
	 * @return retourne la liste de formations données
	 */
	@RequestMapping(value = "/formationlist", method = RequestMethod.GET)
	public ModelAndView formationsDisplay() {
		ModelAndView mv = new ModelAndView("formationlistdisplay");
		List<Formation> listFormation = formationRepositoryJpa.findAll();
		mv.addObject("listformations", listFormation);
		return mv;
	}

}