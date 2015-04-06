package be.school.repository;

import java.io.PrintStream;
import java.sql.BatchUpdateException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.school.model.Reservation;

@Repository
public class ReservationRepository {

	@PersistenceContext
	private EntityManager em;
	
	public Reservation findById(Long id){
		return em.find(Reservation.class, id);
	}
	
	public void save(Reservation reservation){
		if(reservation.getId()==null){
			em.persist(reservation);
		}
		else {
			em.merge(reservation);
		}
	}
	
	public List<Reservation> findAll(){
		return em.createQuery("select r from Reservation r").getResultList();
	}
	
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
