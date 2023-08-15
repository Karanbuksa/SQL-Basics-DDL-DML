package proj.my.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proj.my.entities.Person;
import proj.my.entities.PersonID;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonID> {

    @Transactional
    List<Person> getPersonByCity(String city);

    @Transactional
    List<Person> getPersonByAgeLessThanOrderByAgeAsc(int age);

    @Transactional
    List<Optional<Person>> getPersonByNameAndSurname(String name, String surname);

}
