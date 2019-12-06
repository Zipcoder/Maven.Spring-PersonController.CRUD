package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PersonController {
    @Autowired
    private PersonService service;

    @PostMapping("/people")
    public ResponseEntity<Person> createPerson (@RequestBody Person person){
    return new ResponseEntity<>(service.createPerson(person), HttpStatus.CREATED);
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson (@PathVariable Integer id){
    return new ResponseEntity<>(service.findOnePerson(id), HttpStatus.OK);
    }

    @GetMapping("/people")
    public ResponseEntity<Iterable<Person>> getPersonList () {
    return new ResponseEntity<>(service.findAllPeople(), HttpStatus.OK);
    }

    @PutMapping("/people")
    public ResponseEntity<Person> updatePerson (@RequestBody Person person){
    return new ResponseEntity<>(service.updatePerson(person), HttpStatus.OK);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable Integer id){
        return new ResponseEntity<>(service.deletePerson(id), HttpStatus.OK);
    }
}
