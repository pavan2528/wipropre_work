package com.example.social.service;

import com.example.social.entity.Person;
import com.example.social.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        person.getPosts().forEach(post -> post.setPerson(person)); 
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
