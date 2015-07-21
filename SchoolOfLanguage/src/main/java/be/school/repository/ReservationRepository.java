package be.school.repository;

import be.school.model.Reservation;

public interface ReservationRepository extends GenericRepository<Reservation> {

	 Reservation findByEmail(String email);
}
