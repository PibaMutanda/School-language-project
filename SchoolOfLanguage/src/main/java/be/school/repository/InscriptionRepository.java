package be.school.repository;

import java.util.Date;
import java.util.List;

import be.school.model.Inscription;

/**
 * InscriptionRepository interface
 * 
 * @author P. Mutanda
 *
 */
public interface InscriptionRepository extends GenericRepository<Inscription> {
	/**
	 * 
	 * @param dateInsc
	 *            date d'inscription
	 * @return retourne la liste d'inscriptions
	 */
	List<Inscription> findByDate(Date dateInsc);
}
