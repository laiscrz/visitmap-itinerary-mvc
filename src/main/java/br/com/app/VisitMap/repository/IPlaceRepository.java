package br.com.app.VisitMap.repository;

import br.com.app.VisitMap.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceRepository extends JpaRepository<Long, Place> {
}
