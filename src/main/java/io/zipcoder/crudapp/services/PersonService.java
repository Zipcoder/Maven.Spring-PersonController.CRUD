package io.zipcoder.crudapp.services;

import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void deletePersonById (Integer id){
        this.personRepository.delete(id);
    }

    public Person updatePerson(Person newPersonData, Integer id){
        Person personToUpdate = this.personRepository.findOne(id);
        personToUpdate.setFirstName(newPersonData.getFirstName());
        personToUpdate.setLastName(newPersonData.getLastName());
        this.personRepository.save(personToUpdate);

        return personToUpdate;
    }

    public Person getPerson(Integer id){
        return this.personRepository.findOne(id);
    }

    public Person createPerson(Person p){
        return this.personRepository.save(p);
    }

    public Iterable<Person> getAll (){
        return this.personRepository.findAll();
    }

}
