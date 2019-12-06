package io.zipcoder.crudapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonRepository extends CrudRepository <Person, Integer> {
}
