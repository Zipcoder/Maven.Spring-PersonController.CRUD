package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/person_controller")
public class PersonController {
    @Autowired
   private PersonService service;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        return new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read/{id}")
    public ResponseEntity<Person> read(@PathVariable Long id) {
        if(service.read(id)!= null) {
            return new ResponseEntity<>(service.read(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.read(id), HttpStatus.NOT_FOUND);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/readAll")
    public ResponseEntity<List<Person>> readAll(){
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public ResponseEntity<Person> update(
            @PathVariable Long id,
            @RequestBody Person newPersonData) {
        if(service.read(id) != null ) {
            return new ResponseEntity<>(service.update(id, newPersonData), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.create(newPersonData), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public ResponseEntity<Person> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.NO_CONTENT);
    }

}
