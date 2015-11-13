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
	 * @return
	 */
	List<Inscription> findByDate(Date dateInsc);
}
