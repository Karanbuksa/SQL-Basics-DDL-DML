package proj.my.repositories;

import proj.my.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Person> getPersonByCity(String city) {
        String queryCommand = "SELECT p FROM persons p WHERE p.cityOfLiving = :city";
        Query query = entityManager.createQuery(queryCommand);
        query.setParameter("city",city);
        return query.getResultList();
    }

}
