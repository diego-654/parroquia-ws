package com.parroquias.parroquia_ws.parroquia_ws.person.services;

import java.util.List;
import java.util.Optional;

import com.parroquias.parroquia_ws.parroquia_ws.person.entities.Person;

public interface PersonService {

    List<Person> findAll();

    Optional<Person> findById(Long id);

    Person create(Person person);

    Optional<Person> update(Person person);

    Optional<Person> delete(Long id);

}
