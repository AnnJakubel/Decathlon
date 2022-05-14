package ee.annjakubel.decathlon.repository;

import ee.annjakubel.decathlon.model.database.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
    Person getByEmail(String email);
}
