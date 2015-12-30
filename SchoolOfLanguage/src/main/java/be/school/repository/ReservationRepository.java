package be.school.repository;

import java.util.Date;
import java.util.List;

import be.school.model.Reservation;

/**
 * ReservationRepository interface
 * 
 * @author P. Mutanda
 *
 */
public interface ReservationRepository extends GenericRepository<Reservation> {

	/**
	 * 
	 * @param email
	 *            é-mail
	 * @return retourne une réservation pour une inscription
	 */
	Reservation findByEmail(String email);

	/**
	 * 
	 * @param date
	 *            date
	 * @return retourne la liste de réservation par date
	 */
	List<Reservation> findListByDate(Date date);

	
}
