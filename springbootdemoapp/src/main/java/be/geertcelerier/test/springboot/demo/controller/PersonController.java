package be.geertcelerier.test.springboot.demo.controller;

import be.geertcelerier.test.springboot.demo.model.Person;
import be.geertcelerier.test.springboot.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getPersons() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@PathVariable(name = "id") UUID uuid) {
        Person person = personService.getPersonById(uuid);
        HttpStatus httpStatus = getHttpStatusForValidPerson(person);
        return new ResponseEntity<>(person, httpStatus);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<Person> updatePerson(@PathVariable(name = "id") UUID uuid, @RequestBody Person person) {
        HttpStatus httpStatus;
        Person returnedPerson = null;

        if (uuid.equals(person.getId())) {
            returnedPerson = personService.savePerson(person);
            httpStatus = getHttpStatusForValidPerson(returnedPerson);
        } else {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(returnedPerson, httpStatus);
    }

    private HttpStatus getHttpStatusForValidPerson(Person person) {
        HttpStatus httpStatus;
        if (person != null) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return httpStatus;
    }
}
