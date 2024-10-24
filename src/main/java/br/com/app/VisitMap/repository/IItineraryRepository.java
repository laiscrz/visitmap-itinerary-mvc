package br.com.app.VisitMap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItineraryRepository extends JpaRepository<Long, IItineraryRepository> {
}
