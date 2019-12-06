package io.zipcoder.crudapp.controllers;

import io.zipcoder.crudapp.controllers.PersonController;
import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.repositories.PersonRepository;
import io.zipcoder.crudapp.services.PersonService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class PersonControllerTests {

    @Autowired
    private MockMvc mvc;


    @MockBean
    private PersonRepository repository;

    @Test
    public void testCreatePerson() throws Exception {
        Person newPerson = new Person();
        newPerson.setFirstName("Valentin");
        newPerson.setLastName("G");

        BDDMockito
                .given(repository.save(newPerson))
                .willReturn(newPerson);

        String expectedContent = "{\"ID\":null,\"FIRST_NAME\":\"Valentin\",\"LAST_NAME\":\"G\"}";
        this.mvc.perform(MockMvcRequestBuilders
                .post("/people/")
                .content(expectedContent)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
            )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
}
