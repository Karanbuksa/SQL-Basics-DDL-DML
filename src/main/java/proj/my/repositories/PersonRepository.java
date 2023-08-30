package proj.my.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proj.my.entities.Person;
import proj.my.entities.PersonID;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonID> {

    @Transactional
    @Query("select p from persons p where p.city = :city")
    List<Person> getPersonByCity(@Param("city") String city);

    @Transactional
    @Query("select p from persons p where p.age < :age order by p.age asc")
    List<Person> getPersonByAgeLessThanOrderByAgeAsc(@Param("age") int age);

    @Transactional
    @Query("select p from persons p where p.name = :name and p.surname = :surname")
    List<Optional<Person>> getPersonByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

    @Transactional
    @Query("select p from persons p where p.name = :name")
    List<Optional<Person>> getPersonByUsername(@Param("name") String name);
}
