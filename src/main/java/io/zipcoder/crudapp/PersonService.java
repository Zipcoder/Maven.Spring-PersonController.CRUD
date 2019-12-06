package io.zipcoder.crudapp;


import org.springframework.stereotype.Service;

@Service
public class PersonService {

        private PersonRepository repository;
        //private Person person;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Iterable<Person> findAllPeople () {
        return repository.findAll();
    }

    public Person findOnePerson (Integer id){
        return repository.findOne(id);
    }

    public Person createPerson (Person person){
        return repository.save(person);
    }

    public Person updatePerson (Person person) {
        Person personInDB = repository.findOne(person.getId());
        personInDB.setFirstName(person.getFirstName());
        personInDB.setLastName(person.getLastName());
        return repository.save(personInDB);
    }

    public void deletePerson (Integer id) {
        repository.delete(id);
    }
}
