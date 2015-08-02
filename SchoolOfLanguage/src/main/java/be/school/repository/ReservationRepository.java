package be.school.repository;

import java.util.Date;
import java.util.List;

import be.school.model.Reservation;

public interface ReservationRepository extends GenericRepository<Reservation> {

	 Reservation findByEmail(String email);
	 
	 List<Reservation> findListByDate(Date date);
}
