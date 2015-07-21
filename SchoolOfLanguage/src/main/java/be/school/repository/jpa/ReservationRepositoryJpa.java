package be.school.repository.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.Reservation;
import be.school.repository.ReservationRepository;

@Repository
@Transactional
public class ReservationRepositoryJpa extends GenericRepositoryJpa<Reservation> implements ReservationRepository {

	
	@SuppressWarnings("rawtypes")
	public Reservation findByEmail(String email){
		Reservation reservation=null;
		List reservationList=em
				.createQuery(
						"select r from Reservation r where email = :email")
				.setParameter("email", email).getResultList();
		if(!reservationList.isEmpty())
			reservation = (Reservation) reservationList.get(0);
		return reservation;
	}
	
}
