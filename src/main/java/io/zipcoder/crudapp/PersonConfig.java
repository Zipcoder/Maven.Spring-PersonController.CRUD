package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class PersonConfig {
    @Autowired
    private PersonService service;

    @PostConstruct
    public void setup(){
        service.create(new Person(1L, "Raymond","Fitzgerald"));
        service.create(new Person(2L, "Stephanie","Fitzgerald"));
        service.create(new Person(3L, "Kelly", "Fitzgerald"));
        service.create(new Person(4L, "Beans","Fitzgerald"));
    }

}
