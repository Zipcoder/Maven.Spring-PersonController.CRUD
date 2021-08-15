package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/person-controller")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping(value = "/create")
    // exposed at localhost:8080/person-controller/create
    public ResponseEntity<Person> create(@RequestBody Person person) { // `@RequestBody` allows us to inject JSON objects (representative of POJO instances) into our Spring server from our front-end client (mocked by Postman)
        return new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
    }
    @GetMapping(value = "/getPerson/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id){
        return new ResponseEntity<>(service.read(id),HttpStatus.OK);
    }
    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Person>> getPersonList(){
        return new ResponseEntity<>(service.readAll(),HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Integer id, @RequestBody Person newPersonData){
        return new ResponseEntity<>(service.update(id,newPersonData),HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Person> DeletePerson(@PathVariable Integer id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }
}
