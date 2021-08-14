package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepo repo;

    public Person create(Person person){
        return repo.save(person);
    }
    public Person read(Long id){
        return repo.findOne(id);
    }
    public List<Person> readAll(){
        Iterable<Person> personIterable = repo.findAll();
        List<Person> personList = new ArrayList<>();
        personIterable.forEach(personList::add);
        return personList;
    }
    public Person update(Long id, Person person){
        Person newPerson = read(id);
        newPerson.setFirstName(person.getFirstName());
        newPerson.setLastName(person.getLastName());
        newPerson = repo.save(newPerson);
        return newPerson;
    }
    public Person delete(Long id){
        Person newPerson = read(id);
        repo.delete(newPerson);
        return newPerson;
    }
    public Person delete(Person person){
        return delete(person.getId());
    }

}
