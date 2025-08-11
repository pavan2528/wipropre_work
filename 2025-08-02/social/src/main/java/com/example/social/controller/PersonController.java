package com.example.social.controller;

import com.example.social.entity.Person;
import com.example.social.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public Person save(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAllPersons();
    }
}
