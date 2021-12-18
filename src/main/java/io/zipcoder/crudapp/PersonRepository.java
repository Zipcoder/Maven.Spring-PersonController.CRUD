package io.zipcoder.crudapp;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {

   
    Optional<Person> findById(Long id);

}
