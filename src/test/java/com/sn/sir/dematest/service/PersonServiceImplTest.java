package com.sn.sir.dematest.service;

import com.sn.sir.dematest.model.Person;
import com.sn.sir.dematest.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PersonServiceImplTest {

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonServiceImpl personService;

    @Test
    void createPerson() {
        //Given
        Person person = new Person("Moussa", "tonux@gmail.com", "123456");
        person.setId(1);
        when(personRepository.save(any())).thenReturn(person);

        //When
        Person personResponse = personService.createPerson(person);

        //Then
        assertEquals("Moussa", personResponse.getName());
        assertEquals(1, personResponse.getId());
        verify(personRepository, atLeastOnce()).save(any());
    }

    @Test
    void updatePerson() {
        //TODO : implement this test
        //Given
        Person person = new Person("Moussa", "tonux@gmail.com", "123456");
        person.setName("seck");
        person.setId(1);
        when(personRepository.save(any())).thenReturn(person);

        //When
        Person personResponse = personService.updatePerson(person);

        //Then
        assertEquals("seck", personResponse.getName());
        assertEquals(1, personResponse.getId());
        verify(personRepository, atLeastOnce()).save(any());
    }

    @Test
    void deletePerson() {
        //TODO : implement this test
        //Given
        Person person = new Person("Moussa", "tonux@gmail.com", "123456");
        person.setId(1);
        doNothing().when(personRepository).delete(any());
        //When
        personService.deletePerson(person);
        //Then
        verify(personRepository, atLeastOnce()).delete(any());
    }


    @Test
    void getPerson() {
        //TODO : implement this test
        //Given
        Person person = new Person("Moussa", "tonux@gmail.com", "123456");
        person.setId(1);
        when(personRepository.findById(any())).thenReturn(Optional.of(person));

        //When
        Person personResponse = personService.getPerson(person.getId());

        //Then
        assertEquals("Moussa", personResponse.getName());
        assertEquals(1, personResponse.getId());
        verify(personRepository, atLeastOnce()).findById(any());
    }

    @Test
    void getAllPersons() {
        //TODO : implement this test
        //Given
        Person person = new Person("Moussa", "tonux@gmail.com", "123456");
        person.setId(1);

        when(personRepository.findAll()).thenReturn(new ArrayList<Person>());

        //When
        List<Person> lst = personService.getAllPersons();

        //Then

        assertEquals(0, lst.size());
        verify(personRepository, atLeastOnce()).findAll();
    }
}