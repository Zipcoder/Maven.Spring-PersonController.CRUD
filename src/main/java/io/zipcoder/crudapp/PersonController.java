package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/person_controller")
public class PersonController {
    @Autowired
    private PersonService service;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<Person> create(@RequestBody Person person){
        return  new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/readAll")
    public ResponseEntity<List<Person>> readAll(){
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read/{id}")
    public ResponseEntity<Person> read(@PathVariable Long id){
        if(service.read(id) != null) {
            return new ResponseEntity<>(service.read(id), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(service.read(id), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person){
        if(service.read(id) != null) {
            return new ResponseEntity<>(service.update(id, person), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public ResponseEntity<Person> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.NO_CONTENT);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity<Person> delete(@RequestBody Person person){
        return new ResponseEntity<>(service.delete(person),HttpStatus.NO_CONTENT);
    }
}
