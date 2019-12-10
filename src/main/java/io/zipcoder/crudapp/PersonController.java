package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping("/people")
    public Person createPerson(@RequestBody Person p) {
        return personRepository.save(p);
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        return new ResponseEntity<>(personRepository.findOne(id), HttpStatus.OK);
    }

    @GetMapping("/people")
    public ResponseEntity<Iterable<Person>> getPersonList() {
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable Long id) {
        if (person.getId() != null) {
            return new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(createPerson(person), HttpStatus.OK);
        }
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable Long id) {
        personRepository.delete(id);
        return new ResponseEntity<>(true,HttpStatus.NO_CONTENT);
    }

}
