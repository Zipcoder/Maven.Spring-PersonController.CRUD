package io.zipcoder.crudapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "person-controller")
@RestController
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping(method = RequestMethod.POST,value = "/create")
    public ResponseEntity<Person> create (
            @RequestBody Person person
    ) {
        return new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/people")
    public ResponseEntity<List<Person>> findAll () {
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/people/{id}")
    public ResponseEntity<Person> findOne (
            @PathVariable Long id
    ) {
            return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public ResponseEntity<Person> update (
            @PathVariable Long id,
            @RequestBody Person person
    ) {
            return new ResponseEntity<>(service.update(id, person), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public ResponseEntity<Person> delete (
            @PathVariable Long id
    ) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.NO_CONTENT);
    }
}
