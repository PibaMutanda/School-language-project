package be.school.repository.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.enumClass.Jour;
import be.school.enumClass.Seance;
import be.school.model.DetailLocalFormation;
import be.school.model.Formateur;
import be.school.model.Formation;
import be.school.model.Local;
import be.school.repository.DetailLocalFormationRepository;

/**
 * DetailLocalFormationReposytoryJpa class
 * 
 * @author P. Mutanda
 *
 */
@Repository
@Transactional
public class DetailLocalFormationReposytoryJpa extends
		GenericRepositoryJpa<DetailLocalFormation> implements
		DetailLocalFormationRepository {

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<DetailLocalFormation> findAllDistinct() {
		return em
				.createQuery("select distinct df from DetailLocalFormation df")
				.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<DetailLocalFormation> findAllByFormateur(Formateur formateur) {
		Query query = em
				.createQuery("select dlf from DetailLocalFormation dlf where dlf.formateur=:formateur");
		query.setParameter("formateur", formateur);
		return query.getResultList();

	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	public DetailLocalFormation findByLocalSession(Local local, Seance seance,
			Jour jour) {
		DetailLocalFormation detailFormation = null;
		Query query = em
				.createQuery("select df from DetailLocalFormation df  where df.local= :local and  df.seance= :seance and df.jour= :jour");
		query.setParameter("local", local);
		query.setParameter("seance", seance);
		query.setParameter("jour", jour);
		List delofos = query.getResultList();
		// List delofos = em
		// .createQuery(
		// "select df from DetailLocalFormation df  where df.local= :local and  df.seance= :seance and df.jour= :jour")
		// .setParameter("local", local).setParameter("seance", seance)
		// .setParameter("jour", jour).getResultList();
		if (!delofos.isEmpty())
			detailFormation = (DetailLocalFormation) delofos.get(0);
		return detailFormation;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<DetailLocalFormation> findByFormationFormateur( // method not
																// use
			Formation formation, Formateur formateur) {
		return em
				.createQuery(
						"select dlf from DetailLocalFormation dlf where dlf.formation=:formation and dlf.formateur=:formateur")
				.setParameter("formation", formation)
				.setParameter("formateur", formateur).getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<DetailLocalFormation> findAllByFormation(Formation formation) {
		Query query = em
				.createQuery("select dlf from DetailLocalFormation dlf where dlf.formation= :formation");
		query.setParameter("formation", formation);
		return query.getResultList();

	}

	/**
	 * {@inheritDoc}
	 */
	public DetailLocalFormation findByLocalFormationNiveau(Local local,
			Formation formation, String niveau) {
		DetailLocalFormation detailFormation = null;
		Query query = em
				.createQuery("select df from DetailLocalFormation df where df.local= :local and df.formation= :formation and df.niveau=:niveau");
		query.setParameter("local", local);
		query.setParameter("formation", formation);
		query.setParameter("niveau", niveau);
		@SuppressWarnings("unchecked")
		List<DetailLocalFormation> detailLocalFormations = query
				.getResultList();

		if (!detailLocalFormations.isEmpty())
			detailFormation = detailLocalFormations.get(0);
		return detailFormation;
	}

	/**
	 * {@inheritDoc}
	 */
	public DetailLocalFormation findByLocalFormation(Local local,
			Formation formation) {
		DetailLocalFormation detailFormation = null;
		Query query = em
				.createQuery("select df from DetailLocalFormation df where df.local= :local and df.formation= :formation");
		query.setParameter("local", local);
		query.setParameter("formation", formation);
		@SuppressWarnings("unchecked")
		List<DetailLocalFormation> detailLocalFormations = query
				.getResultList();
		if (!detailLocalFormations.isEmpty())
			detailFormation = detailLocalFormations.get(0);
		return detailFormation;
	}

	/**
	 * {@inheritDoc}
	 */
	public Long getParticipantNumber(Local local, Seance seance) {
		return (Long) em
				.createQuery(
						"select count (distinct dlf.participant) from DetailLocalFormation dlf where dlf.local=:local and dlf.seance=:seance")
				.setParameter("local", local).setParameter("seance", seance)
				.getSingleResult();

	}

}
