package br.maua.springbootDB.service;

import br.maua.springbootDB.dao.PersonDAO;
import br.maua.springbootDB.model.Person;

public class PersonService {

    private final PersonDAO personDAO;

    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public int addPerson(Person person) {
        return personDAO.insertPerson(person);
    }
}
