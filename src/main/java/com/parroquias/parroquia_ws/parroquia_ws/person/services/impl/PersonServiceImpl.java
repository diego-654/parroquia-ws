package com.parroquias.parroquia_ws.parroquia_ws.person.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parroquias.parroquia_ws.parroquia_ws.person.entities.Person;
import com.parroquias.parroquia_ws.parroquia_ws.person.repositories.PersonRepository;
import com.parroquias.parroquia_ws.parroquia_ws.person.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Transactional
    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Transactional
    @Override
    public Optional<Person> update(Person person) {

        Optional<Person> personOptional = personRepository.findById(person.getId());

        if (personOptional.isPresent()) {
            Person p = personOptional.orElseThrow();
            p.setName(person.getName());
            p.setLastName(person.getLastName());
            p.setBirthDate(person.getBirthDate());
            p.setPlaceBirth(person.getPlaceBirth());
            return Optional.of(personRepository.save(p));
        }

        return personOptional;

    }

    @Transactional
    @Override
    public Optional<Person> delete(Long id) {

        Optional<Person> personOptional = personRepository.findById(id);

        personOptional.ifPresent(person -> {
            personRepository.delete(person);
        });

        return personOptional;

    }

}
