package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepo repo;

    public Person create(Person person) {
        return repo.save(person);
    }

    public Person read(Long id) {
        return repo.findOne(id);
    }

    public List<Person> readAll() {
        Iterable<Person> personIterable = repo.findAll();
        List<Person> result = new ArrayList<>();
        personIterable.forEach(result::add);
        return result;
    }

    public Person update(Long id, Person personToUpdate) {
        Person personInTheDb = read(id);
        personInTheDb.setFirstName(personToUpdate.getFirstName());
        personInTheDb.setLastName(personToUpdate.getLastName());
        personInTheDb = repo.save(personInTheDb);
        return personInTheDb;
    }

    public Person delete(Long id) {
        Person personInDb = read(id);
        repo.delete(personInDb);
        return personInDb;
    }

    public Person delete(Person person) {
        return delete(person.getId());
    }
}
