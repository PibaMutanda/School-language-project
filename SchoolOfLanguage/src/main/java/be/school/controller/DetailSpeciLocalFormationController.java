package be.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import be.school.enumClass.Jour;
import be.school.enumClass.Seance;
import be.school.model.DetailLocalFormation;
import be.school.model.Formateur;
import be.school.model.Formation;
import be.school.model.Local;
import be.school.repository.DetailLocalFormationRepository;
import be.school.repository.FormateurRepository;
import be.school.repository.FormationRepository;
import be.school.repository.LocalRepository;
import be.school.repository.ParticipantRepository;
import be.school.service.DetailLocalFormationService;
import be.school.util.NotificationUtil;

/**
 * DetailSpeciLocalFormationController class
 * 
 * @author P. Mutanda
 *
 */
@Controller
public class DetailSpeciLocalFormationController {

	@Autowired
	private DetailLocalFormationRepository dReposytory;

	@Autowired
	private FormationRepository formationRep;

	@Autowired
	private LocalRepository localRep;

	@Autowired
	private DetailLocalFormationService detailLocServ;

	@Autowired
	private FormateurRepository formateurRep;

	@Autowired
	private ParticipantRepository participantRep;

	/**
	 * 
	 * @param titre
	 *            titre de la formation
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = "/detailFormation", method = RequestMethod.GET)
	public @ResponseBody ModelAndView detailSpeciLocalFormation(
			@RequestParam String titre) {
		ModelAndView mv = new ModelAndView("detailformation");
		Local local = null;
		Formation formation = formationRep.findByTitre(titre);
		List<DetailLocalFormation> detailLocalFormations = dReposytory
				.findAllByFormation(formation);
		if (detailLocalFormations.size() > 0) {
			local = localRep.findByDetalLocalFormation(detailLocalFormations
					.get(0).getId());
			mv.addObject("local", local);
		}
		mv.addObject("detailLocalFormations", detailLocalFormations);
		mv.addObject("formation", formation);

		return mv;
	}

	/**
	 * 
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = "/detaillocalformdisplay", method = RequestMethod.GET)
	public ModelAndView detailLocalFormDisplay() {
		ModelAndView mv = new ModelAndView("detaillocalformdisplay");
		List<DetailLocalFormation> listDetailLocalForm = dReposytory.findAll();
		/*
		 * Calcul des places disponibles
		 */
		Long tabDisp[] = new Long[listDetailLocalForm.size()];
		int i = 0;
		for (DetailLocalFormation detailLocalFormation : listDetailLocalForm) {
			Long disp = Long.parseLong(detailLocalFormation.getQuota())
					- dReposytory.getParticipantNumber(
							detailLocalFormation.getLocal(),
							detailLocalFormation.getSeance());

			tabDisp[i++] = disp;
		}
		mv.addObject("listDetLocalForm", listDetailLocalForm);
		mv.addObject("tabDispo", tabDisp);
		return mv;
	}

	/**
	 * 
	 * @param id
	 *            id du detailLocaLformation
	 * @return une vue
	 */
	@RequestMapping(value = "/deleteDetailLocalForm", method = RequestMethod.GET)
	public String deleteDetailLocalFormation(@RequestParam(value = "id") Long id) {
		NotificationUtil
				.addNotificationMessage("suppression effectuée avec succès");
		dReposytory.delete(id);
		return "detaillocalformdisplay";
	}

	/**
	 * 
	 * @param id
	 *            du detail à modifier
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = "/updateDetailLocalForm", method = RequestMethod.GET)
	public ModelAndView updateDetailLocalForm(
			@RequestParam(value = "id") Long id) {
		ModelAndView mv = new ModelAndView("updateDetailLocalForm");
		DetailLocalFormation detailLocalFormation = dReposytory.findById(id);
		List<Formation> formations = formationRep.findAll();
		List<Local> locaux = localRep.findAll();
		mv.addObject("detailLocalFormation", detailLocalFormation);
		mv.addObject("locaux", locaux);
		mv.addObject("formations", formations);
		mv.addObject("jours", Jour.values());
		mv.addObject("seances", Seance.values());

		return mv;
	}

	/**
	 * 
	 * @param id
	 *            id du detaillocalFormation
	 * @param formation
	 *            formation donnée
	 * @param local
	 *            local
	 * @param jour
	 *            jour
	 * @param seance
	 *            seance
	 * @param niveau
	 *            niveau
	 * @param quota
	 *            quota
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = "/updatedetaillocalformsubmit", method = RequestMethod.POST)
	public ModelAndView updateDetailLocalFormSubmit(
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "formation") Long formation,
			@RequestParam(value = "local") Long local,
			@RequestParam(value = "jour") Jour jour,
			@RequestParam(value = "seance") Seance seance,
			@RequestParam(value = "niveau") String niveau,
			@RequestParam(value = "quota") String quota) {
		ModelAndView mv = new ModelAndView("updateDetailLocalForm");
		Local local1 = localRep.findById(local);
		if (Integer.parseInt(local1.getCapacite()) < Integer.parseInt(quota)) {
			mv.addObject("messageError",
					"le quota dépasse la capacité maximale");
			return mv;
		}
		if (Integer.parseInt(niveau) > 9) {
			mv.addObject("messageError", "le niveau maximale est 9");
			return mv;
		}
		Formation formation1 = formationRep.findById(formation);
		if (detailLocServ.isCheckForUpdate(local1, formation1, jour, seance) == false) {
			mv.addObject("messageError", "Mise à jour non autorisée");
			return mv;
		}
		if (dReposytory.findByLocalSession(local1, seance, jour) != null) {
			mv.addObject("messageError",
					"Le local est déjà reservé pour une séance du " + jour
							+ "  " + seance);
			return mv;
		}
		DetailLocalFormation detailLocalFormation = dReposytory.findById(id);
		detailLocalFormation.setFormation(formationRep.findById(formation));
		detailLocalFormation.setLocal(local1);
		detailLocalFormation.setJour(jour);
		detailLocalFormation.setNiveau(niveau);
		detailLocalFormation.setQuota(quota);
		detailLocalFormation.setSeance(seance);
		dReposytory.save(detailLocalFormation);
		NotificationUtil
				.addNotificationMessage("Modification est faites avec succès!");
		mv.setViewName("redirect:detaillocalformdisplay");
		return mv;
	}

	/**
	 * 
	 * @param id
	 *            id du formateur
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = "/displayprofplanning", method = RequestMethod.GET)
	public ModelAndView displayProfPlanning(@RequestParam(value = "id") Long id) {
		Formateur formateur = formateurRep.findById(id);
		List<DetailLocalFormation> listPlanningProf = dReposytory
				.findAllByFormateur(formateur);
		Long tab[] = new Long[listPlanningProf.size()];
		int cpt = 0;
		for (DetailLocalFormation detailLocalFormation : listPlanningProf) {
			tab[cpt++] = participantRep
					.getTotalParticipant(detailLocalFormation.getId());
		}
		ModelAndView mv = new ModelAndView("displayprofplanning");
		mv.addObject("planningProf", listPlanningProf);
		mv.addObject("totalPart", tab);
		return mv;
	}

	/**
	 * 
	 * @param id
	 *            id du detailLocalformation
	 * @return {@link ModelAndView}
	 */
	@RequestMapping(value = "/listparticipant", method = RequestMethod.GET)
	public ModelAndView showListParticipants(@RequestParam(value = "id") Long id) {
		return new ModelAndView("listparticipant", "listdeparticipant",
				participantRep.getParticipantListByDetailLocalFormation(id));
	}

	/**
	 * 
	 * @param titre
	 *            titre de la formation
	 * @return retourne une formation
	 */
	@ModelAttribute
	public Formation findFormation(
			@RequestParam(value = "formation", required = false) String titre) {
		Formation formation = null;
		if (titre == null)
			formation = new Formation();
		else
			formation = formationRep.findByTitre(titre);
		return formation;
	}
}
