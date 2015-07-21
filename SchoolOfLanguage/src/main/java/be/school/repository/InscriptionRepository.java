package be.school.repository;

import java.util.Date;
import java.util.List;

import be.school.model.Inscription;

public interface InscriptionRepository extends GenericRepository<Inscription> {

	List<Inscription> findByDate(Date dateInsc);
}
