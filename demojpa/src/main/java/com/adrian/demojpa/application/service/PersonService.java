package com.adrian.demojpa.application.service;

import java.util.List;


import com.adrian.demojpa.domain.Person;
import com.adrian.demojpa.domain.Rol;

public interface PersonService {
    public List<Person> findAllUsersByFilter(String filter, String value);
    public List<Rol> findAllRolesByFilter(String filter, String value);
    public Rol createNewRol(String name);
    boolean eliminarPorId(Long id);
    Person saveUser(Person person);
    Person updatePerson(Long id, Person updatePerson);

}
