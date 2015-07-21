package be.school.repository;

import be.school.model.Local;

public interface LocalRepository extends GenericRepository<Local> {

	Local findByNum(String numLocal);

	Local findByDetalLocalFormation(Long id);
}
