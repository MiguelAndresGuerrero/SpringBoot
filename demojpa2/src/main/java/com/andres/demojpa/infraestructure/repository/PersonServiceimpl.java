package com.andres.demojpa.infraestructure.repository;

import java.util.List;
import org.springframework.stereotype.Service;
import com.andres.demojpa.application.service.PersonService;
import com.andres.demojpa.domain.Person;

@Service
public class PersonServiceimpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceimpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAllByFilter(String filter,String value){
        
        if (filter.toLowerCase().equals("name") && !value.isEmpty()) {
            return personRepository.findByNameContains(value);
        }
        else if (filter.toLowerCase().equals("language") && !value.isEmpty()){
            return personRepository.findByLanguageEquals(value);
        }
        return personRepository.findAll();
    }

}
