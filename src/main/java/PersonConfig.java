

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import io.zipcoder.crudapp.Person;
import io.zipcoder.crudapp.PersonRepository;

@Configuration
public class PersonConfig {
    
    private PersonRepository repository;

    
    @Autowired
    public PersonConfig(PersonRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void setup() {
        repository.save(new Person());
    }
    
}
