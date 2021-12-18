package io.zipcoder.crudapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Person> create(Person personRequestedToPersist) {
        Person personInDatabase = repository.save(personRequestedToPersist);
        ResponseEntity<Person> responseEntity = new ResponseEntity<>(personInDatabase, HttpStatus.CREATED);
        return responseEntity;
    }

    public ResponseEntity<Person> read(Long id) {
        Person personInDatabase = repository.findById(id).get();
        return new ResponseEntity<>(personInDatabase, HttpStatus.OK);
    }

    public List<Person> readAll() {
        Iterable<Person> allPeople = repository.findAll();
        List<Person> personList = new ArrayList<>();
        allPeople.forEach(personList::add);
        return personList;
    }

    public ResponseEntity<Person> update(Long id, Person newData) {
        Person personInDatabase = repository.findById(id).get();
        String newFirstName = newData.getFirstName();
        String newLastName = newData.getLastName();
        personInDatabase.setFirstName(newFirstName);
        personInDatabase.setLastName(newLastName);
        personInDatabase = repository.save(personInDatabase);
        return new ResponseEntity<>(personInDatabase, HttpStatus.OK);
    }
    public ResponseEntity<Person> delete(Long id) {
        Person personToBeDeleted = repository.findById(id).get();
        repository.delete(id);
        return new ResponseEntity<>(personToBeDeleted, HttpStatus.OK);
    }
    
}
