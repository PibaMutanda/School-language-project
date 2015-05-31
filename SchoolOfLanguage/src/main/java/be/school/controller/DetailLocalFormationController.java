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

import be.school.model.DetailLocalFormation;
import be.school.model.Formation;
import be.school.model.Local;
import be.school.model.RentreeScolaire;
import be.school.repository.DetailLocalFormationReposytory;
import be.school.repository.FormationRepository;
import be.school.repository.LocalRepository;
import be.school.repository.RentreeScolaireRepository;
import be.school.security.Jour;
import be.school.security.Seance;

@Controller
public class DetailLocalFormationController {

	@Autowired
	private DetailLocalFormationReposytory detailFormationReposytory;

	@Autowired
	private FormationRepository formationRepos;

	@Autowired
	private LocalRepository localRepos;

	@Autowired
	private RentreeScolaireRepository rentreeScoRep;

	@InitBinder
	protected void RegisterFormation(HttpServletRequest request,
			ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Formation.class,
				new PropertyEditorSupport() {
					public void setAsText(String text) {
						Formation formation = formationRepos.findById(Long
								.parseLong(text));
						setValue(formation);
					}
				});
	}

	@InitBinder
	protected void RegisterLocaln(HttpServletRequest request,
			ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Local.class, new PropertyEditorSupport() {
			public void setAsText(String text) {
				Local local = localRepos.findById(Long.parseLong(text));
				setValue(local);
			}
		});
	}

	@InitBinder
	protected void RegisterSchoolYear(HttpServletRequest request,
			ServletRequestDataBinder binder) {
		binder.registerCustomEditor(RentreeScolaire.class,
				new PropertyEditorSupport() {
					public void setAsText(String text) {
						RentreeScolaire retScolaire = rentreeScoRep
								.findById(Long.parseLong(text));
						setValue(retScolaire);
					}
				});
	}

	@RequestMapping(value = "/detailformationregister", method = RequestMethod.GET)
	public ModelAndView detailFormationRegister(
			@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mv = new ModelAndView("detailformationregister");
		DetailLocalFormation detailLocalFormation = null;
		List<Formation> listFormation = formationRepos.findAll();
		List<Local> listLocal = localRepos.findAll();
		// List<RentreeScolaire> listSchoolY = rentreeScoRep.findAll();
		if (id == null) {
			detailLocalFormation = new DetailLocalFormation();
		} else {
			detailLocalFormation = detailFormationReposytory.findById(id);

		}

		mv.addObject("listLocal", listLocal);
		mv.addObject("listFormation", listFormation);
		mv.addObject("detailFormation", detailLocalFormation);
		// mv.addObject("listAnnee", listSchoolY);
		mv.addObject("lesJours", Jour.values());
		return mv;
	}

	@RequestMapping(value = "/detailformationsubmit", method = RequestMethod.POST)
	public ModelAndView detailFormationSubmit(
			@RequestParam(value = "seance", required = false) Seance seance,
			@RequestParam(value = "jour", required = false) Jour jour,
			@Valid @ModelAttribute DetailLocalFormation detailLocalFormation,
			Errors errors) {
		ModelAndView mv = new ModelAndView("detailformationregister");

		if (detailLocalFormation.getFormation() == null
				|| detailLocalFormation.getFormation().equals("".trim())) {
			mv.addObject("messageError",
					"Faites un choix pour le champ formation");
			return mv;
		}

		if (detailLocalFormation.getLocal() == null
				|| detailLocalFormation.getLocal().equals("".trim())) {
			mv.addObject("messageError", "Choisir un local");
			return mv;
		}
		if (Integer.parseInt(detailLocalFormation.getNiveau()) > 9) {
			mv.addObject("messageError",
					"La valeur maximale pour le niveau est de 9");
			return mv;
		}
		if (detailLocalFormation.getJour() == null
				|| detailLocalFormation.getJour().equals("".trim())) {
			mv.addObject("messageError", "Choisir le jour");
			return mv;
		}

		/* verification du quota par rapport à la capacité maximale */
		if (Integer.parseInt(detailLocalFormation.getQuota().trim()) > Integer
				.parseInt(detailLocalFormation.getLocal().getCapacite().trim())) {
			mv.addObject("messageError",
					"Le quota est supérieur à la capacité maximun de "
							+ detailLocalFormation.getLocal().getCapacite());
			return mv;
		}

		if (seance == null) {
			mv.addObject("messageError",
					"Choisir une séance du Matin ou du Soir");
			return mv;
		}

		DetailLocalFormation dLocalFormation = detailFormationReposytory
				.findByLocalSession(detailLocalFormation.getLocal(), seance);
		if (dLocalFormation != null) {
			mv.addObject("messageError",
					"Le local est déjà reservé pour une séance du "
							+ detailLocalFormation.getSeance());
			return mv;
		}

		if (errors.hasErrors()) {
			mv.addObject("detailFormation", detailLocalFormation);
		} else {
			detailLocalFormation.getLocal().setEstLibre(false);
			localRepos.save(detailLocalFormation.getLocal());
			detailFormationReposytory.save(detailLocalFormation);

			mv.addObject("messageSuccess",
					"Detail formation est enregistré avec succès");
			mv.setViewName("redirect:home");

		}

		return mv;
	}

	@RequestMapping(value = "/detailformation", method = RequestMethod.GET)
	public ModelAndView detailFormation(Long id) {
		DetailLocalFormation detailLocalFormation = detailFormationReposytory
				.findById(id);
		ModelAndView mv = new ModelAndView("detailformation");
		mv.addObject("detailformation", detailLocalFormation);
		return mv;
	}

	@ModelAttribute
	public Formation findFormation(
			@RequestParam(value = "formation", required = false) Long id) {
		Formation formation = null;
		if (id == null)
			formation = new Formation();
		else
			formation = formationRepos.findById(id);
		return formation;
	}

	@ModelAttribute
	public Local findLocal(
			@RequestParam(value = "locaux", required = false) Long id) {
		Local local = null;
		if (id == null)
			local = new Local();
		else
			local = localRepos.findById(id);
		return local;
	}

	@ModelAttribute
	public RentreeScolaire findSchoolYear(
			@RequestParam(value = "rentreeScolaires", required = false) Long id) {
		RentreeScolaire rentreeSc = null;
		if (id == null)
			rentreeSc = new RentreeScolaire();
		else
			rentreeSc = rentreeScoRep.findById(id);
		return rentreeSc;
	}
}
