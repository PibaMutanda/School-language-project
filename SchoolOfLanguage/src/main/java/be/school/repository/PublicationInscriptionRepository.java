package be.school.repository;

import java.util.Date;

import be.school.model.PublicationInscription;

/**
 * PublicationInscriptionRepository interface
 * 
 * @author P. Mutanda
 *
 */
public interface PublicationInscriptionRepository extends
		GenericRepository<PublicationInscription> {

	/**
	 * 
	 * @param dateDeb
	 *            date de début
	 * @param dateFin
	 *            date de fin
	 * @return retourne publication inscription
	 */
	PublicationInscription findByDate(Date dateDeb, Date dateFin);

}
