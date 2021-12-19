package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController// Annotation
@RequestMapping(value = "/person-controller")

public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person p) {
        return personRepository.save(p);
    }

    @RequestMapping(value = "/people/", method = RequestMethod.GET)
    public List<Person> getPersonList() {
        List<Person> newList = new ArrayList<>();
        for (Person p : personRepository.findAll()) {
            newList.add(p);
        }
        return newList;
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable Integer id) {
        return personRepository.findOne(id);
    }


    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
    public Person updatePerson(@PathVariable Integer id, @RequestBody Person p) {
        p = personRepository.findOne(id);
        return personRepository.save(p);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable Integer id) {
        personRepository.delete(id);
    }
}
