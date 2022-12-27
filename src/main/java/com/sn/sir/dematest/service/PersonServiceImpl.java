package com.sn.sir.dematest.service;

import com.sn.sir.dematest.model.Person;
import com.sn.sir.dematest.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    @Override
    public Person getPerson(int id) {
        return personRepository.findById(id).get();
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
