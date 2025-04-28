package com.andres.demojpa.infraestructure.controller;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.andres.demojpa.application.service.PersonService;
import com.andres.demojpa.domain.Person;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    private final PersonService personService;

    public ApiController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/users")    
    public List<Person> findAll(
        @RequestParam(defaultValue = "") String filter,
        @RequestParam(defaultValue = "") String value
    ){

        List<Person> results= personService.findAllByFilter(filter,value);
        
        return results;
    }

}
