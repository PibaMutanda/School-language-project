package be.school.repository;

import java.util.List;

import be.school.enumClass.Jour;
import be.school.enumClass.Seance;
import be.school.model.DetailLocalFormation;
import be.school.model.Formateur;
import be.school.model.Formation;
import be.school.model.Local;

/**
 * DetailLocalFormationRepository interface
 * 
 * @author P. Mutanda
 *
 */
public interface DetailLocalFormationRepository extends
		GenericRepository<DetailLocalFormation> {

	/**
	 * 
	 * @return
	 *     retourne la liste de detailLocationFormation
	 */
	List<DetailLocalFormation> findAllDistinct();

	/**
	 * 
	 * @param formateur
	 *            formateur
	 * @return retourne la liste de detailLocalFormation du formateur
	 */
	List<DetailLocalFormation> findAllByFormateur(Formateur formateur);

	/**
	 * 
	 * @param local
	 *            local
	 * @param seance
	 *            séance
	 * @param jour
	 *            jour
	 * @return retourne detailLocalFormation
	 */
	DetailLocalFormation findByLocalSession(Local local, Seance seance,
			Jour jour);

	/**
	 * 
	 * @param formation
	 *            formation
	 * @param formateur
	 *            formateur
	 * @return retourne la liste de detailLocalFormation par formation et
	 *         formateur
	 */
	List<DetailLocalFormation> findByFormationFormateur(Formation formation,
			Formateur formateur);

	/**
	 * 
	 * @param formation
	 *            formation
	 * @return retourne la liste de detailLocalFormation par formation
	 */
	List<DetailLocalFormation> findAllByFormation(Formation formation);

	/**
	 * 
	 * @param local
	 *            local
	 * @param formation
	 *            formation
	 * @param niveau
	 *            niveau
	 * @return retourne detailLocalFormation
	 */
	DetailLocalFormation findByLocalFormationNiveau(Local local,
			Formation formation, String niveau);

	/**
	 * 
	 * @param local
	 *            local
	 * @param formation
	 *            formation
	 * @return retourne DetailLocalFormation par local et formation
	 */
	DetailLocalFormation findByLocalFormation(Local local, Formation formation);

	/**
	 * 
	 * @param local
	 *            local
	 * @param seance
	 *            séance
	 * @return retourne Id du participant affecté à un local et une séance
	 *         donnés
	 */
	Long getParticipantNumber(Local local, Seance seance);

}
