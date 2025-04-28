package com.andres.demojpa.infraestructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andres.demojpa.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByNameContains(String name);
    List<Person> findByLanguageEquals(String name);
}