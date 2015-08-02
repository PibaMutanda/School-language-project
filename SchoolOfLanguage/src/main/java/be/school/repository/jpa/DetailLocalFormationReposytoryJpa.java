package be.school.repository.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.enumClass.Seance;
import be.school.model.DetailLocalFormation;
import be.school.model.Formateur;
import be.school.model.Formation;
import be.school.model.Local;
import be.school.repository.DetailLocalFormationRepository;

@Repository
@Transactional
public class DetailLocalFormationReposytoryJpa extends
		GenericRepositoryJpa<DetailLocalFormation> implements
		DetailLocalFormationRepository {

	@SuppressWarnings("unchecked")
	public List<DetailLocalFormation> findAllDistinct() {
		return em
				.createQuery("select distinct df from DetailLocalFormation df")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<DetailLocalFormation> findAllByFormateur(Formateur formateur) {
		return em
				.createQuery(
						"select dlf from DetailLocalFormation dlf where dlf.formateur=:formateur")
				.setParameter("formateur", formateur).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public DetailLocalFormation findByLocalSession(Local local, Seance seance) {
		DetailLocalFormation detailFormation = null;
		List delofos = em
				.createQuery(
						"select df from DetailLocalFormation df  where df.local= :local and  df.seance= :seance")
				.setParameter("local", local).setParameter("seance", seance)
				.getResultList();
		if (!delofos.isEmpty())
			detailFormation = (DetailLocalFormation) delofos.get(0);
		return detailFormation;
	}

	@SuppressWarnings("unchecked")
	public List<DetailLocalFormation> findByFormationFormateur(
			Formation formation, Formateur formateur) {
		return em
				.createQuery(
						"select dlf from DetailLocalFormation dlf where dlf.formation=:formation and dlf.formateur=:formateur")
				.setParameter("formation", formation)
				.setParameter("formateur", formateur).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<DetailLocalFormation> findAllByFormation(Formation formation) {
		return em
				.createQuery(
						"select dlf from DetailLocalFormation dlf where dlf.formation= :formation")
				.setParameter("formation", formation).getResultList();
	}

	public DetailLocalFormation findByLocalFormationNiveau(Local local,
			Formation formation, String niveau) {
		DetailLocalFormation detailFormation = null;

		List<DetailLocalFormation> detailLocalFormations = em
				.createQuery(
						"select df from DetailLocalFormation df where df.local= :local and df.formation= :formation and df.niveau=:niveau",
						DetailLocalFormation.class)
				.setParameter("local", local)
				.setParameter("formation", formation)
				.setParameter("niveau", niveau).getResultList();
		if (!detailLocalFormations.isEmpty())
			detailFormation = detailLocalFormations.get(0);
		return detailFormation;
	}

	public DetailLocalFormation findByLocalFormation(Local local,
			Formation formation) {
		DetailLocalFormation detailFormation = null;
		@SuppressWarnings("unchecked")
		List<DetailLocalFormation> detailLocalFormations = em
				.createQuery(
						"select df from DetailLocalFormation df where df.local= :local and df.formation= :formation")
				.setParameter("local", local)
				.setParameter("formation", formation).getResultList();
		if (!detailLocalFormations.isEmpty())
			detailFormation = detailLocalFormations.get(0);
		return detailFormation;
	}

	public Long getParticipantNumber(Local local, Seance seance) {
		return (Long) em
				.createQuery(
						"select count (distinct dlf.participant) from DetailLocalFormation dlf where dlf.local=:local and dlf.seance=:seance")
				.setParameter("local", local).setParameter("seance", seance)
				.getSingleResult();

	}

}
