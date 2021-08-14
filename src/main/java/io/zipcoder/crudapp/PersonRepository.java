package io.zipcoder.crudapp;

import org.springframework.data.repository.CrudRepository;

import java.util.Map;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
