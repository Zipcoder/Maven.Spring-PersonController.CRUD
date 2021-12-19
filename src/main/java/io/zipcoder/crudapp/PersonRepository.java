package io.zipcoder.crudapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository // optional
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
