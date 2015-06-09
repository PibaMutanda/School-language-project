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

import be.school.model.DetailLocalFormation;
import be.school.model.Formateur;
import be.school.model.Formation;
import be.school.model.Local;
import be.school.repository.DetailLocalFormationReposytory;
import be.school.repository.FormateurRepository;
import be.school.repository.FormationRepository;
import be.school.repository.LocalRepository;
import be.school.repository.ParticipantRepository;
import be.school.security.Jour;
import be.school.security.Seance;
import be.school.service.DetailLocalFormationService;

@Controller
public class DetailSpeciLocalFormationController {

	@Autowired
	private DetailLocalFormationReposytory dReposytory;

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

	@RequestMapping(value = "/deleteDetailLocalForm", method = RequestMethod.GET)
	public String deleteDetailLocalFormation(@RequestParam(value = "id") Long id) {
		dReposytory.remove(id);
		return "detaillocalformdisplay";
	}

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
			mv.addObject("messageError", "Mise à jour non autorisé");
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
		mv.setViewName("redirect:detaillocalformdisplay");
		return mv;
	}

	@RequestMapping(value = "/displayprofplanning", method = RequestMethod.GET)
	public ModelAndView displayProfPlanning(@RequestParam(value = "id") Long id) {
		Formateur formateur = formateurRep.findById(id);
		List<DetailLocalFormation> listPlanningProf = dReposytory
				.findAllByFormateur(formateur);
		Long tab[] = new Long[listPlanningProf.size()];
		int cpt=0;
		for (DetailLocalFormation detailLocalFormation : listPlanningProf) {
               tab[cpt++]=participantRep.getTotalParticipant(detailLocalFormation.getId());
		}
		ModelAndView mv=new ModelAndView("displayprofplanning");
		mv.addObject("planningProf",listPlanningProf);
		mv.addObject("totalPart", tab);
		return mv;
	}

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
