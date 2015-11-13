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
	 * retourne la liste de detailLocationFormation
	 * 
	 * @return
	 */
	List<DetailLocalFormation> findAllDistinct();

	/**
	 * 
	 * @param formateur
	 * @return
	 */
	List<DetailLocalFormation> findAllByFormateur(Formateur formateur);

	/**
	 * 
	 * @param local
	 * @param seance
	 * @param jour
	 * @return
	 */
	DetailLocalFormation findByLocalSession(Local local, Seance seance,
			Jour jour);

	/**
	 * 
	 * @param formation
	 * @param formateur
	 * @return
	 */
	List<DetailLocalFormation> findByFormationFormateur(Formation formation,
			Formateur formateur);

	/**
	 * 
	 * @param formation
	 * @return
	 */
	List<DetailLocalFormation> findAllByFormation(Formation formation);

	/**
	 * 
	 * @param local
	 * @param formation
	 * @param niveau
	 * @return
	 */
	DetailLocalFormation findByLocalFormationNiveau(Local local,
			Formation formation, String niveau);

	/**
	 * 
	 * @param local
	 * @param formation
	 * @return
	 */
	DetailLocalFormation findByLocalFormation(Local local, Formation formation);

	/**
	 * 
	 * @param local
	 * @param seance
	 * @return
	 */
	Long getParticipantNumber(Local local, Seance seance);

}
