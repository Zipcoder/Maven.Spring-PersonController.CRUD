package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person create(Person person){
        return repository.save(person);
    }

    public Person read(Integer id) {
        return repository.findById(id).get();
    }

    public List<Person> readAll() {
        Iterable<Person> personIterable = repository.findAll();
        List<Person> result = new ArrayList<>();
        personIterable.forEach(result::add);
        return result;
    }

    public Person update(Integer id, Person newPersonData) {
        Person personInDatabase = read(id);
        personInDatabase.setFirstName(newPersonData.getFirstName());
        personInDatabase.setLastName(newPersonData.getLastName());
        return repository.save(personInDatabase);
    }

    public Person delete(Person person) {
        repository.delete(person);
        return person;
    }

    public Person delete(Integer id) {
        return delete(read(id));
    }
}
