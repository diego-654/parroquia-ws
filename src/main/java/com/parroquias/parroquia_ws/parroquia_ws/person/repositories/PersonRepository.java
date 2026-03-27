package com.parroquias.parroquia_ws.parroquia_ws.person.repositories;

import org.springframework.data.repository.CrudRepository;

import com.parroquias.parroquia_ws.parroquia_ws.person.entities.Person;


public interface PersonRepository extends CrudRepository<Person, Long> {

}
