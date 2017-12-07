package be.geertcelerier.test.springboot.demo.service.impl;

import be.geertcelerier.test.springboot.demo.model.Person;
import be.geertcelerier.test.springboot.demo.repository.PersonRepository;
import be.geertcelerier.test.springboot.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getAllPersons() {
        return (List) personRepository.findAll();
    }

    @Override
    public Person getPersonById(UUID uuid) {
        return personRepository.findOne(uuid);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}
