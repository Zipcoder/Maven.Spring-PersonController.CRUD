package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/person-controller")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/create")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return new ResponseEntity<>(personService.create(person), HttpStatus.CREATED);
    }
    @GetMapping(value ="/people")
    public ResponseEntity<Iterable<Person>> readAll() {
        return new ResponseEntity<>(personService.readAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> read(@PathVariable Long id){
        return  new ResponseEntity<>(personService.read(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id,@RequestBody Person person){
        return new ResponseEntity<>(personService.update(id,person),HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Person> delete(@PathVariable Long id){
        return new ResponseEntity<>(personService.delete(id),HttpStatus.OK);
    }
//    @DeleteMapping(value = "/delete/person")
//    public ResponseEntity<Person> delete(@RequestBody Person person){
//        return new ResponseEntity<>(personService.delete(person),HttpStatus.OK);
//    }
}