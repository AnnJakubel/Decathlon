package ee.annjakubel.decathlon.repository;

import ee.annjakubel.decathlon.model.database.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
}
