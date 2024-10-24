package br.com.app.VisitMap.repository;

import br.com.app.VisitMap.model.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItineraryRepository extends JpaRepository<Itinerary, Long> {
}
