package com.sn.sir.dematest.controller;

import com.sn.sir.dematest.model.Person;
import com.sn.sir.dematest.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonController personController;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    PersonRepository personRepository;
    @LocalServerPort
    private int port;

    @Test
    public void Hello(){
        String name= "tonux";
        String url = "http://localhost:" + port + "/api/person/hello?name="+name;
        String response = restTemplate.getForObject(url, String.class);
        assertEquals("Hello "+name, response);
    }

    @Test
    void getAllPerson() throws Exception {
        //Given
        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/person")
                .contentType(MediaType.APPLICATION_JSON);

        //When
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        //Then
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void getPerson() throws Exception {
        // TODO : add test getPerson
        int name= 1;
        String url = "http://localhost:" + port + "/api/person/"+name;
        Person response = restTemplate.getForObject(url, Person.class);
        assertEquals(0, response.getId());

    }

    @Test
    void createPerson() throws Exception {
        // TODO : add test createPerson
        Person person = new Person("tonux", "tonux@gmail.com", "123456");
        person.setId(1);
        //Given

        String url = "http://localhost:" + port + "/api/person";
        Person response = restTemplate.postForObject(url,person,Person.class);
        assertEquals(person.getName(), response.getName());


    }

    @Test
    void updatePerson() {
        // TODO : add test updatePerson
        Person person = new Person("tonux", "tonux@gmail.com", "123456");
        person.setId(1);
        person.setName("seck");
        //Given

        String url = "http://localhost:" + port + "/api/person/1";
       restTemplate.put(url,person);
        assertEquals("seck", person.getName());
    }

    @Test
    void deletePerson() {


    }
}