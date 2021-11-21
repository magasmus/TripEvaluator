package pl.edu.TripEvaluator.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.TripEvaluator.entity.Trip;


public interface TripRepository extends JpaRepository<Trip, Integer> {
}
