package br.maua.springbootDB.api;

import br.maua.springbootDB.model.Person;
import br.maua.springbootDB.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping    // Método HTTP POST -> Criação
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping     // Método HTTP GET -> Busca
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }
}
