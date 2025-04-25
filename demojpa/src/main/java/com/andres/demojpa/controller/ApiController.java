package com.andres.demojpa.controller;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.andres.demojpa.domain.Person;
import com.andres.demojpa.repository.PersonRepository;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    private final PersonRepository personRepository;

    public ApiController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("users")    
    public List<Person> findAll(){
        List<Person> results= personRepository.findAll();
        return results;
    }

    @GetMapping("languages")
    public List<String> findLanguages(){
        List<Person> results= personRepository.findAll();
        return results.stream().map(Person::getLanguage).distinct().toList();
    }
}