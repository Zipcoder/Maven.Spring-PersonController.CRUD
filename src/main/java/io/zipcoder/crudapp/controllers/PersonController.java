package io.zipcoder.crudapp.controllers;

import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private PersonRepository pr;

    @Autowired
    public PersonController(PersonRepository pr){
        this.pr = pr;
    }

    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(pr.save(p), HttpStatus.CREATED);
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id){
        return new ResponseEntity<>(pr.findOne(id), HttpStatus.OK);
    }

    @GetMapping("/people")
    public ResponseEntity<Iterable <Person>> getPersonList(){
        return new ResponseEntity<>(pr.findAll(), HttpStatus.OK);
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person p){
        Person ogPerson = pr.findOne(id);
        ogPerson.setFirstName(p.getFirstName());
        ogPerson.setLastName(p.getLastName());
        return new ResponseEntity<>(pr.save(ogPerson), HttpStatus.OK);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity deletePerson(@PathVariable int id){
        pr.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
