package be.school.repository.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.PublicationInscription;
import be.school.repository.PublicationInscriptionRepository;

/**
 * PublicationInscriptionRepositoryJpa class
 * 
 * @author P. Mutanda
 *
 */
@Repository
@Transactional
public class PublicationInscriptionRepositoryJpa extends
		GenericRepositoryJpa<PublicationInscription> implements
		PublicationInscriptionRepository {

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public PublicationInscription findByDate(Date dateDeb, Date dateFin) {
		PublicationInscription publicationInscription = null;
		List<PublicationInscription> listPubl = em
				.createNamedQuery("PublicationInscription.findByDate")
				.setParameter("dateDebInscr", dateDeb)
				.setParameter("dateFinInscr", dateFin).getResultList();
		if (!listPubl.isEmpty())
			publicationInscription = listPubl.get(0);
		return publicationInscription;
	}

	// public void delete(PublicationInscription publicationInscription) {
	// if(publicationInscription.getId()!=null)
	// em.remove(publicationInscription);
	// else {
	// throw new
	// ObjectNotFoundException("Publication inscription non existante !");
	// }
	// }
}
