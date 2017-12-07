package be.geertcelerier.test.springboot.demo.repository;

import be.geertcelerier.test.springboot.demo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends CrudRepository<Person, UUID> {
}
