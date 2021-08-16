package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

             @Autowired
             private PersonService service;



  @PostMapping(value = "/create")
  public ResponseEntity<Person> create(@RequestBody Person person){
      return new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
  }


  @GetMapping(value = "/read/{id}")
  public ResponseEntity<Person> read(@PathVariable Long id){
      return new ResponseEntity<>(service.read(id), HttpStatus.OK);
  }


  @GetMapping(value = "/all")
  public ResponseEntity<List<Person>> readAll() {
      return  new ResponseEntity<>(service.readAll(), HttpStatus.OK);
  }


  @PutMapping("/update/{id}")
  public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person newPersonData) {
      return new ResponseEntity<>(service.update(id, newPersonData), HttpStatus.OK);
  }


  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Person> delete(@PathVariable Long id){
      return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
  }

}
