package proj.my.controller;

import proj.my.entities.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import proj.my.repositories.PersonRepository;

import java.util.stream.Collectors;


@AllArgsConstructor
@Controller
public class PersonController {
    private PersonRepository personRepository;

    @GetMapping("/persons/by-city")
    public @ResponseBody String getPersonsByCity(@RequestParam("city") String city) {
        return personRepository.getPersonByCity(city)
                .stream()
                .map(Person::toString)
                .collect(Collectors.joining("\n"));
    }
}
