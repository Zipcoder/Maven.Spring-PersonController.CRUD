package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person create(Person person) {
        return repository.save(person);
    }

    public Person read(Long id) {
        return repository.findOne(id);
                //.get();
    }

    public List<Person> readAll() {
        Iterable<Person> personIterable = repository.findAll();
        List<Person> result = new ArrayList<>();
        personIterable.forEach(result::add);
        return result;
    }

    public Person update(Long id, Person newPersonData) {
        Person personInDd = read(id);
        personInDd.setFirstName(newPersonData.getFirstName());
        personInDd.setLastName(newPersonData.getLastName());
        personInDd = repository.save(personInDd);
        return personInDd;
    }

    public Person delete(Long id) {
        Person personInDb = read(id);
        repository.delete(personInDb);
        return personInDb;
    }

    public Person delete(Person person) {
        return delete(person.getId());
    }

}
