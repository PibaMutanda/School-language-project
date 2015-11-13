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
	 * @return
	 */
	Reservation findByEmail(String email);

	/**
	 * 
	 * @param date
	 * @return
	 */
	List<Reservation> findListByDate(Date date);
}
