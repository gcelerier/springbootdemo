package be.geertcelerier.test.springboot.demo.service;


import be.geertcelerier.test.springboot.demo.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    List<Person> getAllPersons();
    Person getPersonById(UUID uuid);
    Person savePerson(Person person);
}
