package br.maua.springbootDB.api;

import br.maua.springbootDB.model.Person;
import br.maua.springbootDB.service.PersonService;

public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerson(Person person) {
        personService.addPerson(person);
    }
}
