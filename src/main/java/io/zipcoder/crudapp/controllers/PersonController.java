package io.zipcoder.crudapp.controllers;

import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/people/")
@RestController
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Integer id){
        return new ResponseEntity<>(this.personService.getPerson(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Person>> getPersonList(){
        return new ResponseEntity<>(this.personService.getAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(this.personService.createPerson(p),HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> updatePerson (Person p, @PathVariable Integer id){
        return new ResponseEntity<>(this.personService.updatePerson(p,id),HttpStatus.OK) ;
    }

    @DeleteMapping("{id}")
    public void deletePersonById(@PathVariable Integer id){
        this.personService.deletePersonById(id);
    }
}
