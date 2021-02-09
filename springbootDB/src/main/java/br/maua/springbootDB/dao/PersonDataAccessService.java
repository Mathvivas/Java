package br.maua.springbootDB.dao;

import br.maua.springbootDB.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PersonDataAccessService implements PersonDAO {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }
}
