package proj.my.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import proj.my.entities.Person;
import proj.my.repositories.PersonRepository;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
public class PersonController {
    private PersonRepository personRepository;

    @GetMapping("/persons/by-city")
    @Secured("ROLE_READ")
    public String getPersonsByCity(@RequestParam("city") String city) {
        return personRepository.getPersonByCity(city)
                .stream()
                .map(Person::toString)
                .collect(Collectors.joining("\n"));
    }

    @GetMapping("/persons/by-age-sorted")
    @RolesAllowed("ROLE_WRITE")
    public String getPersonsByAgeOrder(@RequestParam("age") int age) {
        return personRepository.getPersonByAgeLessThanOrderByAgeAsc(age)
                .stream()
                .map(Person::toString)
                .collect(Collectors.joining("\n"));
    }

    @GetMapping("/persons/by-name-and_surname-optional")
    @PostAuthorize("hasAnyRole('ROLE_WRITE','ROLE_DELETE')")
    public List<Optional<Person>> getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return personRepository.getPersonByNameAndSurname(name, surname);
    }

    @GetMapping("/persons/by-username")
    @PreAuthorize("#username == authentication.principal.username")
    public List<Optional<Person>> getPersonsByUsername(@RequestParam("username") String username) {
        return personRepository.getPersonByUsername(username);
    }
}
