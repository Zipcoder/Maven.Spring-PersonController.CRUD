package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/create")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return new ResponseEntity<>(personService.create(person), HttpStatus.CREATED);
    }

    @GetMapping("/people")
    public ResponseEntity<Iterable<Person>> findAll() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) {
        return new ResponseEntity<>(personService.update(id, person), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Person> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(personService.deleteById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Person> deleteByPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.deletePerson(person), HttpStatus.OK);
    }
}
