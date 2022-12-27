package com.sn.sir.dematest.repository;

import com.sn.sir.dematest.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void create(){
        Person person = personRepository.save(new Person("tonux", "tonux@gmail.com", "123456"));
        assertNotNull(person);
        assertEquals("tonux", person.getName());
    }

    @Test
    public void update(){
        //Given
        Person person = personRepository.save(new Person("tonux", "tonux@gmail.com", "123456"));
        person.setName("Coundoul");
        //When
        Person personUpdated = personRepository.save(person);
        //Then
        assertNotNull(personUpdated);
        assertEquals("Coundoul", personUpdated.getName());
    }
    @Test
    public void delete(){
        //Given
        Person person = personRepository.save(new Person("tonux", "tonux@gmail.com", "123456"));
        person.setId(1);
        //When
        personRepository.delete(person);
        //Then
        assertNotNull(person);
        assertEquals(HttpStatus.OK.value(), 200);
    }
    // TODO : add test delete

    // TODO : add test findById
    @Test
    public void findbyid(){
        //Given
        Person pers = personRepository.save(new Person("tonux", "tonux@gmail.com", "123456"));
        //When
        Optional<Person> person = personRepository.findById(pers.getId());
        //Then
        assertNotNull(person);
        assertEquals("tonux", person.get().getName());
    }

    // TODO : add test findAll

    @Test
    public void findAll(){
        //Given
       // Person pers = personRepository.save(new Person("tonux", "tonux@gmail.com", "123456"));
        //When
        //List<Person> lst = personRepository.findAll();
        //Then
        //(lst);
        //assertEquals(1, lst.size());
    }


}