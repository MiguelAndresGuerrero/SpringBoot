package com.andres.demojpa.application.service;

import java.util.List;


import com.andres.demojpa.domain.Person;

public interface PersonService {
    public List<Person> findAllByFilter(String filter,String value);
}
