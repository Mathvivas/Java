package br.maua.springbootDB.dao;

import br.maua.springbootDB.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("DAO")  // Classe que acessa o banco de dados diretamente. Possui todas as operações relacionadas com DB.
public class PersonDataAccessService implements PersonDAO {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }
}
