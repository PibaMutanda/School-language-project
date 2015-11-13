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
	 * @param dateFin
	 * @return
	 */
	PublicationInscription findByDate(Date dateDeb, Date dateFin);

}
