package proj.my.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import proj.my.entities.Person;
import proj.my.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
@AllArgsConstructor
public class PersonController {
    private PersonRepository personRepository;

    @GetMapping("/persons/by-city")
    public @ResponseBody String getPersonsByCity(@RequestParam("city") String city) {
        return personRepository.getPersonByCity(city)
                .stream()
                .map(Person::toString)
                .collect(Collectors.joining("\n"));
    }

    @GetMapping("/persons/by-age-sorted")
    public @ResponseBody String getPersonsByAgeOrder(@RequestParam("age") int age) {
        return personRepository.getPersonByAgeLessThanOrderByAgeAsc(age)
                .stream()
                .map(Person::toString)
                .collect(Collectors.joining("\n"));
    }

    @GetMapping("/persons/by-name-and_surname-optional")
    public @ResponseBody List<Optional<Person>> getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return personRepository.getPersonByNameAndSurname(name, surname);
    }
}
