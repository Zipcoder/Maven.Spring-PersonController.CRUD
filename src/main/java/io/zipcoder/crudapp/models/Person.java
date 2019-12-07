package io.zipcoder.crudapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
    private String first_NAME;
    private String last_NAME;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Person(){

    }

    public String getFirst_NAME() {
        return first_NAME;
    }

    public String getLast_NAME() {
        return last_NAME;
    }

    public int getId() {
        return id;
    }

    public void setFirst_NAME(String firstName) {
        this.first_NAME = firstName;
    }

    public void setLast_NAME(String lastName) {
        this.last_NAME = lastName;
    }
}
